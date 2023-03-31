package com.richard.domain;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class ProductService {

    private Map<Long, Product> products = new HashMap<>() {
        {
            put(1L, new Product(1L, "Notebook", "Mackbook pro"));
            put(2L, new Product(1L, "Notebook", "XPS"));
            put(3L, new Product(1L, "Notebook", "Zephyrus"));
            put(4L, new Product(1L, "Notebook", "Thinkpad"));
            put(5L, new Product(1L, "Notebook", "Avell"));
        }
    };

    @Cacheable("products")
    public Product getById(Long id) {
        System.out.println("Buscando produtos ...");
        simulateLatancy();
        return  products.get(id);
    }

    private void simulateLatancy() {
        try {
            long time = 1000L;
            Thread.sleep(time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }


}
