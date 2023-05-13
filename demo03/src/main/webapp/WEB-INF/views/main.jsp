<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!doctype html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="">
    <meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
    <meta name="generator" content="Hugo 0.80.0">
    <title>Pricing example · Bootstrap v4.6</title>

    

    

    <!-- Bootstrap core CSS, JQuery -->
<%@ include file="/WEB-INF/views/includes/common.jsp"  %>

<script>

  $(function(){

    $("div a.detail").on("click", function(e){
      
      e.preventDefault();
      let pdt_num = $(this).attr("href");

      location.href = "/product/get?pdt_num=" + pdt_num;

    });
    
    // 장바구니 추가작업
    $(".btnCartAdd").on("click", function(){

      let pdt_num_pk = $(this).data("pdt_num_pk");   // EL문법
      let cart_amount = 1;  // jQuery() -> $()

      $.ajax({
        url : '/cart/cartAdd',
        type: 'post',
        dataType: 'text',
        data: {pdt_num_pk : pdt_num_pk, cart_amount : cart_amount},
        
        beforeSend: function(xmlHttpRequest) {
          xmlHttpRequest.setRequestHeader("AJAX", "true");
        },
        
        success: function(data){
          alert("성공" + data);
          let result = confirm("장바구니에 추가되었습니다.\n 지금 확인하시겠습니까?");
          if(result){
            location.href = "/cart/list"; // 장바구니 목록.  인증여부 확인요청주소
          }
        }
      });

    });

    // 바로구매 추가작업
    $(".btnDirectOrder").on("click", function(){

      let pdt_num_pk = $(this).data("pdt_num_pk"); 
      
      location.href = "/order/orderInfo?pdt_num_pk=" + pdt_num_pk;

       

    });
  });


</script>
<script>
 let msg = "${msg}";
 if(msg == "modifySuccess"){
	 alert("회원수정이 되었습니다.");
 }
</script>

<meta name="theme-color" content="#563d7c">


    <style>
      .bd-placeholder-img {
        font-size: 1.125rem;
        text-anchor: middle;
        -webkit-user-select: none;
        -moz-user-select: none;
        -ms-user-select: none;
        user-select: none;
      }

      @media (min-width: 768px) {
        .bd-placeholder-img-lg {
          font-size: 3.5rem;
        }
      }
    </style>

    
    
  </head>
  <body>
    
<!-- 상단메뉴 -->
<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<%@ include file="/WEB-INF/views/includes/mainCategory.jsp" %>

<div class="container">

  <div id="carouselExampleControls" class="carousel slide" data-ride="carousel">
  <div class="carousel-inner">
    <div class="carousel-item active">
      <img src="/image/1.gif" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/image/1.gif" class="d-block w-100" alt="...">
    </div>
    <div class="carousel-item">
      <img src="/image/1.gif" class="d-block w-100" alt="...">
    </div>
  </div>
  <a class="carousel-control-prev" href="#carouselExampleControls" role="button" data-slide="prev">
    <span class="carousel-control-prev-icon" aria-hidden="true"></span>
    <span class="sr-only">Previous</span>
  </a>
  <a class="carousel-control-next" href="#carouselExampleControls" role="button" data-slide="next">
    <span class="carousel-control-next-icon" aria-hidden="true"></span>
    <span class="sr-only">Next</span>
  </a>
</div>


<!-- 1차 카테고리별 상품4개 출력 -->

<!-- 1차 카테고리 : TOP -->
<div class="row">
  <c:forEach items="${topList }" var="vo">
  	<div class="col-md-3">
          <div class="card mb-4 shadow-sm">
            <a href="${vo.pdt_num_pk }" class="detail">
            	<img src="/product/displayFile?fileName=${vo.pdt_img }" alt="이미지" height="200px">
            </a>
            <div class="card-body">
              <p class="card-text">${vo.pdt_name }</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary btnDirectOrder" data-pdt_num_pk="${vo.pdt_num_pk}">buy</button>
                  <button type="button" class="btn btn-sm btn-outline-secondary btnCartAdd" data-pdt_num_pk="${vo.pdt_num_pk}">cart</button>
                </div>
                <!-- <small class="text-muted">테스트</small> -->
              </div>
            </div>
          </div>
        </div>
   </c:forEach>
   
  </div>

