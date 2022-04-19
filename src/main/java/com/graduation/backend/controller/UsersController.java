package com.graduation.backend.controller;

import com.graduation.backend.dto.UsersDto;
import com.graduation.backend.service.UsersService;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@RestController
public class UsersController {

    @Autowired
    UsersService usersService;

    @GetMapping("/users")
    ResponseEntity<Object> getAllUsers () {
        return new ResponseEntity<>(usersService.findAllUsers(), HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    ResponseEntity<Object> getUsersById (@PathVariable Long id) {
        return new ResponseEntity<>(usersService.findUsersById(id), HttpStatus.OK);
    }
    @GetMapping("/users/{id}/cars")
    ResponseEntity<Object> getUsersTravels (@PathVariable Long id) {
        return new ResponseEntity<>(usersService.findUsersTravels(id), HttpStatus.OK);
    }

    @PostMapping("/users")
    ResponseEntity<Object> createUsers (@Valid @RequestBody UsersDto usersDto, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            StringBuilder sb = new StringBuilder();
            for (FieldError error : bindingResult.getFieldErrors()){
                sb.append(error.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            UsersDto newUser = usersService.createUsers(usersDto);
            return new ResponseEntity<>(newUser, HttpStatus.CREATED);
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
            return new ResponseEntity<>(usersService.updateUsers(usersDto, id), HttpStatus.OK);
        }

    }

    @DeleteMapping("/users/{id}")
    ResponseEntity<Object> deleteUsers (@PathVariable Long id) {
        return new ResponseEntity<>(usersService.deleteUsers(id), HttpStatus.OK);
    }

}
