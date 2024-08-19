package ru.neiropulse.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.neiropulse.backend.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer> {
}
