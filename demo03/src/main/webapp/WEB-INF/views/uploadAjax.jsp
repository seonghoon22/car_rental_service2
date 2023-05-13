<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	.fileDrop {
		width: 100%;
		height: 200px;
		border: 1px dotted blue;
	}

</style>
<script src="//code.jquery.com/jquery-1.11.3.min.js"></script>
<script>
	$(document).ready(function() {

		$(".fileDrop").on("dragenter dragover", function(event){
			event.preventDefault();
		});
	
		$(".fileDrop").on("drop", function(event){
			event.preventDefault();

			// .fileDrop 선택자에 해당하는 태그영역에 드래그되었던 파일정보를 참조하는 구문.
			let files = event.originalEvent.dataTransfer.files;

			let file = files[0];
			//console.log(file);

			// <form>태그에 해당하는 의미.
			let formData = new FormData();
			// <input type="file"> 태그를 통한 첨부파일 선택
			formData.append("file", file);

			// ajax를 통한 파일전송
			/* 댓글기능에서 사용안했는 데. 기본값이 true 였다.
			processData: true(기본값) 
			contentType: true(기본값) 
			*/

			$.ajax({
				url:'/uploadAjax',
				data: formData,    // 클라이언에서 서버로 보내는 데이터(파일)
				dataType: 'text', // 서버로부터 받은 응답데이터 포맷
				processData: false, // 클라이언트에서 데이터를 서버로보낼때, 내부적으로 쿼리스트링 형태로 만들어진다. 파일전송시는 false로 주어 쿼리스트링형태로 생성되지 않게 한다. 
				contentType: false, // "multipart/form-data" 인코딩으로 데이타 보낼경우
				type:'POST',
				success: function(data){
					// 일반파일, 이미지 파일에 따라서 작업방향이 분기가된다.
					//1)썸네일 이미지파일 "/2021/08/23/s_a95f633e-7fea-44a8-aada-a6504f14f05c_1.jpg"
					//2)일반파일  "/2021/08/23/a95f633e-7fea-44a8-aada-a6504f14f05c_1.hwp"
					//console.log(data); 

					let str = "";
					//이미지 파일일 경우
					if(checkImageType(data)){
						str = "<div><a href='displayFile?fileName=" + getImageLink(data) + "'>";
						str += "<img src='displayFile?fileName=" + data + "'/></a>";
						str += "<small style='cursor:pointer;' data-src=" + data + ">X</small></div>";
					}else{ // 일반파일일 경우
						str = "<div><a href='displayFile?fileName=" + data + "'>";
						str += getOriginalName(data) + "</a>";
						str += "<small style='cursor:pointer;' data-src=" + data + ">X</small></div>";
					}

					console.log(str);

					$(".uploadedList").append(str);

				}
			});
		});


		// X를 클릭해서 파일삭제작업

		$(".uploadedList").on("click", "small", function(event){
			let that = $(this);

			$.ajax({
				url:"deleteFile",
				type:"post",
				data:{fileName: $(this).attr("data-src")},
				dataType:"text",
				success: function(result) {
					if(result == 'deleted') {
						that.parent("div").remove();
					}
				}

			});
		});

	});
	
	function checkImageType(fileName){

		let pattern = /jpg|gif|png|jpeg/i;

		return fileName.match(pattern);
	}

	// 이미지 파일일때 사용 함수: 원본이미지 파일명
	// fileName : "/2021/08/23/s_a95f633e-7fea-44a8-aada-a6504f14f05c_1.jpg"
	// 결과 : "/2021/08/23/a95f633e-7fea-44a8-aada-a6504f14f05c_1.jpg"
	function getImageLink(fileName){

		if(!checkImageType(fileName)) {
			return;
		}

		let front = fileName.substr(0,12);  // "/2021/08/23/"
		let end = fileName.substr(14);  //  "a95f633e-7fea-44a8-aada-a6504f14f05c_1.jpg"

		return front + end;  // 원본이미지 파일명


	}


	// 일반파일 사용 함수 : 1.hwp
	// "/2021/08/23/a95f633e-7fea-44a8-aada-a6504f14f05c_1.hwp"
	function getOriginalName(fileName) {
		if(checkImageType(fileName)) {
			return;
		}

		let idx = fileName.indexOf("_") + 1; // 인덱스가 0부터 시작

   		return fileName.substr(idx);  // 1.hwp


	}

</script>
</head>
<body>
	<h3>Ajax File Upload</h3>
	<div class="fileDrop"></div>
	
	<div class="uploadedList"></div>
	
</body>
</html>