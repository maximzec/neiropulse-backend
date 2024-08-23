package ru.neiropulse.backend.mapper;

import ru.neiropulse.backend.dto.category.CategoryDto;
import ru.neiropulse.backend.model.Category;

public class CategoryMapper {

    public static CategoryDto mapToCategoryDto(Category model) {
        return new CategoryDto(
                model.getId(),
                model.getName(),
                model.getIsHidden()
        );
    }

    public static Category mapToCategory(CategoryDto dto){
        return new Category(
                dto.getId(),
                dto.getName(),
                dto.getIsHidden()
        );
    }
}
