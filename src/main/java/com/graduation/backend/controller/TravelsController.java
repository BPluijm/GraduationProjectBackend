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

//    @GetMapping("/travels/{id}")
//    public ResponseEntity<Object>getTravelsById() {
//    List<TravelsDto> tdi = service.getTravelsById();
//    return new ResponseEntity<>(tdi, HttpStatus.OK);
//    }

//    @GetMapping("/travels/{id}")
//    ResponseEntity<Object> getTravelsById (@PathVariable Long id) {
//        return new ResponseEntity<>(service.getTravelsById(id), HttpStatus.OK);
//    }
//    @GetMapping("/customers/{id}/cars")
//    ResponseEntity<Object> getCustomerCars (@PathVariable Long id) {
//        return new ResponseEntity<>(customerService.findCustomerCars(id), HttpStatus.OK);
//    }
//

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




//    // POST REQUESTS
//    @PostMapping("/customers")
//    ResponseEntity<Object> createCustomer (@Valid @RequestBody CustomerDTO customerDTO, BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            StringBuilder sb = new StringBuilder();
//            for (FieldError error : bindingResult.getFieldErrors()){
//                sb.append(error.getDefaultMessage());
//                sb.append("\n");
//            }
//            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
//        } else {
//            CustomerDTO newCustomer = customerService.createCustomer(customerDTO);
//            return new ResponseEntity<>(newCustomer, HttpStatus.CREATED);
//        }
//
//    }
//
//    // PUT REQUESTS
//    @PutMapping("/customers/{id}")
//    ResponseEntity<Object> updateCustomer (@PathVariable Long id, @Valid @RequestBody CustomerDTO customerDTO , BindingResult bindingResult) {
//        if(bindingResult.hasErrors()){
//            StringBuilder sb = new StringBuilder();
//            for (FieldError error : bindingResult.getFieldErrors()){
//                sb.append(error);
//                sb.append("\n");
//            }
//            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
//        } else {
//            return new ResponseEntity<>(customerService.updateCustomer(customerDTO, id), HttpStatus.OK);
//        }
//
//    }
//
//    // DELETE REQUEST
//    @DeleteMapping("/customers/{id}")
//    ResponseEntity<Object> deleteCustomer (@PathVariable Long id) {
//        return new ResponseEntity<>(customerService.deleteCustomer(id), HttpStatus.OK);
//    }





}
