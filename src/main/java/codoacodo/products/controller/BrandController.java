package codoacodo.products.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;

import codoacodo.products.models.Brand;
import codoacodo.products.service.BrandService;


@RestController
@RequestMapping("/brand")

public class BrandController {
    @Autowired
    private BrandService brandService;

    @PostMapping("/new")
    public void saveNew(@RequestBody Brand brand){
        System.out.println("desde el Controller:" + brand);
        brandService.newBrand(brand);
    }

    @GetMapping()
    public List<Brand> getAll(){
        return brandService.allBrands();
    }

    @GetMapping("/{id}")
    public Brand getById(@PathVariable Long id){
        return brandService.brandById(id);
    }

    @PutMapping("/update")
    public Brand update(@RequestBody Brand brand){
        return brandService.updateBrand(brand);
    }

    @DeleteMapping("/delete/{id}")
        public void delete(@PathVariable Long id){
            brandService.deleteBrand(id);
        }
    




}
