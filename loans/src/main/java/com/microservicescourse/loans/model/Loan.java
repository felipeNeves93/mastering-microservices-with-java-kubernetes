package com.microservicescourse.loans.model;


import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Table(name = "loans")
@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Loan {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "loan_number")
    private Long loanNumber;

    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "start_date")
    private LocalDate startDate;

    @Column(name = "loan_type")
    private String loanType;

    @Column(name = "total_loan")
    private int totalLoan;

    @Column(name = "amount_paid")
    private int amountPaid;

    @Column(name = "outstanding_amount")
    private int outstadingAmount;

    @Column(name = "create_date")
    private String createDate;
}
