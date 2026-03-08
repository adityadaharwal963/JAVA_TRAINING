package com.rcoem.project2;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class Controller {

    private Service service = new Service();

    @GetMapping("/viewAll")
    public List<Empolyee> viewAll(){
        return service.viewAll();
    }
    // /add?name=ram&salary=900&designation=manager&gender=Male&yearOfJoining=2020
    @PostMapping("/add")
    public Empolyee add(@RequestParam String name,@RequestParam Double salary,@RequestParam String designation,@RequestParam String gender,@RequestParam int yearOfJoining){
        return service.addEmpolyee(name,salary,designation,gender,yearOfJoining);
    }

    @PostMapping("/getByName")
    public List<Empolyee> getByName(@RequestParam String name,@RequestParam boolean order){
        return service.viewByName(name,order);
    }

    @PostMapping("/getById")
    public Empolyee add(@RequestParam int id){
        return service.viewById(id);
    }

    @PostMapping("/getByDesignation")
    public List<Empolyee> getByDesignation(@RequestParam String designation,@RequestParam boolean order){
        return service.viewByDesignation(designation,order);
    }

    @PostMapping("/getBySalary")
    public List<Empolyee> getBySalary(@RequestParam Double salary,@RequestParam boolean order){
        return service.viewALLBySalary(salary,order);
    }

}

