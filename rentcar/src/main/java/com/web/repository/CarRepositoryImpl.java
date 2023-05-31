package com.web.repository;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashSet;

import org.springframework.stereotype.Repository;

import com.web.domain.Car;

@Repository
									//implements
public class CarRepositoryImpl implements CarRepository {

	 private List<Car> listOfCar = new ArrayList<Car>();

		    
		    public CarRepositoryImpl() {  
		    	//car_no
		        Car car1 = new Car(100);
		        car1.setModel("기아자동차");
		        car1.setModel_year("2020년 생산으로 시작되었으며 현재는 다른 2021년 신차가 출시될 예정이다");
		        car1.setPrice(350000);
		        //경로 설정 지정 안함
		        
	
		    }
		    


			@Override
			public List<Car> getAllCarList() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Set<Car> getCarListByFilter(Map<String, List<String>> filter) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public Car getCarById(Long car_no) {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void setNewCar(Car car) {
				// TODO Auto-generated method stub
				
			}		   
}
