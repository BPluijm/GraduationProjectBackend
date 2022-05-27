package com.graduation.backend.controller;

import com.graduation.backend.dto.TravelTipsDto;
import com.graduation.backend.service.TravelTipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;
import java.util.*;

@RestController
public class TravelTipsController {

    @Autowired
    TravelTipsService service;

    @GetMapping("/travel-tips")
    public ResponseEntity<Object> getTravelTips() {
        List<TravelTipsDto> ld = service.getTravelTips();
        return new ResponseEntity<>(ld, HttpStatus.OK);
    }

    @GetMapping("/travel-tips/{id}")
    ResponseEntity<Object> getTravelTipsById (@PathVariable Long id) {
        return new ResponseEntity<>(service.getTravelTipsById(id), HttpStatus.OK);
    }

    @PostMapping("/travel-tips")
    public ResponseEntity<Object> createTravelTips(@Valid @RequestBody TravelTipsDto ttdt, BindingResult br) throws IOException {
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for(FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            service.createTravelTips(ttdt);
            return new ResponseEntity<>("Tip added!", HttpStatus.CREATED);
        }
    }

    @PutMapping("/travel-tips/{id}")
    ResponseEntity<Object> updateTravelTips (@Valid @RequestBody TravelTipsDto ti, @PathVariable Long id) {
       try {
            String tip = service.updateTravelTips(ti, id);
            return new ResponseEntity<>(tip, HttpStatus.OK);
       } catch (IOException error) {
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
       }
    }

    @DeleteMapping("travel-tips/{id}")
    ResponseEntity<Object> deleteTravelTips (@PathVariable Long id) {
       return new ResponseEntity<>(service.deleteTravelTips(id), HttpStatus.OK);
    }
}