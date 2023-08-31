package com.microservicescourse.loans.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicescourse.loans.config.LoansServiceConfig;
import com.microservicescourse.loans.model.Customer;
import com.microservicescourse.loans.model.Loan;
import com.microservicescourse.loans.model.Properties;
import com.microservicescourse.loans.repository.LoanRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class LoansController {

    private final LoanRepository loanRepository;
    private final LoansServiceConfig loansServiceConfig;

    @PostMapping("/myLoans")
    public List<Loan> getLoanDetails(@RequestBody Customer customer) {
        var loans = loanRepository.findByCustomerIdOrderByStartDateDesc(customer.getCustomerId());

        return loans;
    }

    @GetMapping("/loans/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        var ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        var properties = Properties.builder()
                .msg(loansServiceConfig.getMsg())
                .buildVersion(loansServiceConfig.getBuildVersion())
                .mailDetails(loansServiceConfig.getMailDetails())
                .activeBranches(loansServiceConfig.getActiveBranches())
                .build();

        var jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }
}
