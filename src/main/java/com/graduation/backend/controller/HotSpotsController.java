package com.graduation.backend.controller;

import com.graduation.backend.dto.HotSpotsDto;
import com.graduation.backend.service.HotSpotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class HotSpotsController {

    @Autowired
    HotSpotsService service;

    @GetMapping("hotspots")
    public ResponseEntity<Object> getHotSpots() {
        List<HotSpotsDto> hpd = service.getHotSpots();
        return new ResponseEntity<>(hpd, HttpStatus.OK);
    }

    @GetMapping("/hotspots/{id}")
    ResponseEntity<Object> getHotSpotsById (@PathVariable Long id) {
        return new ResponseEntity<>(service.getHotSpotsById(id), HttpStatus.OK);
    }


    @PostMapping("/hotspots")
    public ResponseEntity<Object> createHotSpots(@Valid @RequestBody HotSpotsDto hsdt, BindingResult br) throws IOException {
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for(FieldError fe : br.getFieldErrors()) {
                sb.append(fe.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            service.createHotSpots(hsdt);
            return new ResponseEntity<>("HotSpot created!", HttpStatus.CREATED);
        }
    }

    @PutMapping("hotspots/{id}")
    ResponseEntity<Object> updateHotSpots (@PathVariable Long id, @Valid @RequestBody HotSpotsDto hotSpots , BindingResult br) throws IOException {
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError error : br.getFieldErrors()) {
                sb.append(error);
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(service.updateHotSpots(hotSpots, id), HttpStatus.OK);
        }
    }

    @DeleteMapping("hotspots/{id}")
    ResponseEntity<Object> deleteHotSpots (@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteHotSpots(id), HttpStatus.OK);
    }
}
