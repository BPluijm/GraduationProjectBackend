package com.graduation.backend.controller;

import com.graduation.backend.dto.TravelTipsDto;
import com.graduation.backend.service.TravelTipsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

//    @GetMapping(value = "/travel-tips/{id}", produces = MediaType.APPLICATION_PDF_VALUE)
//    ResponseEntity<Object> getTravelTipsById (@PathVariable Long id) {
//        byte[] ttd = service.getTravelTipsById(id);
//        return new ResponseEntity<>(ttd, HttpStatus.OK);
//    }


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

//    @PostMapping(value = "/travel-tips")
//    ResponseEntity<Object> createTravelTips(@RequestBody TravelTipsDto ttdt, MultipartFile file) {
//        try {
//            if (file == null) {
//                Path path = Paths.get("C:\\IdeaProjects\\backend\\src\\main\\java\\com\\graduation\\backend\\assets\\NotIncluded.pdf");
//                byte[] content = null;
//                content = Files.readAllBytes(path);
//                file = new MockMultipartFile("NotIncluded.pdf", "NotIncluded.pdf", "text/pdf", content);
//                TravelTips pdfTravel = service.createTravelTips(ttdt, file);
//                return new ResponseEntity<>(pdfTravel, HttpStatus.CREATED);
//            }
//                TravelTips pdfTravel = service.createTravelTips(ttdt, file);
//                return new ResponseEntity<>(pdfTravel, HttpStatus.CREATED);
//
//        } catch (IOException exception) {
//            return new ResponseEntity<>(exception, HttpStatus.BAD_REQUEST);
//        }
//
//    }

//    @RestController
//    public class ImageController {
//        @Autowired
//        ImageRepository imgRepos;
//
//        @PostMapping("/images")
//        public String upload(@RequestBody MultipartFile file) {
//            Image img = new Image();
//            try {
//                img.content = file.getBytes();
//            }
//            catch (IOException iex) {
//                return "Error while uploading image...";
//            }
//
//            imgRepos.save(img);
//            return "Image uploaded";
//        }
//




//        @GetMapping(value = "/images/{id}", produces = MediaType.IMAGE_PNG_VALUE)
//        public @ResponseBody byte[] download(@PathVariable Long id) {
//            Image img = imgRepos.findById(id).get();
//            return img.content;
//        }




//    @PostMapping("/travel-tips/{id}/add-pdf")
//    ResponseEntity<Object> createTravelTips(@PathVariable Long id, @RequestBody MultipartFile file) throws IOException {
//        String message = service.addPdfToTravelTips(id, file);
//        return new ResponseEntity<>(message, HttpStatus.CREATED);
//    }


//    @PostMapping("/travel-tips/{id}/add-pdf")
//    public ResponseEntity<Object> createTravelTips(@Valid @RequestBody MultipartFile tips) {
//        try {
//            if (Objects.equals(tips.getContentType(), "application/pdf")) {
//                service.createTravelTips(tips);
//                return new ResponseEntity<>("Tip is added", HttpStatus.CREATED);
//            }
//            return new ResponseEntity<>("Only pdf file upload possible", HttpStatus.BAD_REQUEST);
//        } catch (IOException error) {
//            return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
//        }
//    }

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