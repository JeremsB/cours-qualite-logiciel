package com.tactfactory.monprojetsb.monprojetsb.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import com.tactfactory.monprojetsb.monprojetsb.entities.Product;
import com.tactfactory.monprojetsb.monprojetsb.repositories.ProductRepository;
import com.tactfactory.monprojetsb.monprojetsb.repositories.UserRepository;

@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase(replace = Replace.NONE)
@DataJpaTest
@EntityScan(basePackages="com.tactfactory.monprojetsb")
@ComponentScan(basePackages="com.tactfactory.monprojetsb")
public class ProductServiceTest {

	@Autowired
    private ProductService productService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ProductRepository productRepository;

    /**
     * Vider Db
     */
    @Before
    public void clear() {
        this.productRepository.deleteAll();
        this.userRepository.deleteAll();
    }
   
    @Test
    public void TestInsertOne() {
        Long before = productRepository.count();
        productService.save(new Product());
        Long after = productRepository.count();
        assertEquals(before + 1, after);
    }

    @Test
    public void TestInsertProduct() {
        Product product = new Product(null, "product1", (float) 10);
        Long id = productService.save(product).getId();
        Product productFetch = productRepository.getProductById(id);
        assertTrue(compare(product, productFetch));
    }

    @Test
    public void TestUpdateProduct() {
        Product product = new Product(null, "product1", (float) 10);
        Long id = productService.save(product).getId();
        Product productFetch = productRepository.getProductById(id);
        productFetch.setPrice((float) 20);
        Long idUpdated = productService.save(productFetch).getId();
        Product productFetchUpdated = productRepository.getProductById(id);

        assertTrue(compare(productFetch, productFetchUpdated));
    }

    @Test
    public void TestGetProduct() {
        Product productBase = new Product(null, "product1", (float) 10);
        Long id = productRepository.save(productBase).getId();
        Product productFetch = productService.getProductById(id);
        assertTrue(compare(productBase, productFetch));
    }

    @Test
    public void TestGetProducts() {
        List<Product> products = new ArrayList<Product>();
        Product product1 = new Product(null, "produitun", (float) 10);
        products.add(product1);
        Product product2 = new Product(null, "produitdeux", (float) 10);
        products.add(product2);
        productService.saveList(products);
        List<Product> productsFetch = productService.findAll();
        for (int i = 0; i < productsFetch.size(); i++) {
            assertTrue(compare(products.get(i), productsFetch.get(i)));
        }
    }

    @Test
    public void TestDeleteOne() {
        Product productTemp = new Product();
        productService.save(productTemp);
        Long before = productRepository.count();
        productService.delete(productTemp);
        Long after = productRepository.count();
        assertEquals(before - 1, after);
    }

    @Test
    public void TestDeleteProduct() {
        Product productBase = new Product(null, "product1", (float) 10);
        Long id = productRepository.save(productBase).getId();
        productService.delete(productBase);
        Product deletedProduct = productService.getProductById(id);
        assertNull(deletedProduct);
    }

    public Boolean compare(Product produitun, Product produitdeux) {
        boolean result = true;

        if (!produitun.getId().equals(produitdeux.getId())) {
            result = false;
            System.out.println("Id- " + produitun.getId() + " " + produitdeux.getId());
        }
        if (!produitun.getName().equals(produitdeux.getName())) {
            result = false;
            System.out.println("Nom- " + produitun.getName() + " " + produitdeux.getName());
        }
        if (!produitun.getPrice().equals(produitdeux.getPrice())) {
            result = false;
            System.out.println("Prix- " + produitun.getPrice() + " " + produitdeux.getPrice());
        }

        return result;
    }

	
}
