package com.graduation.backend.controller;

import com.graduation.backend.dto.TravelsDto;
import com.graduation.backend.service.TravelsService;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.List;

@RestController
public class TravelsController {

    private final TravelsService service;

    public TravelsController(TravelsService service) {

        this.service = service;
    }

    @GetMapping("/travels")
    public ResponseEntity<Object> getTravels() {
        List<TravelsDto> td = service.getTravels();
        return new ResponseEntity<>(td, HttpStatus.OK);
    }

    @PostMapping("/travels")
    public ResponseEntity<Object> createTravels(@Valid @RequestBody TravelsDto trdto, BindingResult br)  {
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for(FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            service.createTravels(trdto);
            return new ResponseEntity<>("Trip created!", HttpStatus.CREATED);
        }
    }
}
