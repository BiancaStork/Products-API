package codoacodo.products.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity  //me dice que esto sera almacenado en una bd




public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String name;
    private String size;
    private String color;
    private String category;
    private String brand_id;
    private double price;

    
    public Product(String name, String size, String color, String category, String brand_id, double price) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.category = category;
        this.brand_id = brand_id;
        this.price = price;
    }



}
