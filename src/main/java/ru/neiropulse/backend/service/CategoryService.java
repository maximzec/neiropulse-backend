package ru.neiropulse.backend.service;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.neiropulse.backend.dto.category.CategoryDto;
import ru.neiropulse.backend.model.Category;
import ru.neiropulse.backend.repository.CategoryRepository;
import ru.neiropulse.backend.mapper.CategoryMapper;

import java.util.ArrayList;

@Slf4j
@Service
@AllArgsConstructor
public class CategoryService extends Throwable {

    @Autowired
    private CategoryRepository repository;

    public CategoryDto createCategory(CategoryDto categoryDto) {

        if (categoryDto.getName() == null) {
            log.error("Error while creating category: name is empty");
            throw new RuntimeException("Error while creating category: name is empty");
        }
        Category category = CategoryMapper.mapToCategory(categoryDto);
        Category savedCategory = repository.save(category);
        return CategoryMapper.mapToCategoryDto(savedCategory);
    }

    @Transactional
    public CategoryDto updateCategory(CategoryDto categoryDto) {

        if (categoryDto.getId() == 0){
            log.error("Error while updating category: id is empty");
            throw new RuntimeException("Error while updating category: id is empty");
        }

        if (repository.existsById(categoryDto.getId())) {
            Category oldCategoryData = repository.findById(categoryDto.getId()).get();
            if (categoryDto.getName() != null) {
                oldCategoryData.setName(categoryDto.getName());
            }
            if (categoryDto.getIsHidden() != oldCategoryData.getIsHidden()) {
                oldCategoryData.setIsHidden(categoryDto.getIsHidden());
            }
            Category updatedCategory = repository.save(oldCategoryData);
            return CategoryMapper.mapToCategoryDto(updatedCategory);
        } else {
            log.warn("Warning while updating category.No such category found with id:{}", categoryDto.getId());
            throw new RuntimeException("Warning while updating category.No such category found with id:{}" + categoryDto.getId());
        }
    }

    public CategoryDto deleteCategories(int id) {



        if (!repository.existsById(id)) {
            log.warn("Warning while deleting category.No such category found with id:{}", id);
            throw new RuntimeException("No such a category with id:" + id);
        } else {
            CategoryDto deletedCategory = CategoryMapper.mapToCategoryDto(repository.findById(id).get());
            repository.deleteById(id);
            log.info("Successfully deleted categories");
            return  deletedCategory;
        }

    }

}
