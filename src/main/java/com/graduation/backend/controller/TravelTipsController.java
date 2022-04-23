package com.graduation.backend.controller;

import com.graduation.backend.dto.TravelTipsDto;
import com.graduation.backend.service.TravelTipsService;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.*;
import java.util.List;

@RestController
public class TravelTipsController {
    private final TravelTipsService service;

    public TravelTipsController(TravelTipsService service) {

        this.service = service;
    }

    @GetMapping("/travel-tips")
    public ResponseEntity<Object> getTravelTips() {
        List<TravelTipsDto> ld = service.getTravelTips();
        return new ResponseEntity<>(ld, HttpStatus.OK);
    }

    @PostMapping("/travel-tips")
    public ResponseEntity<Object> createTravelTips(@Valid @RequestBody TravelTipsDto ttdto, BindingResult br)  {
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for(FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            service.createTravelTips(ttdto);
            return new ResponseEntity<>("Tip added!", HttpStatus.CREATED);
        }
    }
}
