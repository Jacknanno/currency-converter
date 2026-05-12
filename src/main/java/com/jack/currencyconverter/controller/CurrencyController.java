package com.jack.currencyconverter.controller;

import org.springframework.web.bind.annotation.*;

import com.jack.currencyconverter.model.Conversion;
import com.jack.currencyconverter.service.CurrencyService;

import java.util.*;
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
    
    // This acts as http://localhost:8080/history to get the history of conversions allowing a user to view current history.
   @GetMapping("/history")
   public List<Conversion> getHistory() {
      return currencyService.getAllConversion();
   } 
     
}
