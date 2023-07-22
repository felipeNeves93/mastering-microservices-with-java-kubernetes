package com.microservicescourse.cards.controller;

import com.microservicescourse.cards.model.Card;
import com.microservicescourse.cards.model.Customer;
import com.microservicescourse.cards.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsController {

    private final CardRepository cardRepository;

    @PostMapping("/myCards")
    public List<Card> getCardDetails(@RequestBody Customer customer) {
        var cards = cardRepository.findByCustomerId(customer.getCustomerId());
        return cards;
    }
}
