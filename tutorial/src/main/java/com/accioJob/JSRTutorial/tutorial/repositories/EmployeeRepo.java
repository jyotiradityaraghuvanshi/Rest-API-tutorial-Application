package com.accioJob.JSRTutorial.tutorial.repositories;


import com.accioJob.JSRTutorial.tutorial.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity , Long> {  // this is our database layer
    // every method is already here as extend all the libraries which provide us all
    // If we need some kind of new query from database then we can write that in here which is externally added by us.
}
