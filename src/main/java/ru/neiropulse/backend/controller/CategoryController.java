package ru.neiropulse.backend.controller;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import ru.neiropulse.backend.dto.category.CategoryDto;
import ru.neiropulse.backend.service.CategoryService;

import java.util.ArrayList;


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

    @PatchMapping("")
    public ResponseEntity<CategoryDto> update(@RequestBody CategoryDto dto) {
        log.info("Requested to update a category");
        CategoryDto updatedCategory = service.updateCategory(dto);
        log.info("Succesufully updated category with id: {}", dto.getId());
        return ResponseEntity.ok(updatedCategory);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<CategoryDto> delete(@PathVariable int id) {
        log.info("Requested to delete category with id");
        CategoryDto deletedCategory = service.deleteCategories(id);
        return ResponseEntity.ok(deletedCategory);

    }
}