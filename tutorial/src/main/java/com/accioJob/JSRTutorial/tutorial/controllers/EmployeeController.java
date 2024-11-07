package com.accioJob.JSRTutorial.tutorial.controllers;

//get the employ
//post the employ


import com.accioJob.JSRTutorial.tutorial.dto.EmployeeDto;
import com.accioJob.JSRTutorial.tutorial.services.EmployeeService;
import jakarta.websocket.server.PathParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
//@RequestMapping(path = "/employees")
public class EmployeeController {

    //@Autowired // we can also use autowired.
    private final EmployeeService employeeService;  // Now this is the flow of data controller takes the data from service layer

    public EmployeeController(EmployeeService employeeService) { // constructor injection.
        this.employeeService = employeeService;
    }

//    @GetMapping(path = "/{id}")
//    public EmployeeDto getEmploy(@PathVariable("id") long employeeId){
//        return new EmployeeDto(employeeId , "jyotiraditya" , LocalDate.of(2024 , 11 , 8) , true);
//    }


    @GetMapping(path = "/employees")
    public List<EmployeeDto> getAllEmployee() {
        return  employeeService.getAllEmployees();
    }

//    @GetMapping
//    public String getData(@PathParam("sortBy") String sortby , @PathParam("played") String played){
//        return "Hello this is given " + sortby + " this sport and the sport is ->" + played;
//    }

    @GetMapping(path = "/employees/{id}")
    public EmployeeDto getEmployById(@PathVariable("id") long employeeId){
        return employeeService.getEmployeeId(employeeId);
    }

    @PostMapping(path = "/employees")
    public EmployeeDto createNewEmploy(@RequestBody EmployeeDto employeeDto){
        return employeeService.createNewEmploye(employeeDto);
    }

    @DeleteMapping(path = "/employees/{id}")
    public boolean deleteEmployeeById(@PathVariable long id){
        return employeeService.deleteEmployeeBYID(id);
    }

}
