package com.graduation.backend.controller;

import com.graduation.backend.dto.UsersDto;
import com.graduation.backend.service.UsersService;
//import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class UsersController {

    private final UsersService service;

    public UsersController(UsersService service) {
        this.service = service;
    }

    @GetMapping("/users")
    ResponseEntity<Object> getAllUsers () {
        return new ResponseEntity<>(service.findAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    ResponseEntity<Object> getUsersById (@PathVariable Long id) {
        return new ResponseEntity<>(service.findUsersById(id), HttpStatus.OK);
    }
    @GetMapping("/users/{id}/favorites")
    ResponseEntity<Object> getUsersTravels (@PathVariable Long id) {
        return new ResponseEntity<>(service.findUsersTravels(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    ResponseEntity<Object> createUsers (@Valid @RequestBody UsersDto udto, BindingResult br){
        if(br.hasErrors()){
            StringBuilder sb = new StringBuilder();
            for (FieldError error : br.getFieldErrors()){
                sb.append(error.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
           service.createUsers(udto);
            return new ResponseEntity<>("User added", HttpStatus.CREATED);
        }

    }

    @PutMapping("/users/{id}")
    ResponseEntity<Object> updateUsers (@PathVariable Long id, @Valid @RequestBody UsersDto usersDto , BindingResult bindingResult) {
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            for (FieldError error : bindingResult.getFieldErrors()){
                sb.append(error);
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<>(service.updateUsers(usersDto, id), HttpStatus.OK);
        }

    }

    @DeleteMapping("/users/{id}")
    ResponseEntity<Object> deleteUsers (@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteUsers(id), HttpStatus.OK);
    }

}
