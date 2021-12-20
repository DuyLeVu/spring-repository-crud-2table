package service.category;

import model.Category;

import java.util.Optional;

public class CategoryService implements ICategoryService {
    @Override
    public Iterable<Category> findAll() {
        return null;
    }

    @Override
    public Optional<Category> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void save(Category category) {

    }

    @Override
    public void remove(int id) {

    }
}
