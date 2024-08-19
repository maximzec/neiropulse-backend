package ru.neiropulse.backend.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.neiropulse.backend.dto.CategoryDto;
import ru.neiropulse.backend.model.Category;
import ru.neiropulse.backend.repository.CategoryRepository;
import ru.neiropulse.backend.mapper.CategoryMapper;

@Service
@AllArgsConstructor
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public CategoryDto createCategory(CategoryDto categoryDto) {
        Category category = CategoryMapper.mapToCategory(categoryDto);
        Category savedCategory = repository.save(category);
        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

}
