package codoacodo.products.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Brand {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Long id;
    private String logo;
    private String name;
    private String web;


    public Brand(String logo, String name, String web) {
        this.logo = logo;
        this.name = name;
        this.web = web;
    }
}
