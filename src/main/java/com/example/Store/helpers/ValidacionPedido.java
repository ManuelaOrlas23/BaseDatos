package com.example.Store.helpers;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

@Component
public class ValidacionPedido {
    public boolean validarFechaYHora(String fechaYHora)throws Exception{
        if (fechaYHora.length()==0){
            throw new Exception("la fecha no puede estar vacia");
        }

        String regex = "\\d{4}-\\d{2}-\\d{2}";
        // evaluo si el nombre coincide con la expresion
        if (!ValidarPatron.evaluarPatron(fechaYHora,regex)){
            throw new Exception("revisa el formato de la hora y fecha");
        }
        return true;




    }
}
