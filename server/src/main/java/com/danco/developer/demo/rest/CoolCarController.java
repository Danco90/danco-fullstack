package com.danco.developer.demo.rest;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.danco.developer.demo.datasource.Car;
import com.danco.developer.demo.datasource.CarRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200" )
public class CoolCarController {
	
//	@Autowired
	private CarRepository repository;

    public CoolCarController(CarRepository repository) {
        this.repository = repository;
    }

    @GetMapping("/cool-cars")
    public Collection<Car> coolCars() {
    	return repository.findAll().stream()
    			.filter(this::isCool)
    			.collect(Collectors.toList());
    }
    
    
    private boolean isCool(Car car) {
        return !car.getName().equals("Mercedes") &&
                !car.getName().equals("Audi") &&
                !car.getName().equals("BMW");
    }
    
}
