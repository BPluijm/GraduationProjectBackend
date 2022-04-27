package com.graduation.backend.controller;

import com.graduation.backend.dto.HotSpotsDto;
import com.graduation.backend.service.HotSpotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@RestController
public class HotSpotsController {

    @Autowired
    HotSpotsService service;

//    @GetMapping(value = "hotspots", produces = MediaType.APPLICATION_PDF_VALUE)
    @GetMapping("hotspots")
    ResponseEntity<Object> getHotSpots() {
//    ResponseEntity<Object> getHotSpots(@PathVariable Long id) {
        List<HotSpotsDto> hpd = service.getHotSpots();
//        byte[] flyer = service.getHotSpots(id);
        return new ResponseEntity<>(hpd, HttpStatus.OK);
    }

    @GetMapping(value  = "/hotspots/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    ResponseEntity<Object> getHotSpotsById (@PathVariable Long id) {
        byte[] flyer = service.getHotSpotsById(id);
        return new ResponseEntity<>(flyer, HttpStatus.OK);
    }

    @PostMapping(value = "/hotspots")
    ResponseEntity<Object> createHotSpots(@Valid @RequestBody HotSpotsDto hsd, MultipartFile flyer) throws IOException {
        if (Objects.equals(flyer.getContentType(), "application/pdf")) {
            service.createHotSpots(hsd, flyer);
            return new ResponseEntity<>("Hot spot added", HttpStatus.CREATED);
        }
        return new ResponseEntity<>("Only pdf file upload possible", HttpStatus.BAD_REQUEST);

    }

//    @PostMapping("/hotspots/{id}/users")
//    ResponseEntity<Object> createHotSpots(@PathVariable Long id) {
//        return new ResponseEntity<>(service.addHotSpots(id), HttpStatus.CREATED);
//    }

    @PutMapping(value  = "/hotspots/{id}")
    ResponseEntity<Object> updateHotSpots (@PathVariable Long id, @Valid @RequestBody HotSpotsDto hs, MultipartFile flyer) {
        String message = service.updateHotSpots(id, hs, flyer);
        return new ResponseEntity<>(message, HttpStatus.OK);
    }

    @DeleteMapping("hotspots/{id}")
    ResponseEntity<Object> deleteHotSpots (@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteHotSpots(id), HttpStatus.OK);
    }

}
