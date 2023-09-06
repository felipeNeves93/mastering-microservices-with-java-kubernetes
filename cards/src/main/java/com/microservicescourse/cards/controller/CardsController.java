package com.microservicescourse.cards.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservicescourse.cards.config.CardsServiceConfig;
import com.microservicescourse.cards.model.Card;
import com.microservicescourse.cards.model.Customer;
import com.microservicescourse.cards.model.Properties;
import com.microservicescourse.cards.repository.CardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CardsController {

    private final CardRepository cardRepository;
    private final CardsServiceConfig cardsServiceConfig;

    @PostMapping("/myCards")
    public List<Card> getCardDetails(@RequestBody Customer customer) {
        var cards = cardRepository.findByCustomerId(customer.getCustomerId());
        return cards;
    }

    @GetMapping("/cards/properties")
    public String getPropertyDetails() throws JsonProcessingException {
        var objectWriter = new ObjectMapper().writer().withDefaultPrettyPrinter();
        var properties = Properties.builder()
                .msg(cardsServiceConfig.getMsg())
                .buildVersion(cardsServiceConfig.getBuildVersion())
                .mailDetails(cardsServiceConfig.getMailDetails())
                .activeBranches(cardsServiceConfig.getActiveBranches())
                .build();

        return objectWriter.writeValueAsString(properties);
    }
}
