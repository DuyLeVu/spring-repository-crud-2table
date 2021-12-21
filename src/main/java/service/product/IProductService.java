package service.product;

import model.Product;
import service.IGeneralService;

public interface IProductService extends IGeneralService<Product> {
    Iterable<Product> findByName(String name);

    Iterable<Product> findAllByOrderByPrice();
}
