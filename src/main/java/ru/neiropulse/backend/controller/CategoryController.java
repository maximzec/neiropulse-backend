package ru.neiropulse.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.connector.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.springframework.web.server.ResponseStatusException;
import ru.neiropulse.backend.dto.category.CategoryDto;
import ru.neiropulse.backend.model.Category;
import ru.neiropulse.backend.service.CategoryService;


@RequestMapping("/api/v1/category")
@RestController
@AllArgsConstructor
@Slf4j
public class CategoryController extends Throwable {

    @Autowired
    private final CategoryService service;

    @PostMapping("")
    public ResponseEntity<CategoryDto> create(@RequestBody CategoryDto dto) {
        log.info("Requested to create category");
        CategoryDto savedCategory = service.createCategory(dto);
        log.info("Category successfully created");
        return ResponseEntity.ok(savedCategory);
    }

    @PatchMapping("")
    public ResponseEntity<?> update(@RequestBody CategoryDto dto) {
        log.info("Requested to update a category");
        CategoryDto updatedCategory;
        updatedCategory = service.updateCategory(dto);
        log.info("Succesufully updated category with id: {}", dto.getId());
        return ResponseEntity.ok(updatedCategory);
    }
}