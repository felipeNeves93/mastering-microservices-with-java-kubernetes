package com.microservicescourse.accounts.controller;

import com.microservicescourse.accounts.model.Account;
import com.microservicescourse.accounts.model.Customer;
import com.microservicescourse.accounts.repository.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AccountsController {

    private final AccountRepository accountRepository;

    @GetMapping("/myAccount")
    public Account getAccountDetails(@RequestBody Customer customer) {
        var account = accountRepository.findByCustomerId(customer.getCustomerId());

        return account;
    }
}
