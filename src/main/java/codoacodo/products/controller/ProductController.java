package codoacodo.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import codoacodo.products.models.Product;
import codoacodo.products.models.ProductDto;
import codoacodo.products.service.ProductService;

@RestController
@RequestMapping("/products")

public class ProductController {
     @Autowired
    private ProductService productService;

    @PostMapping("/new")
    public void saveNew(@RequestBody Product product, @RequestParam Long brandId) {  
        System.out.println("Brand pasado por RequesParam:" + brandId);     
        productService.newProduct(product, brandId);
    }

    @GetMapping()
    public List<ProductDto> getAll(){
        return productService.allProducts();
    }

    @GetMapping("/{id}")
    public Product getById(@PathVariable Long id){
        return productService.productById(id);
    }
    
    @GetMapping("/offers")
    public List<Product> getByPrice(@RequestParam Integer price)    {
        return productService.getOffers(price);
    }

    
    @PutMapping("/update")
    public Product update(@RequestBody Product product) {
        return productService.updateProduct(product);
    }

   @DeleteMapping("delete/{id}")
    public void delete(@PathVariable Long id) {               
       productService.deleteProduct(id);
    }
    

}
