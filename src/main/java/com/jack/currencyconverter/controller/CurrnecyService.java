package com.jack.currencyconverter.controller;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Service
public class CurrnecyService {

    public Map getConversion(String from, String to, double amount) {
        
        String url = "https://api.exchangerate.host/convert?from="
            + from + "&to=" + to + "&amount=" + amount;     
        
        RestTemplate restTemplate = new RestTemplate();
        
        return restTemplate.getForObject(url, Map.class);
    }
    
}
