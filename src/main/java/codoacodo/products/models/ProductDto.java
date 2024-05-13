package codoacodo.products.models;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

public class ProductDto {
    private Long id;
    private String name;
    private String size;
    private String color;
    private String category;
    private double price;
    private Brand brand;

}
