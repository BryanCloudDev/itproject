package com.itproject.itproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.itproject.itproject.model.Category;

import com.itproject.itproject.repository.CategoryRepository;

@Service
public class CategoryService {

  @Autowired
  private final CategoryRepository categoryRepository;

  public CategoryService(CategoryRepository categoryRepository) {
      this.categoryRepository = categoryRepository;
  }

  public Category createCategory(Category category) {
      return categoryRepository.save(category);
  }

  public List<Category> getAllCategories() {
      return categoryRepository.findAll();
  }

  public Category getCategoryById(Long id) {
      return categoryRepository.findById(id).orElse(null);
  }

  public Category updateCategory(Long id, Category updatedCategory) {
    return categoryRepository.findById(id)
      .map(category -> {
          category.setName(updatedCategory.getName());
          category.setFile(updatedCategory.getFile());
          return categoryRepository.save(category);
      })
      .orElse(null);
  }

  public void deleteCategory(Long id) {
      categoryRepository.deleteById(id);
  }
}
