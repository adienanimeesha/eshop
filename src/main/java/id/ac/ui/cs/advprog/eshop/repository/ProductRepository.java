package id.ac.ui.cs.advprog.eshop.repository;

import id.ac.ui.cs.advprog.eshop.model.Product;
import org.springframework.stereotype.Repository;

@Repository
public class ProductRepository extends AbstractRepository<Product> implements ProductRepositoryInterface {

    public ProductRepository() {
        // pass the getter and setter for productId
        super(Product::getProductId, Product::setProductId);
    }

    @Override
    protected void updateEntity(Product existing, Product updatedEntity) {
        existing.setProductName(updatedEntity.getProductName());
        existing.setProductQuantity(updatedEntity.getProductQuantity());
    }
}
