package repository;

import model.Category;
import model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends JpaRepository<Product, Integer> {
    Iterable<Product> findAllByCategory(Category category);

    Iterable<Product> findByNameContaining(String name);

    @Modifying
    @Query("SELECT e FROM Product e ORDER BY e.price ASC")
    Iterable<Product> findAllByOrderByPrice();

}
