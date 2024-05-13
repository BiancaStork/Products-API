package codoacodo.products.utils;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import java.util.ArrayList;

import codoacodo.products.models.Product;

@Component

public class ProductUtils {
    public List<Product> productsOffers(List<Product> productsList, double offerPrice){
        List<Product> offers = new ArrayList<>();
        offers= productsList.stream().filter (p -> p.getPrice()<= offerPrice).collect(Collectors.toList());
        return offers;

    }

}
