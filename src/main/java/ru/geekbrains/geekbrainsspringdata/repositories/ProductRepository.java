package ru.geekbrains.geekbrainsspringdata.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.geekbrainsspringdata.entities.Product;

import java.util.List;
import java.util.Optional;


@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT P.title FROM Product P WHERE LOWER(P.title) LIKE LOWER(concat('%', concat(?1, '%')))")
    List<String> findByTitle(String title);

    List<Product> findAllByPriceGreaterThanEqual(int min);

    List<Product> findAllByPriceLessThanEqual(int max);

    List<Product> findAllByPriceGreaterThanEqualAndPriceLessThanEqual(int min, int max);

}
