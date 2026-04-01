package com.jack.currencyconverter.respository;

import com.jack.currencyconverter.model.Conversion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConversionRepository extends JpaRepository<Conversion, Long>{
    
}
