package codoacodo.products.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codoacodo.products.configuration.ProductsConfiguration;
import codoacodo.products.exceptions.ResourceNotFoundException;
import codoacodo.products.models.Brand;
import codoacodo.products.models.Product;
import codoacodo.products.models.ProductDto;
import codoacodo.products.repository.BrandRepository;
import codoacodo.products.repository.ProductRepository;
import codoacodo.products.utils.ProductUtils;

@Service

public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    BrandRepository brandRepository;

    @Autowired
    ProductUtils productUtils;

    @Autowired
    ProductsConfiguration productsConfiguration;



//Trae todos los productos
 public List<ProductDto> allProducts(){    
    List<Product> products = productRepository.findAll();
    double dolarPrice = getDolar();
    return productUtils.productMapperList(products, dolarPrice); 
  
}


private double getDolar() {
 return productsConfiguration.FetchDolar().getPromedio();
}


  //buscar por id
  public Product productById(Long id) throws ResourceNotFoundException {   
    return productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found", "Product", "id", id));    
  }

//ofertas  
public List<Product> getOffers(Integer offerPrice) {
    List<Product> products = productRepository.findAll();
    return productUtils.productsOffers(products, offerPrice);
    
}

//crear/agregar nuevo producto
  public void newProduct(Product product, Long brandId) throws ResourceNotFoundException{    
    System.out.println("Brand pasada por parametro" + brandId);
    Brand brand = brandRepository.findById(brandId).orElseThrow(()-> new ResourceNotFoundException("Brand not found", "Brand", "id", brandId));  
    product.setBrand(brand);;
    productRepository.save(product);
  }

//Actualiza un producto existente
  public Product updateProduct(Product product) throws ResourceNotFoundException{
    //guardo los cambios
    productRepository.save(product);
    return productRepository.findById(product.getId()).orElseThrow(()-> new ResourceNotFoundException("Product not found", "Product", "id", product.getId()));
  }

//Elimina un vuelo de la base de datos
  public void deleteProduct(Long id) throws ResourceNotFoundException {
    productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found", "Product", "id", id));
    productRepository.deleteById(id);
  }



}