<!-- 1차 카테고리 : SHIRTS -->
<div class="row">
  <c:forEach items="${shirtsList }" var="vo">
  	<div class="col-md-3">
          <div class="card mb-4 shadow-sm">
            <a href="${vo.pdt_num_pk }" class="detail">
            	<img src="/product/displayFile?fileName=${vo.pdt_img }" alt="이미지" height="200px">
            </a>
            <div class="card-body">
              <p class="card-text">${vo.pdt_name }</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary btnDirectOrder" data-pdt_num_pk="${vo.pdt_num_pk}">buy</button>
                  <button type="button" class="btn btn-sm btn-outline-secondary btnCartAdd" data-pdt_num_pk="${vo.pdt_num_pk}">cart</button>
                </div>
                <!-- <small class="text-muted">테스트</small> -->
              </div>
            </div>
          </div>
        </div>
   </c:forEach>
   
  </div>
  
  
  <!-- 1차 카테고리 : PANTS -->
  <div class="row">
  <c:forEach items="${pantsList }" var="vo">
  	<div class="col-md-3">
          <div class="card mb-4 shadow-sm">
            <a href="${vo.pdt_num_pk }" class="detail">
            	<img src="/product/displayFile?fileName=${vo.pdt_img }" alt="이미지" height="200px">
            </a>
            <div class="card-body">
              <p class="card-text">${vo.pdt_name }</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary btnDirectOrder" data-pdt_num_pk="${vo.pdt_num_pk}">buy</button>
                  <button type="button" class="btn btn-sm btn-outline-secondary btnCartAdd" data-pdt_num_pk="${vo.pdt_num_pk}">cart</button>
                </div>
                <!-- <small class="text-muted">테스트</small> -->
              </div>
            </div>
          </div>
        </div>
   </c:forEach>
   
  </div>
  
  
  <!-- 1차 카테고리 : OUTER -->
  <div class="row">
  <c:forEach items="${outerList }" var="vo">
  	<div class="col-md-3">
          <div class="card mb-4 shadow-sm">
            <a href="${vo.pdt_num_pk }" class="detail">
            	<img src="/product/displayFile?fileName=${vo.pdt_img }" alt="이미지" height="200px">
            </a>
            <div class="card-body">
              <p class="card-text">${vo.pdt_name }</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary btnDirectOrder" data-pdt_num_pk="${vo.pdt_num_pk}">buy</button>
                  <button type="button" class="btn btn-sm btn-outline-secondary btnCartAdd" data-pdt_num_pk="${vo.pdt_num_pk}">cart</button>
                </div>
                <!-- <small class="text-muted">테스트</small> -->
              </div>
            </div>
          </div>
        </div>
   </c:forEach>
   
  </div>
  
  <!-- 1차 카테고리 : SHOES/BAG -->
  <div class="row">
  <c:forEach items="${shoesbagList }" var="vo">
  	<div class="col-md-3">
          <div class="card mb-4 shadow-sm">
            <a href="${vo.pdt_num_pk }" class="detail">
            	<img src="/product/displayFile?fileName=${vo.pdt_img }" alt="이미지" height="200px">
            </a>
            <div class="card-body">
              <p class="card-text">${vo.pdt_name }</p>
              <div class="d-flex justify-content-between align-items-center">
                <div class="btn-group">
                  <button type="button" class="btn btn-sm btn-outline-secondary btnDirectOrder" data-pdt_num_pk="${vo.pdt_num_pk}">buy</button>
                  <button type="button" id="btnCartAdd" class="btn btn-sm btn-outline-secondary btnCartAdd" data-pdt_num_pk="${vo.pdt_num_pk}">cart</button>
                </div>
                <!-- <small class="text-muted">테스트</small> -->
              </div>
            </div>
          </div>
        </div>
   </c:forEach>
   
  </div>

  <!-- 
  <div class="card-deck mb-3 text-center">
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">Free</h4>
      </div>
      <div class="card-body">
        <h1 class="card-title pricing-card-title">$0 <small class="text-muted">/ mo</small></h1>
        <ul class="list-unstyled mt-3 mb-4">
          <li>10 users included</li>
          <li>2 GB of storage</li>
          <li>Email support</li>
          <li>Help center access</li>
        </ul>
        <button type="button" class="btn btn-lg btn-block btn-outline-primary">Sign up for free</button>
      </div>
    </div>
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">Pro</h4>
      </div>
      <div class="card-body">
        <h1 class="card-title pricing-card-title">$15 <small class="text-muted">/ mo</small></h1>
        <ul class="list-unstyled mt-3 mb-4">
          <li>20 users included</li>
          <li>10 GB of storage</li>
          <li>Priority email support</li>
          <li>Help center access</li>
        </ul>
        <button type="button" class="btn btn-lg btn-block btn-primary">Get started</button>
      </div>
    </div>
    <div class="card mb-4 shadow-sm">
      <div class="card-header">
        <h4 class="my-0 font-weight-normal">Enterprise</h4>
      </div>
      <div class="card-body">
        <h1 class="card-title pricing-card-title">$29 <small class="text-muted">/ mo</small></h1>
        <ul class="list-unstyled mt-3 mb-4">
          <li>30 users included</li>
          <li>15 GB of storage</li>
          <li>Phone and email support</li>
          <li>Help center access</li>
        </ul>
        <button type="button" class="btn btn-lg btn-block btn-primary">Contact us</button>
      </div>
    </div>
  </div>
  -->
  <!-- 하단 -->
  <%@ include file="/WEB-INF/views/includes/footer.jsp" %>
</div>

  </body>
</html>
