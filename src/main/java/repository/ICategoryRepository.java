package repository;

import model.Category;
import model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICategoryRepository extends JpaRepository<Category,Integer> {
    Iterable<Category> findAllByName(String name);
    Iterable<Category> findAllByNameOrderByName(String name);
}
