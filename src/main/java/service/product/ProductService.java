package service.product;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import repository.IProductRepository;

import java.util.Optional;

public class ProductService implements IProductService {


    @Autowired
    private IProductRepository iProductRepository;

    @Override
    public Iterable<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public Optional<Product> findById(int id) {
        return iProductRepository.findById(id);
    }

    @Override
    public void save(Product product) {
        iProductRepository.save(product);
    }

    @Override
    public void remove(int id) {
        iProductRepository.deleteById(id);
    }
}