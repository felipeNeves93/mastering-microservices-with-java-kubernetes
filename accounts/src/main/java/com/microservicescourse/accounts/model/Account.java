package com.microservicescourse.accounts.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

import java.time.LocalDate;

@Table(name = "accounts")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Account {

    @Column(name = "customer_id")
    private int customerId;

    @Id
    @Column(name = "account_number")
    private Long accountNumber;

    @Column(name = "account_type")
    private String accountType;

    @Column(name = "batch_address")
    private String batchAddress;

    @Column(name = "created_date")
    private LocalDate createdDate;
}
