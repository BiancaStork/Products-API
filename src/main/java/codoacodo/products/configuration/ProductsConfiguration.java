package codoacodo.products.configuration;

import codoacodo.products.models.Dolar;

//import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration

public class ProductsConfiguration {

    @Bean  //componente dentro de un componente

    // @Value("${dollarApi.dollar_url}")
    // private String DOLLAR_API_URL;
  
    public RestTemplate restTemplate(){
        
   

        return new RestTemplate();

    }

    public Dolar FetchDolar(){
        RestTemplate restTemplate = restTemplate();
        String DOLLAR_API_URL = "https://dolarapi.com/v1/dolares/tarjeta";
        return restTemplate.getForObject(DOLLAR_API_URL, Dolar.class);
    }

}
