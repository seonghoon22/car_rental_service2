package com.web.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.DigestUtils;
import org.springframework.util.ResourceUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.MatrixVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import com.web.domain.Car;
import com.web.service.CarService;

import lombok.Getter;
  
@Controller
@RequestMapping("/cars")
public class CarController {
    
    private CarService carService;

    @Autowired
    public CarController(CarService carService) {
    	System.out.println("create CarController");
        this.carService = carService;
    }

    @GetMapping
    public String getAllCars(Model model) {
    	System.out.println("@GetMapping(\"/cars\")");
        List<Car> cars = carService.getAllCars();
        model.addAttribute("cars", cars);
        return "car-list";
    }

    @GetMapping("/new")
    public String showCarForm(Model model) {
    	
    	
    	System.out.println("@GetMapping(\"/cars\")22");
//        model.addAttribute("car", new Car(1L, null, null, 0, null, null));
        model.addAttribute("car", new Car());
    	return "car-form";
    }
    /*
    @PostMapping("/new")
    public String saveCar(@Valid @ModelAttribute Car car, BindingResult bindingResult,
                          @RequestParam("file") MultipartFile file) throws IOException {
    	System.out.println("@GetMapping(\"/cars\")33");
        if (bindingResult.hasErrors()) {
            return "car-form";
        }

        car.setFile(file);
        carService.saveCar(car);
        return "redirect:/cars";
    }
    */

    @PostMapping("/new")
    public String saveCar(@Valid @ModelAttribute Car car, BindingResult bindingResult,
                          @RequestParam("file") MultipartFile file) throws IOException {
    	System.out.println("@GetMapping(\"/cars\")이미지 ");
        if (bindingResult.hasErrors()) {
            return "car-form";
        }

        if (!file.isEmpty()) {
      
        	// 파일 저장 경로
  //          String filePath = "src/main/resources/static/images/" + file.getOriginalFilename();
 
        	

            // 프로젝트의 실제 루트 경로를 가져옵니다.
            String projectRootPath = ResourceUtils.getFile("src/main/resources/static/images/").getAbsolutePath();
          
            // 파일 저장 경로
            String filePath = projectRootPath + "/" + file.getOriginalFilename();

            // 이미지 경로 저장
            car.setImgpath(filePath);
            
            System.out.println("filePath : " + filePath);
            // file:src/main/resources/static/images/
            
            // 파일을 저장
            file.transferTo(new File(filePath));
            
        }
    
        carService.saveCar(car);
        return "redirect:/cars";
    }
  
    @GetMapping("/{carNo}")
    public String getCarDetails(@PathVariable("carNo") Long car_no, Model model) {
    	System.out.println("@GetMapping(\"/cars\")44");
        Car car = carService.getCarByCar_no(car_no);
        model.addAttribute("car", car);
        return "car-details";
    }
    
}

