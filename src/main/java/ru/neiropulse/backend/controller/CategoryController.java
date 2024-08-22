package ru.neiropulse.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ru.neiropulse.backend.dto.CategoryDto;
import ru.neiropulse.backend.service.CategoryService;


@RequestMapping("/api/v1/category")
@RestController
@AllArgsConstructor
@Slf4j
public class CategoryController {

    @Autowired
    private final CategoryService service;

    @PostMapping("")
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto dto) {
        log.info("Requested to create category");
        CategoryDto savedCategory = service.createCategory(dto);
        log.info("Category successfully created");
        return ResponseEntity.ok(savedCategory);
    }

}