package com.microservicescourse.accounts.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicescourse.accounts.config.AccountsServiceConfig;
import com.microservicescourse.accounts.model.Account;
import com.microservicescourse.accounts.model.Customer;
import com.microservicescourse.accounts.model.Properties;
import com.microservicescourse.accounts.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountsController {

    private final AccountRepository accountRepository;

    private final AccountsServiceConfig accountsServiceConfig;

    @GetMapping("/myAccount")
    public Account getAccountDetails(@RequestBody Customer customer) {
        var account = accountRepository.findByCustomerId(customer.getCustomerId());

        return account;
    }

    @GetMapping("/account/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        var ow = new ObjectMapper().writer().withDefaultPrettyPrinter();
        var properties = Properties.builder()
                .msg(accountsServiceConfig.getMsg())
                .buildVersion(accountsServiceConfig.getBuildVersion())
                .mailDetails(accountsServiceConfig.getMailDetails())
                .activeBranches(accountsServiceConfig.getActiveBranches())
                .build();

        var jsonStr = ow.writeValueAsString(properties);
        return jsonStr;
    }
}
