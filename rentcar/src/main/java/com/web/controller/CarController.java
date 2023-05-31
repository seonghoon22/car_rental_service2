package com.web.controller;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
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

import com.web.domain.Car;
import com.web.service.CarService;

@Controller
@RequestMapping("/cars")
public class CarController {

    @Autowired
    private CarService carService;

    public CarController() {
        System.out.println("------------------------------------------");
        System.out.println("carController create");
        System.out.println("------------------------------------------");
    }

    @GetMapping("/car")
    public String requestBookById(@RequestParam("id") Long car_no, Model model) {
        Car carById = carService.getCarById(car_no);
        model.addAttribute("car", carById);
        return "car";
    }

    @GetMapping("/filter/{carFilter}")
    public String requestCarByFilter(@MatrixVariable(pathVar = "carFilter") Map<String, List<String>> carFilter, Model model) {
        Set<Car> carsByFilter = carService.getCarListByFilter(carFilter);
        model.addAttribute("carList", carsByFilter);
        return "cars";
    }

    @GetMapping("/all")
    public ModelAndView requestAllCar() {
        ModelAndView modelAndView = new ModelAndView();
        List<Car> list = carService.getAllCarList();
        modelAndView.addObject("carList", list);
        modelAndView.setViewName("cars");
        return modelAndView;
    }

    @GetMapping
    public String requestCarList(Model model) {
        List<Car> list = carService.getAllCarList();
        model.addAttribute("carList", list);
        return "car";
    }

    @PostMapping("/add")
    public String submitAddNewCar(@ModelAttribute("NewCar") Car car) {
        MultipartFile carImgpath = car.getFile();

        if (carImgpath != null && !carImgpath.isEmpty()) {
            String saveName = carImgpath.getOriginalFilename();
            File saveFile = new File("C:\\upload", saveName);

            try {
                carImgpath.transferTo(saveFile);
            } catch (Exception e) {
                throw new RuntimeException("차량 이미지 업로드가 실패하였습니다", e);
            }
            car.setImgpath(saveName);
        }

        carService.setNewCar(car);
        return "redirect:/cars";
    }

    @ModelAttribute
    public void addAttributes(Model model) {
        model.addAttribute("addTitle", "신규 car 등록");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.setAllowedFields("car_no", "model", "model_year", "price", "file");
    }
}