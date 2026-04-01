package com.jack.currencyconverter.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.jack.currencyconverter.model.Conversion;
import com.jack.currencyconverter.respository.ConversionRepository;

import java.util.Map;

@Service
public class CurrencyService {

    private final ConversionRepository repository;

    public CurrencyService(ConversionRepository repository) {
        this.repository = repository;
    }

    public Map getConversion(String from, String to, double amount) {
        
        RestTemplate restTemplate = new RestTemplate();

        String url = "https://open.er-api.com/v6/latest/" + from;

        Map response = restTemplate.getForObject(url, Map.class);

        Map rates = (Map) response.get("rates");

        double rate = ((Number) rates.get(to)).doubleValue();
        double converted = amount * rate;

        // Save conversion to database
        Conversion conversion = new Conversion(from, to, amount, converted);
        repository.save(conversion);
        
        return Map.of(
            "from", from,
            "to", to,
            "amount", amount,
            "rate", rate,
            "convertedAmount", converted
        );
       
    }
    
}
