package com.jack.currencyconverter.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CurrencyService {

    public Map getConversion(String from, String to, double amount) {
        
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://open.er-api.com/v6/latest/" + from;

        Map response = restTemplate.getForObject(url, Map.class);

        Map rates = (Map) response.get("rates");

        double rate = (double) rates.get(to);
       
        double converted = amount * rate;

        return Map.of(
            "from", from,
            "to", to,
            "amount", amount,
            "rate", rate,
            "convertedAmount", converted
        );
       
    }
    
}
