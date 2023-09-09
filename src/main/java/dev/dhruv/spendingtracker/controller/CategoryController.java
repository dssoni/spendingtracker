package dev.dhruv.spendingtracker.controller;

import java.util.Set;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import dev.dhruv.spendingtracker.model.TransactionCategory;
import dev.dhruv.spendingtracker.repository.CategoryListRepository;

@RestController
@RequestMapping("/api/transaction/category")
public class CategoryController {

    private CategoryListRepository categoryRepo = new CategoryListRepository();

    public CategoryController(CategoryListRepository categoryRepo) {
        this.categoryRepo = categoryRepo;
    }

    @GetMapping("")
    public Set<TransactionCategory> findAllCategories() {
        return categoryRepo.findAllCategories();
    }

    @GetMapping("/{id}")
    public TransactionCategory findCategoryByID(@PathVariable Integer id) {
        return categoryRepo.findCategoryByID(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found!"));
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    public void Category(@RequestBody TransactionCategory category) {
        categoryRepo.addUpdateCategory(category);
    }

    @PutMapping("/{id}")
    public void updateCategory(@RequestBody TransactionCategory category, @PathVariable Integer id) {

        if(!categoryRepo.existsById(id) || !category.id().equals(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Category not found!");
        }

        categoryRepo.addUpdateCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Integer id) {
        categoryRepo.removeCategory(id);
    }

}
