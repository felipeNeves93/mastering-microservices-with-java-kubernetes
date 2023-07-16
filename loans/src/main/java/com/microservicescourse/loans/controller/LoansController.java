package com.microservicescourse.loans.controller;

import com.microservicescourse.loans.model.Customer;
import com.microservicescourse.loans.model.Loan;
import com.microservicescourse.loans.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoansController {

    private final LoanRepository loanRepository;

    @PostMapping("/myLoans")
    public List<Loan> getLoanDetails(@RequestBody Customer customer) {
        var loans = loanRepository.findByCustomerIdOrderByStartDateDesc(customer.getCustomerId());

        return loans;
    }
}
