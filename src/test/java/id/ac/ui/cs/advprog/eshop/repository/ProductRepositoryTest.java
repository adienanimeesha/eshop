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

    @BeforeEach
    void setUp() {
        productRepository = new ProductRepository();
    }

    // create tests
    @Test
    void testCreate_WithNullId() {
        Product product = new Product();
        product.setProductId(null);

        Product createdProduct = productRepository.create(product);

        assertNotNull(createdProduct.getProductId());
        assertFalse(createdProduct.getProductId().isEmpty());
    }

    @Test
    void testCreate_WithEmptyId() {
        Product product = new Product();
        product.setProductId("");

        Product createdProduct = productRepository.create(product);

        assertNotNull(createdProduct.getProductId());
        assertFalse(createdProduct.getProductId().isEmpty());
    }

    // find tests
    @Test
    void testFindAllIfEmpty() {
        Iterator<Product> productIterator = productRepository.findAll();
        assertFalse(productIterator.hasNext());
    }

    @Test
    void testFindById_WhenProductExists() {
        Product product = new Product();
        product.setProductId("1");
        productRepository.create(product);
        Product foundProduct = productRepository.findById("1");
        assertNotNull(foundProduct);
        assertEquals("1", foundProduct.getProductId());
    }

    @Test
    void testFindById_WhenProductDoesNotExist() {
        Product foundProduct = productRepository.findById("999");
        assertNull(foundProduct);
    }

    @Test
    void testFindById_WhenIdIsNull() {
        Product foundProduct = productRepository.findById(null);
        assertNull(foundProduct);
    }

    @Test
    void testFindById_WhenIdIsEmpty() {
        Product foundProduct = productRepository.findById("");
        assertNull(foundProduct);
    }

    // update tests
    @Test
    void testUpdateProductSuccess() {
        Product product = new Product();
        product.setProductId("1");
        product.setProductName("Old Name");
        product.setProductQuantity(30);
        productRepository.create(product);

        Product updatedProduct = new Product();
        updatedProduct.setProductName("JJoongrami");
        updatedProduct.setProductQuantity(150);
        Product result = productRepository.update("1", updatedProduct);
        assertNotNull(result);
        assertEquals("JJoongrami", result.getProductName());
        assertEquals(150, result.getProductQuantity());
    }

    @Test
    void testUpdate_WhenProductDoesNotExist() {
        Product updatedProduct = new Product();
        updatedProduct.setProductName("Delusional");
        updatedProduct.setProductQuantity(30);
        Product result = productRepository.update("non-existing-id", updatedProduct);
        assertNull(result);
    }

    @Test
    void testUpdate_WhenNameIsNull() {
        Product product = new Product();
        product.setProductId("1");
        product.setProductName("Old Name");
        product.setProductQuantity(50);
        productRepository.create(product);
        Product updatedProduct = new Product();
        updatedProduct.setProductName(null);
        updatedProduct.setProductQuantity(60);
        Product result = productRepository.update("1", updatedProduct);
        assertNotNull(result);
        assertNull(result.getProductName());
        assertEquals(60, result.getProductQuantity());
    }

    @Test
    void testUpdate_WhenQuantityIsNotSet() {
        Product product = new Product();
        product.setProductId("1");
        product.setProductName("Old Name");
        product.setProductQuantity(50);
        productRepository.create(product);
        Product updatedProduct = new Product();
        updatedProduct.setProductName("New Name");
        Product result = productRepository.update("1", updatedProduct);
        assertNotNull(result);
        assertEquals("New Name", result.getProductName());
        assertEquals(50, result.getProductQuantity()); // Quantity should remain unchanged
    }

    @Test
    void testUpdate_WhenIdDoesNotMatchAnyProduct() {
        Product updatedProduct = new Product();
        updatedProduct.setProductName("ShouldFail");
        updatedProduct.setProductQuantity(25);
        Product result = productRepository.update("non-existing-id", updatedProduct);
        assertNull(result);
    }

    @Test
    void testUpdate_WhenIdIsNull() {
        Product updatedProduct = new Product();
        updatedProduct.setProductName("ShouldFail");
        updatedProduct.setProductQuantity(10);
        Product result = productRepository.update(null, updatedProduct);
        assertNull(result);
    }

    @Test
    void testUpdate_WhenIdIsEmpty() {
        Product updatedProduct = new Product();
        updatedProduct.setProductName("ShouldFail");
        updatedProduct.setProductQuantity(10);
        Product result = productRepository.update("", updatedProduct);
        assertNull(result);
    }

    // delete tests
    @Test
    void testDelete_WhenProductExists() {
        Product product = new Product();
        product.setProductId("1");
        productRepository.create(product);

        productRepository.delete("1");

        assertNull(productRepository.findById("1"));
    }

    @Test
    void testDelete_WhenProductDoesNotExist() {
        productRepository.delete("non-existing-id");
        assertNull(productRepository.findById("non-existing-id"));
    }

    @Test
    void testDelete_WhenIdIsNull() {
        productRepository.delete(null);
    }

    @Test
    void testDelete_WhenIdIsEmpty() {
        productRepository.delete("");
    }
}
