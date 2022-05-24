package com.example.carrental;

public class Cars {
    private String marca;
    private String model;

    public Cars(String marca, String model){
        this.marca = marca;
        this.model = model;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public String toString(){
        String aux = model +", " + marca;
        return  aux;
    }
}
