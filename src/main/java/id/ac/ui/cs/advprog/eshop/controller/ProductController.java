package id.ac.ui.cs.advprog.eshop.controller;

import id.ac.ui.cs.advprog.eshop.model.Product;
import id.ac.ui.cs.advprog.eshop.service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    private static final String REDIRECT_PRODUCT_LIST = "redirect:/product/list";
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping("/create")
    public String createProductPage(Model model) {
        model.addAttribute("product", new Product());
        return "CreateProduct";
    }

    @PostMapping("/create")
    public String createProductPost(@ModelAttribute Product product) {
        if (product != null) {
            service.create(product);
        }
        return REDIRECT_PRODUCT_LIST;
    }

    @GetMapping("/list")
    public String productListPage(Model model) {
        List<Product> allProducts = service.findAll();
        model.addAttribute("products", allProducts != null ? allProducts : List.of());
        return "ProductList";
    }

    @GetMapping("/edit/{id}")
    public String editProductPage(@PathVariable String id, Model model) {
        Product product = service.findById(id);
        if (product == null) {
            return REDIRECT_PRODUCT_LIST;
        }
        model.addAttribute("product", product);
        return "EditProduct";
    }

    @PostMapping("/edit/{id}")
    public String editProductPost(@PathVariable String id, @ModelAttribute Product product) {
        if (product != null) {
            product.setProductId(id);
            service.update(id, product);
        }
        return REDIRECT_PRODUCT_LIST;
    }

    @GetMapping("/delete/{id}")
    public String deleteProduct(@PathVariable String id) {
        if (id != null && !id.isEmpty()) {
            service.delete(id);
        }
        return REDIRECT_PRODUCT_LIST;
    }
}
