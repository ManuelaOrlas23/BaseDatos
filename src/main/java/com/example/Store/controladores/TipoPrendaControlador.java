package com.example.Store.controladores;

import com.example.Store.modelos.TipoPrenda;
import com.example.Store.servicios.TipoPrendServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("storeapi/v1/tipoprenda")
public class TipoPrendaControlador {

    @Autowired
    TipoPrendServicio tipoPrendServicio;

    @PostMapping
    public ResponseEntity<?> guardarTipoPrenda(@RequestBody TipoPrenda datosTipoPrenda){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(tipoPrendServicio.guardarTipoPrenda(datosTipoPrenda));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
}
