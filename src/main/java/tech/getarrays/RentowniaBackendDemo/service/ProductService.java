package tech.getarrays.RentowniaBackendDemo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.getarrays.RentowniaBackendDemo.model.Product;
import tech.getarrays.RentowniaBackendDemo.repository.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }
    public Product addProduct(Product product){
        return productRepository.save(product);
    }
    public Product getProductById(Long productId){ //implement exception if record not exists
        return productRepository.getProductById(productId);
    }
    public List<Product> getAllProducts(){
        List<Product> productList = productRepository.findAll();
        return productList;
    }
    public Product updateProduct(Product product){
        return productRepository.save(product);
    }
    public void deleteProductById(Long productId){ //implement exception if record not exists
        productRepository.deleteById(productId);
    }

}
