package com.example.carrental;

public class Cars2 {
    private String marca;
    private String model;
    private String company;

    public Cars2(String marca, String model, String company){
        this.marca = marca;
        this.model = model;
        this.company = company;
    }

    public String getMarca1() {
        return marca;
    }

    public String getModel1() {
        return model;
    }

    public String getCompany1() {
        return company;
    }

    @Override
    public String toString() {
        return company + "; " + marca + "; " +  model;
    }
}
