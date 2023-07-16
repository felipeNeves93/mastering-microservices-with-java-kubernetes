package com.microservicescourse.loans.model;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    private int customerId;

    private String name;

    private String email;

    private String mobileNumber;

    private LocalDate createdDate;
}
