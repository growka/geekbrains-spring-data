package ru.geekbrains.geekbrainsspringdata.controllers;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.geekbrains.geekbrainsspringdata.entities.Product;
import ru.geekbrains.geekbrainsspringdata.repositories.ProductRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
@RequiredArgsConstructor
public class ProductController {

    private final ProductRepository productRepository;

    @GetMapping
    public List<Product> findAllProducts() {
        return (List<Product>) productRepository.findAll();
    }

    @GetMapping("/{id}")
    public Product getUserById(@PathVariable Long id) {
        return productRepository.findById(id).get();
    }

    @PostMapping
    public Product save(@RequestBody Product product) {
        return productRepository.save(product);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteById(@PathVariable Long id) {
        productRepository.deleteById(id);
    }

    @GetMapping("/higher")
    public Optional<List<Product>> findMinPrice(@RequestParam Integer min) {
        return Optional.ofNullable(productRepository.findAllByPriceGreaterThanEqual(min));
    }

    @GetMapping("/lower")
    public Optional<List<Product>> findMaxPrice(@RequestParam Integer max) {
        return Optional.ofNullable(productRepository.findAllByPriceLessThanEqual(max));
    }

    @GetMapping("/between")
    public Optional<List<Product>> finBetweenPrice(@RequestParam Integer min, @RequestParam Integer max) {
        return Optional.ofNullable(productRepository.findAllByPriceGreaterThanEqualAndPriceLessThanEqual(min, max));
    }

    @GetMapping("/find")
    public Optional<List<String>> findByTitle(@RequestParam String title) {
        return Optional.ofNullable(productRepository.findByTitle(title));
    }


}
