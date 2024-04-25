package com.example.Store.controladores;

import com.example.Store.modelos.Marca;
import com.example.Store.servicios.MarcaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

@RestController
@RequestMapping("storeapi/v1/marca")
public class MarcaControlador {

    @Autowired
    MarcaServicio marcaServicio;

    @PostMapping
    public ResponseEntity<?> guardarMarca(@RequestBody Marca datosMarca){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(marcaServicio.guardarmarca(datosMarca));
        }catch (Exception error){
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(error.getMessage());
        }
    }
    @GetMapping
    public ResponseEntity<?> consultarMarca(){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(marcaServicio.buscarTodosLasMarcas());

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
    public ResponseEntity<?> buscarMarcaPorId(@PathVariable Integer id){
        try {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(marcaServicio.buscarMarcaPorId(id));
        }catch (Exception error){
            Map<String,Object> errorDetails = new LinkedHashMap<>();
            errorDetails.put("timestamp", LocalDateTime.now());
            errorDetails.put("message",error.getMessage());
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(errorDetails);
        }
    }
}
