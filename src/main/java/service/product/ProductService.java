package service.product;

import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Service;
import repository.IProductRepository;

import java.util.Optional;

@Service
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

    @Override
    public Page<Product> findByName(String name, Pageable pageable) {
        return iProductRepository.findAllByNameContaining(name, pageable);
    }

    @Override
    public Iterable<Product> findAllByOrderByPrice() {
      return iProductRepository.findAllByOrderByPrice();
    }

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return iProductRepository.findAll(pageable);
    }
}
