package service.category;

import model.Category;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repository.ICategoryRepository;
import repository.IProductRepository;

import java.util.Optional;
@Service
public class CategoryService implements ICategoryService {

    @Autowired
    private ICategoryRepository iCategoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return iCategoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(int id) {
        return iCategoryRepository.findById(id);
    }

    @Override
    public void save(Category category) {
        iCategoryRepository.save(category);
    }

    @Override
    public void remove(int id) {

    }
}
