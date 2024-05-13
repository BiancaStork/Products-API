package codoacodo.products.service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codoacodo.products.exceptions.ResourceNotFoundException;
import codoacodo.products.models.Brand;
import codoacodo.products.models.Product;
import codoacodo.products.repository.BrandRepository;
import codoacodo.products.repository.ProductRepository;

@Service

public class ProductService {
    @Autowired
    ProductRepository productRepository;

    @Autowired
    BrandRepository brandRepository;

//Trae todos los productos (todavia no, desde el DTO)
 // public List<FlightDto> allFlights(){
  public List<Product> allProducts(){      
    List<Product> products = productRepository.findAll();
    // double dolarPrice = getDolar();
    // return productUtils.productMapperList(products, dolarPrice); 
    return products;   
}


//buscar por id
  public Product productById(Long id) throws ResourceNotFoundException {
   
    return productRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Product not found", "Product", "id", id));    
  }

//ofertas  
public List<Product> getOffers(Integer offerPrice) {
    List<Product> products = productRepository.findAll();
    //return productUtils.detectedOffers(products, offerPrice);
    return products;    
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
