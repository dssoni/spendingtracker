package dev.dhruv.spendingtracker.repository;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Repository;

import dev.dhruv.spendingtracker.model.TransactionCategory;
import jakarta.annotation.PostConstruct;

@Repository
public class CategoryListRepository {

        private final Set<TransactionCategory> categories = new HashSet<TransactionCategory>();

        public CategoryListRepository() {

        }
    
        public Set<TransactionCategory> findAllCategories() {
            return categories;
        }

        public boolean existsById(Integer id) {
            return categories.stream().filter(c -> c.id().equals(id)).count() == 1;
        }

        public void addUpdateCategory(TransactionCategory category) {
            categories.removeIf(c -> c.id().equals(category.id()));
            categories.add(category);
        }

        public Optional<TransactionCategory> findCategoryByID(Integer id) {
            return categories.stream().filter(c -> c.id().equals(id)).findFirst();
        }

        public void removeCategory(Integer id) {
            categories.removeIf(c -> c.id().equals(id));
        }

        @PostConstruct
        public void init() {
            TransactionCategory groceryCategory = new TransactionCategory(1,"GROCERY");
            TransactionCategory utilityCategory = new TransactionCategory(2,"UTILITY");
            categories.add(groceryCategory);
            categories.add(utilityCategory);
        }

}
