package codoacodo.products.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import codoacodo.products.exceptions.ResourceNotFoundException;
import codoacodo.products.models.Brand;
import codoacodo.products.repository.BrandRepository;

@Service
public class BrandService {

@Autowired
BrandRepository brandRepository;

//agregar-crear nuevo
public void newBrand(Brand brand){
    System.out.println("desde el Service:" + brand);
    brandRepository.save(brand);
  }


//Listar todas
   public List<Brand> allBrands(){      
    List<Brand> brands = brandRepository.findAll();
    return brands;   
}


//por id
  public Brand brandById(Long id) throws ResourceNotFoundException {
   
    return brandRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Brand not found", "Brand", "id", id));    
  }


//Actualizar
  public Brand updateBrand(Brand brand) throws ResourceNotFoundException{
    //guardo los cambios
    brandRepository.save(brand);
    return brandRepository.findById(brand.getId()).orElseThrow(()-> new ResourceNotFoundException("Brand not found", "Brand", "id", brand.getId()));
  }

//Eliminar
  public void deleteBrand(Long id) throws ResourceNotFoundException {
    brandRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Brand not found", "Brand", "id", id));
    brandRepository.deleteById(id);
  }


}
