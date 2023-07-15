package com.microservicescourse.accounts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Table(name = "customers")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Customer {

    @Id
    @Column(name = "customer_id")
    private int customerId;

    @Column
    private String name;

    @Column
    private String email;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "created_date")
    private LocalDate createdDate;
}
