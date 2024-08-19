package ru.neiropulse.backend.controller;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import ru.neiropulse.backend.dto.CategoryDto;
import ru.neiropulse.backend.service.CategoryService;


@RequestMapping("/api/v1/category")
@RestController
@AllArgsConstructor
public class CategoryController {

    @Autowired
    private final CategoryService service;


    @PostMapping("")
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto categoryDto) {
        return ResponseEntity.ok(categoryDto);
    }

}