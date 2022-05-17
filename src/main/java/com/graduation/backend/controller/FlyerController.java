package com.graduation.backend.controller;

import com.graduation.backend.dto.FlyerDto;
import com.graduation.backend.model.Flyer;
import com.graduation.backend.service.FlyerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;
import java.util.*;

@RestController
public class FlyerController {

        @Autowired
        FlyerService service;

    @GetMapping("flyer")
    public ResponseEntity<Object> getFlyer() {
        List<FlyerDto> flyer = service.getFlyer();
        return new ResponseEntity<>(flyer, HttpStatus.OK);
    }

    @GetMapping(value  = "/flyer/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    ResponseEntity<Object> getFlyerById (@PathVariable Long id) {
        byte[] flyer = service.getFlyerById(id);
        return new ResponseEntity<>(flyer, HttpStatus.OK);
    }

        @PostMapping(value = "/flyer")
        ResponseEntity<Object> createFlyer(@RequestBody MultipartFile file) {
            try {
                if (Objects.equals(file.getContentType(), "application/pdf")) {
                    Flyer flyer = service.createFlyer(file);
                    return new ResponseEntity<>(flyer, HttpStatus.CREATED);
                }
                return new ResponseEntity<>("Please upload a pdf file", HttpStatus.BAD_REQUEST);
            } catch (IOException exception) {
                return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
            }
        }

        @PutMapping(value  = "/flyer/{id}")
        ResponseEntity<Object> updateFlyer (@RequestBody MultipartFile file, @PathVariable Long id) {
            try {
                String message = service.updateFlyer(file, id);
                return new ResponseEntity<>(message, HttpStatus.OK);
            } catch (IOException exception) {
                return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
            }
        }

        @DeleteMapping("flyer/{id}")
        ResponseEntity<Object> deleteFlyer (@PathVariable Long id) {
            return new ResponseEntity<>(service.deleteFlyer(id), HttpStatus.OK);
        }

}