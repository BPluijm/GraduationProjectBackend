package com.graduation.backend.controller;

import com.graduation.backend.dto.HotSpotsDto;
import com.graduation.backend.model.HotSpots;
import com.graduation.backend.service.HotSpotsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import javax.validation.Valid;
import java.io.IOException;
import java.nio.file.*;
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

    @GetMapping(value  = "/hotspots/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
    ResponseEntity<Object> getHotSpotsById (@PathVariable Long id) {
        byte[] flyer = service.getHotSpotsById(id);
        return new ResponseEntity<>(flyer, HttpStatus.OK);
    }

//    @PostMapping(value = "/hotspots")
//    ResponseEntity<Object> createHotSpots(@Valid @RequestBody HotSpotsDto hsd, MultipartFile flyer) {
//        if (Objects.equals(flyer.getContentType(), "application/pdf")) {
//            service.createHotSpots(hsd, flyer);
//            return new ResponseEntity<>("Hot spot added", HttpStatus.CREATED);
//        }
//        return new ResponseEntity<>("Only pdf file upload possible", HttpStatus.BAD_REQUEST);
//
//    }

    @PostMapping(value = "/hotspots")
    ResponseEntity<Object> createHotSpots(@RequestBody HotSpotsDto hsdt, MultipartFile file) {
        try {
            if (file == null) {
                Path path = Paths.get("C:\\IdeaProjects\\backend\\src\\main\\java\\com\\graduation\\backend\\assets\\NotIncluded.pdf");
                byte[] content = null;
                content = Files.readAllBytes(path);
                file = new MockMultipartFile("NotIncluded.pdf", "NotIncluded.pdf", "text/pdf", content);
                HotSpots pdfHotSpot = service.createHotSpots(hsdt, file);
                return new ResponseEntity<>(pdfHotSpot, HttpStatus.CREATED);
            }
            HotSpots pdfHotSpot = service.createHotSpots(hsdt, file);
            return new ResponseEntity<>(pdfHotSpot, HttpStatus.CREATED);

        } catch (IOException exception) {
            return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
        }

    }

//    @PutMapping(value  = "/hotspots/{id}")
//    ResponseEntity<Object> updateHotSpots (@PathVariable Long id, @Valid @RequestBody HotSpotsDto hs, MultipartFile flyer) {
//        String message = service.updateHotSpots(id, hs, flyer);
//        return new ResponseEntity<>(message, HttpStatus.OK);
//    }


    @PutMapping("/hotspots/{id}")
    ResponseEntity<Object> updateHotSpots (@Valid @RequestBody HotSpotsDto hot, MultipartFile file, @PathVariable Long id) {
        try {
            String tip = service.updateHotSpots(hot, file, id);
            return new ResponseEntity<>(tip, HttpStatus.OK);
        } catch (IOException error) {
            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("hotspots/{id}")
    ResponseEntity<Object> deleteHotSpots (@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteHotSpots(id), HttpStatus.OK);
    }


    //    @PostMapping("/hotspots/{id}/users")
//    ResponseEntity<Object> createHotSpots(@PathVariable Long id) {
//        return new ResponseEntity<>(service.addHotSpots(id), HttpStatus.CREATED);
//    }


}
