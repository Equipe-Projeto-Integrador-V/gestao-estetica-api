package com.api.faculdade.senac.piv.gestaoesteticaapi.util;


import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BigDecimalConverter {

    // 1.000,00 -> 1000.00
    public BigDecimal converter(String valor){
        if(valor == null){ return null; }
        valor = valor.replace(".","").replace(",",".");
        return new BigDecimal(valor);
    }
}
