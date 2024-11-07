package com.accioJob.JSRTutorial.tutorial.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity  // tells the spring that this out entity.
@Data  // gets the getter setter
@NoArgsConstructor  // get default constructor
@AllArgsConstructor  // gets all parameterized constructor
@Table(name = "employees") // this creates our database table with name we give.
public class EmployeeEntity {

    @Id // this annotation says this is our primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // now we don't need to provide the id this will automatically generate id for us.
    private long id;
    
    private String name;

    private LocalDate dateOfJoining;

    private boolean isActive;


}
