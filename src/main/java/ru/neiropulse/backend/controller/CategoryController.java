package ru.neiropulse.backend.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.parameters.RequestBody;
import jakarta.validation.Valid;
import ru.neiropulse.backend.dto.CategoryDto;


@RequestMapping("/api/v1/category")
@RestController
public class CategoryController {

    @PostMapping("")
    public ResponseEntity<CategoryDto> create(@Valid @RequestBody CategoryDto categoryDto) {
        CategoryDto createdCategory = new CategoryDto();
        return ResponseEntity.ok(createdCategory);
    }

}