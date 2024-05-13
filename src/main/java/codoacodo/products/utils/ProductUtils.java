package codoacodo.products.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

import codoacodo.products.models.Product;
import codoacodo.products.models.ProductDto;

@Component

public class ProductUtils {
    public List<Product> productsOffers(List<Product> productsList, double offerPrice){
        List<Product> offers = new ArrayList<>();
        offers= productsList.stream().filter (p -> p.getPrice()<= offerPrice).collect(Collectors.toList());
        return offers;

    }

    public List<ProductDto> productMapperList(List<Product> products, double dolarPrice) {
       List<ProductDto> productDtoList = new ArrayList<>();
       for (Product p : products){
        productDtoList.add(new ProductDto(p.getId(), p.getName(), p.getSize(),p.getColor(), p.getCategory(), p.getPrice()* dolarPrice, p.getBrand()));
       };
       return productDtoList;
    }

}
