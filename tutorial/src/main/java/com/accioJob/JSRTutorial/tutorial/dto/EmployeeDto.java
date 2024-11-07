package com.accioJob.JSRTutorial.tutorial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDto {

    private long id;
    private String name;

    private LocalDate dateOfJoining;

    @JsonProperty("isActive")
    private boolean isActive;

}
