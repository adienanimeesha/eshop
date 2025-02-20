package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@ExtendWith(MockitoExtension.class)
class ProductControllerTest {

    private MockMvc mockMvc;

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    @InjectMocks
    private ProductController productController;

    @BeforeEach
    void setUp() {
        mockMvc = MockMvcBuilders.standaloneSetup(productController).build();
    }

    @Test
    void testCreateProductPage() throws Exception {
        mockMvc.perform(get("/product/create"))
                .andExpect(status().isOk())
                .andExpect(view().name("CreateProduct"));
    }

    @Test
    void testCreateProductPost() {
        Product product = new Product();
        String result = productController.createProductPost(product);

        verify(productService, times(1)).create(product);
        assertEquals("redirect:/product/list", result);
    }

    @Test
    void testProductListPage() throws Exception {
        when(productService.findAll()).thenReturn(List.of(new Product()));

        mockMvc.perform(get("/product/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("ProductList"));

        verify(productService, times(1)).findAll();
    }

    @Test
    void testProductListPage_WhenServiceReturnsNull() throws Exception {
        when(productService.findAll()).thenReturn(null); // Simulate null return

        mockMvc.perform(get("/product/list"))
                .andExpect(status().isOk())
                .andExpect(view().name("ProductList"));

        verify(productService, times(1)).findAll();
    }


    @Test
    void testEditProductPage_WhenProductExists() throws Exception {
        Product product = new Product();
        when(productService.findById("1")).thenReturn(product);

        mockMvc.perform(get("/product/edit/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("EditProduct"));

        verify(productService, times(1)).findById("1");
    }

    @Test
    void testEditProductPage_WhenProductDoesNotExist() throws Exception {
        when(productService.findById("1")).thenReturn(null);

        mockMvc.perform(get("/product/edit/1"))
                .andExpect(status().is3xxRedirection())
                .andExpect(view().name("redirect:/product/list"));

        verify(productService, times(1)).findById("1");
    }

    @Test
    void testEditProductPost() {
        Product product = new Product();
        String result = productController.editProductPost("1", product);

        verify(productService, times(1)).update("1", product);
        assertEquals("redirect:/product/list", result);
    }

    @Test
    void testDeleteProduct() {
        String result = productController.deleteProduct("1");

        verify(productService, times(1)).delete("1");
        assertEquals("redirect:/product/list", result);
    }

    @Test
    void testDeleteProduct_WithNullId() {
        String result = productController.deleteProduct(null);
        verify(productService, never()).delete(any());
        assertEquals("redirect:/product/list", result);
    }

    @Test
    void testDeleteProduct_WithEmptyId() {
        String result = productController.deleteProduct("");
        verify(productService, never()).delete(any());
        assertEquals("redirect:/product/list", result);
    }

}

