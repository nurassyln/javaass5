package com.company.entities;

import java.util.List;

public class Necklace {
    private int id;
    private String name;
    private List<Stone> stones;
    private int weight;
    private int price;


    public Necklace() {
    }

    public Necklace(String name, int weight, int price) {
        this.name = name;
        this.weight = weight;
        this.price = price;
    }
    public Necklace(String name, List<Stone> necklace, int weight, int price) {
        this.name = name;
        this.stones = necklace;
        this.weight = weight;
        this.price = price;
    }

    public Necklace(int id, String name, List<Stone> necklace, int weight, int price) {
        this.id = id;
        this.name = name;
        this.stones = necklace;
        this.weight = weight;
        this.price = price;
    }

    public List<Stone> getStones() {
        return stones;
    }

    public void setStones(List<Stone> stones) {
        this.stones = stones;
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

    public List<Stone> getNecklace() {

        return stones;
    }

    public void setNecklace(List<Stone> necklace) {

        this.stones = necklace;
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

    @Override
    public String toString() {
        return "Necklace{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", necklace=" + stones +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }

}
