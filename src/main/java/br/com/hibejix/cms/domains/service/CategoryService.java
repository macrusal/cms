package br.com.hibejix.cms.domains.service;

import br.com.hibejix.cms.domains.models.Category;
import br.com.hibejix.cms.domains.repository.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public CategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    public Category update(final Category category) {
        return this.categoryRepository.save(category);
    }

    public Category create(final Category category) {
        return this.categoryRepository.save(category);
    }

    public void delete(final String id) {
        final Category category = this.categoryRepository.findOne(id);
        this.categoryRepository.delete(category);
    }

    public List<Category> findAll() {
        return this.categoryRepository.findAll();
    }

    public Category findOne(final String id) {
        return this.categoryRepository.findOne(id);
    }
}
