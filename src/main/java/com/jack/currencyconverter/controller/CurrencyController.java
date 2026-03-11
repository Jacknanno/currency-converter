package com.jack.currencyconverter.controller;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;


@RestController
public class CurrencyController {

    @GetMapping("/convert") 
    public Map<String, Object> convert(
        @RequestParam String from,
        @RequestParam String to,
        @RequestParam double amount) {

            // Fake exchange rate for now
            double rate = 0.92;

            double converted = amount * rate;
            return Map.of(
               "from", from,
               "to", to,
               "amount", amount,
               "rate" , rate,
               "convertedAmount" , converted 
            );


        }
    
        
    
     
}
