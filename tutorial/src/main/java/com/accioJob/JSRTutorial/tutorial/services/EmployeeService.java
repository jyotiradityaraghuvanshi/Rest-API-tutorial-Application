package com.accioJob.JSRTutorial.tutorial.services;


import com.accioJob.JSRTutorial.tutorial.dto.EmployeeDto;
import com.accioJob.JSRTutorial.tutorial.entities.EmployeeEntity;
import com.accioJob.JSRTutorial.tutorial.repositories.EmployeeRepo;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service // tells the framework that this our service layer.
public class EmployeeService {

    // we can also use Autowired also , but it can be changed in getEmployeeId method
    final EmployeeRepo employeeRepo;  // Service layer deals with both controller and repository i.e. both DTO and entity is come contact with service layer.

    final ModelMapper modelMapper;

    public EmployeeService(EmployeeRepo employeeRepo , ModelMapper modelMapper) {  // Now this is constructor Injection.
        this.employeeRepo = employeeRepo;
        this.modelMapper = modelMapper;
    }

    public EmployeeDto getEmployeeId(Long id){
        EmployeeEntity employeeEntity = employeeRepo.getById(id);  // this repo will return us the entity which contains the data from database layer.
        // now convert this entity into DTO to return it to the presentation(controller) layer

        // this can be problem when there is big data ->//return new EmployeeDto(employeeEntity.getId() , employeeEntity.getName() , employeeEntity.getDateOfJoining() , employeeEntity.isActive());

        return modelMapper.map(employeeEntity , EmployeeDto.class);
    }

    public EmployeeDto createNewEmploye(EmployeeDto employeeDto){
        EmployeeEntity employeeEntity = modelMapper.map(employeeDto , EmployeeEntity.class);
        return modelMapper.map(employeeRepo.save(employeeEntity) , EmployeeDto.class);
    }

    public List<EmployeeDto> getAllEmployees(){
//        List<EmployeeDto> list = new ArrayList<>();
//        for(EmployeeEntity employeeEntity : employeeRepo.findAll()){
//            EmployeeDto map = modelMapper.map(employeeEntity , EmployeeDto.class);
//            list.add(map);
//        }
//
//        return list; // we can also do the below things like that , using for each loop manually but, we let mapper do the job.


        return employeeRepo
                .findAll()
                .stream()
                .map(employeeEntity -> modelMapper.map(employeeEntity , EmployeeDto.class))  //here we can use foreach function of stream instead of map
                .collect(Collectors.toList());
    }

    public boolean deleteEmployeeBYID(Long id){
        boolean flag = employeeRepo.existsById(id);
        if(!flag) return false;
        employeeRepo.deleteById(id);
        return true;
    }
}
