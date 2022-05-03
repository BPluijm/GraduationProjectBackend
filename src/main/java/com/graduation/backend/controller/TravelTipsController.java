package com.graduation.backend.controller;

import com.graduation.backend.dto.TravelTipsDto;
import com.graduation.backend.service.TravelTipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.web.multipart.MultipartFile;

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

    @GetMapping(value = "/travel-tips/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    ResponseEntity<Object> getTravelTipsById (@PathVariable Long id) {
        byte[] ttd = service.getTravelTipsById(id);
        return new ResponseEntity<>(ttd, HttpStatus.OK);
    }




    @PostMapping("/travel-tips")
    public ResponseEntity<Object> createTravelTips(@Valid @RequestBody TravelTipsDto ttdt, MultipartFile tips) {
        try {
            if (Objects.equals(tips.getContentType(), "application/pdf")) {
                service.createTravelTips(ttdt, tips);
                return new ResponseEntity<>("Tip is created", HttpStatus.CREATED);
            }
            return new ResponseEntity<>("Only pdf file upload possible", HttpStatus.BAD_REQUEST);
        } catch (IOException error) {
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

        @PutMapping("/travel-tips/{id}")
        ResponseEntity<Object> updateTravelTips (@Valid @RequestBody TravelTipsDto ti, MultipartFile tips, @PathVariable Long id) {
            try {
                String tip = service.updateTravelTips(ti, tips, id);
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