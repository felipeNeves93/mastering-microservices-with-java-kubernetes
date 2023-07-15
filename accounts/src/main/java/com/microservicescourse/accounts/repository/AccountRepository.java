package com.microservicescourse.accounts.repository;

import com.microservicescourse.accounts.model.Account;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountRepository extends JpaRepository<Account, Long> {

    Account findByCustomerId(int customerId);
}
