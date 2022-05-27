package com.graduation.backend.controller;

import com.graduation.backend.dto.UsersDto;
import com.graduation.backend.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import javax.validation.*;
import java.util.List;

@RestController
public class UsersController {

    @Autowired
    UsersService service;

    @GetMapping("/users")
    ResponseEntity<Object> getUsers () {
        List<UsersDto> ud = service.getUsers();
        return new ResponseEntity<>(ud, HttpStatus.OK);
    }
    @GetMapping("/users/{id}")
    ResponseEntity<Object> getUsersById (@PathVariable Long id) {
        return new ResponseEntity<>(service.getUsersById(id), HttpStatus.OK);
    }

    @PostMapping("users")
    ResponseEntity<Object> createUsers (@Valid @RequestBody UsersDto cdto, BindingResult br) {
        if (br.hasErrors()) {
            StringBuilder sb = new StringBuilder();
            for (FieldError error : br.getFieldErrors()) {
                sb.append(error.getDefaultMessage());
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            service.createUsers(cdto);
            return new ResponseEntity<>("User created", HttpStatus.CREATED);
        }
    }

    @PutMapping("/users/{id}")
    ResponseEntity<Object> updateUsers (@PathVariable Long id, @Valid @RequestBody UsersDto udto , BindingResult br) {
        if(br.hasErrors()){
            StringBuilder sb = new StringBuilder();
            for (FieldError error : br.getFieldErrors()){
                sb.append(error);
                sb.append("\n");
            }
            return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
        } else {
            service.updateUsers(udto, id);
            return new ResponseEntity<>("User updated", HttpStatus.OK);
        }
    }


    @DeleteMapping("users/{id}")
    ResponseEntity<Object> deleteUsers (@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteUsers(id), HttpStatus.OK);
    }
}

