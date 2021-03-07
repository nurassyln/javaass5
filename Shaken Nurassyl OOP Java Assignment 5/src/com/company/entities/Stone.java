package com.company.entities;

public class Stone {
    private int id;
    private String name;
    private int weight;
    private int price;


    public Stone(String name, int price, int weight) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public Stone(int id, String name, int price, int weight) {
        this.id = id;
        this.name = name;
        this.weight = weight;
        this.price = price;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {

        this.weight = weight;
    }
    public int getPrice() {

        return price;
    }

    public void setPrice(int price) {

        this.price = price;
    }

}
