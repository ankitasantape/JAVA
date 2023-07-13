package com.letsstartlearning.letsstartlearning.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;
    @NotBlank(message = "Please Add Department Name")
    @Length(max=5,min=1)
    @Size(max=10, min=0)
    /* @Email // for email you can pass regex value
    @Positive
    @Negative
    @PositiveOrZero */
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;


    public static class ErrorMessage {
    }
}
