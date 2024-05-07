package codoacodo.products.models;

import java.time.LocalDateTime;

import lombok.Data;



@Data

public class Dolar {
   
    private String moneda;
    private String casa;
    private String nombre;
    private double compra;
    private double venta;
    private LocalDateTime fechaActualizacion;
   
    public double getPromedio() {
        return ((getCompra()+ getVenta())/2);
    }
   

    
}

