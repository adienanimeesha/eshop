package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class ProductRepositoryTest {

    @InjectMocks
    ProductRepository productRepository;

    // new repository for each test
    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
    }

    @Test
    void testCreateAndFind() {
        Product product = new Product();
        product.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product.setProductName("Sampo Cap Bambang");
        product.setProductQuantity(100);
        productRepository.create(product);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product.getProductId(), savedProduct.getProductId());
        assertEquals(product.getProductName(), savedProduct.getProductName());
        assertEquals(product.getProductQuantity(), savedProduct.getProductQuantity());
    }

    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindAllIfMoreThanOneProduct() {
        Product product1 = new Product();
        product1.setProductId("eb558e9f-1c39-460e-8860-71af6af63bd6");
        product1.setProductName("Sampo Cap Bambang");
        product1.setProductQuantity(100);
        productRepository.create(product1);

        Product product2 = new Product();
        product2.setProductId("a0f9de46-90b1-437d-a0bf-d0821dde9096");
        product2.setProductName("Sampo Cap Usep");
        product2.setProductQuantity(50);
        productRepository.create(product2);

        Iterator<Product> productIterator = productRepository.findAll();
        assertTrue(productIterator.hasNext());
        Product savedProduct = productIterator.next();
        assertEquals(product1.getProductId(), savedProduct.getProductId());
        savedProduct = productIterator.next();
        assertEquals(product2.getProductId(), savedProduct.getProductId());
        assertFalse(productIterator.hasNext());
    }

    // positive: edit an existing product
    @Test
    void testUpdateProductSuccess() {
        Product product = new Product();
        product.setProductId("ec5c6afa-4d69-4be7-9e80-6ec3f336369d");
        product.setProductName("Old Name");
        product.setProductQuantity(30);
        productRepository.create(product);

        Product updatedProduct = new Product();
        updatedProduct.setProductName("JJoongrami");
        updatedProduct.setProductQuantity(150);

        Product result = productRepository.update("ec5c6afa-4d69-4be7-9e80-6ec3f336369d", updatedProduct);

        assertNotNull(result);
        assertEquals("JJoongrami", result.getProductName());
        assertEquals(150, result.getProductQuantity());
    }

    // negative: update a non-existent product
    @Test
    void testUpdateProductFailure() {
        Product updatedProduct = new Product();
        updatedProduct.setProductName("Delusional");
        updatedProduct.setProductQuantity(30);

        Product result = productRepository.update("3a59877b-2dbf-4e0f-a75b-e7beff5a2194", updatedProduct);

        assertNull(result);
    }

    // positive: delete an existing product
    @Test
    void testDeleteProductSuccess() {
        Product product = new Product();
        product.setProductId("ec5c6afa-4d69-4be7-9e80-6ec3f336369d");
        product.setProductName("Bye Jjoongrami");
        product.setProductQuantity(10);
        productRepository.create(product);

        productRepository.delete("ec5c6afa-4d69-4be7-9e80-6ec3f336369d");

        Product deletedProduct = productRepository.findById("ec5c6afa-4d69-4be7-9e80-6ec3f336369d");
        assertNull(deletedProduct);
    }

    // negative: delete a non-existent product
    @Test
    void testDeleteProductFailure() {
        productRepository.delete("3a59877b-2dbf-4e0f-a75b-e7beff5a2194");
        assertFalse(productRepository.findAll().hasNext());
    }
}
