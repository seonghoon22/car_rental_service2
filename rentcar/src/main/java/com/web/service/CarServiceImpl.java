package com.web.service;
  

import java.util.List;
import java.util.UUID;
import java.io.File;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.web.domain.Car;
import com.web.repository.CarRepository;


@Service
public class CarServiceImpl implements CarService {
	
	@Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> getAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Car getCarByCar_no(Long car_no) {
       // return carRepository.findByCar_no(car_no);
       return null;
    }

    @Override
    public void saveCar(Car car, MultipartFile file) {

        /*우리의 프로젝트경로를 담아주게 된다 - 저장할 경로를 지정*/
		String projectPath = /* System.getProperty("user.dir") + */ "C:\\Users\\user\\git\\rentcar\\rentcar\\src\\main\\resources\\static\\images";

        /*식별자 . 랜덤으로 이름 만들어줌*/
        UUID uuid = UUID.randomUUID();

        /*랜덤식별자_원래파일이름 = 저장될 파일이름 지정*/
        String fileName = uuid + "_" + file.getOriginalFilename();

        /*빈 껍데기 생성*/
        /*File을 생성할건데, 이름은 "name" 으로할거고, projectPath 라는 경로에 담긴다는 뜻*/
        File saveFile = new File(projectPath, fileName);

        try {
			file.transferTo(saveFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
        /*저장되는 경로*/
        car.setImgpath("/images/" + fileName); /*저장된파일의이름,저장된파일의경로*/
        
        carRepository.save(car);
    }
}