package com.jack.currencyconverter.controller;

import com.jack.currencyconverter.controller.CurrencyService;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController
public class CurrencyController {

    private final CurrencyService currencyService;

    public CurrencyController(CurrencyService currencyService) {
        this.currencyService = currencyService;
    }

    @GetMapping("/convert") 
    public Map<String, Object> convert(
        @RequestParam String from,
        @RequestParam String to,
        @RequestParam double amount) {

            return currencyService.getConversion(from, to, amount);

        }
    
        
    
     
}
