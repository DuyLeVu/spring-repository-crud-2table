package service.product;

import model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import service.IGeneralService;

public interface IProductService extends IGeneralService<Product> {
    Page<Product> findByName(String name, Pageable pageable);

    Iterable<Product> findAllByOrderByPrice();

    Page<Product> findAll(Pageable pageable);
}
