package com.ag_regalos.AG;
import java.util.List;

public class Producto{

    private float price;
    private List<String> typeFlowers;
    private List<String> colors;
    private List<String> size;
    private List<String> typePresentations;
    private float averageStars;
    private String name;
    
    

    public Producto(String name,float price, List<String> typeFlowers, List<String> colors, List<String> size, List<String> typePresentations, float averageStars) {
        this.price = price;
        this.typeFlowers = typeFlowers;
        this.colors = colors;
        this.size = size;
        this.typePresentations = typePresentations;
        this.averageStars = averageStars;
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public List<String> getTypeFlowers() {
        return typeFlowers;
    }

    public void setTypeFlowers(List<String> typeFlowers) {
        this.typeFlowers = typeFlowers;
    }

    public List<String> getColors() {
        return colors;
    }

    public void setColors(List<String> colors) {
        this.colors = colors;
    }

    public List<String> getSize() {
        return size;
    }

    public void setSize(List<String> size) {
        this.size = size;
    }

    public List<String> getTypePresentations() {
        return typePresentations;
    }

    public void setTypePresentations(List<String> typePresentations) {
        this.typePresentations = typePresentations;
    }

    public float getAverageStars() {
        return averageStars;
    }

    public void setAverageStars(float averageStars) {
        this.averageStars = averageStars;
    }
    
    @Override
    public String toString() {
        return "Producto{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", typeFlowers=" + typeFlowers +
                ", colors=" + colors +
                ", size=" + size +
                ", typePresentations=" + typePresentations +
                ", averageStars=" + averageStars +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
