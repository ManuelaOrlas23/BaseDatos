package com.example.Store.controladores;

import com.example.Store.modelos.TipoPrenda;
import com.example.Store.servicios.TipoPrendServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

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

    @GetMapping
    public ResponseEntity<?> consultarTipoPrenda(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(tipoPrendServicio.buscarTodosLasTipoPrenda());

        }catch (Exception error){
            Map<String,Object> errorDetails = new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message",error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }
    }
    @GetMapping("{id}")
    public ResponseEntity<?> buscarTipoPrendaPorId(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(tipoPrendServicio.buscarTipoPrendaPorId(id));
        }catch (Exception error){
            Map<String,Object> errorDetails = new LinkedHashMap<>();
            errorDetails.put("timestamp",LocalDateTime.now());
            errorDetails.put("message",error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }

}
}
