package com.graduation.backend.controller;

import com.graduation.backend.dto.FavoritesDto;
import com.graduation.backend.service.FavoritesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

@RestController
public class FavoritesController {

    @Autowired
    FavoritesService service;


    @GetMapping("/favorites")
    public ResponseEntity<Object> getFavorites() {
        List<FavoritesDto> fd = service.getFavorites();
        return new ResponseEntity<>(fd, HttpStatus.OK);
    }

    @GetMapping("/favorites/{id}")
    ResponseEntity<Object> getFavoritesById (@PathVariable Long id) {
        FavoritesDto favos = service.getFavoritesById(id);
        return new ResponseEntity<>(favos, HttpStatus.OK);
    }

        @PostMapping("/favorites")
        ResponseEntity<Object> createFavorites (@Valid @RequestBody FavoritesDto fDto, BindingResult br) throws IOException {
            if(br.hasErrors()){
                StringBuilder sb = new StringBuilder();
                for (FieldError error : br.getFieldErrors()){
                    sb.append(error);
                    sb.append("\n");
                }
                return new ResponseEntity<>(sb.toString(), HttpStatus.BAD_REQUEST);
            } else {
                FavoritesDto newFavo = service.createFavorites(fDto);
                return new ResponseEntity<>(newFavo, HttpStatus.CREATED);
            }

        }

    @DeleteMapping("favorites/{id}")
    ResponseEntity<Object> deleteFavorites (@PathVariable Long id) {
        return new ResponseEntity<>(service.deleteFavorites(id), HttpStatus.OK);
    }

}

