package codoacodo.products.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
    private double price;

     @ManyToOne
    @JoinColumn(name="brand_id")    
    private Brand brand;

    
    public Product(String name, String size, String color, String category, double price) {
        this.name = name;
        this.size = size;
        this.color = color;
        this.category = category;
        this.price = price;
    }



}
