package com.ag_regalos.AG;
import java.util.List;
public class Preferences {
    private float maxPrice;
    private List<String> preferredFlowers;
    private List<String> preferredColors;
    private List<String> preferredSizes;
    private List<String> preferredPresentations;
    public Preferences(float maxPrice, List<String> preferredFlowers, List<String> preferredColors, List<String> preferredSizes, List<String> preferredPresentations) {
        this.maxPrice = maxPrice;
        this.preferredFlowers = preferredFlowers;
        this.preferredColors = preferredColors;
        this.preferredSizes = preferredSizes;
        this.preferredPresentations = preferredPresentations;
    }

    public float getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(float maxPrice) {
        this.maxPrice = maxPrice;
    }

    public List<String> getPreferredFlowers() {
        return preferredFlowers;
    }

    public void setPreferredFlowers(List<String> preferredFlowers) {
        this.preferredFlowers = preferredFlowers;
    }

    public List<String> getPreferredColors() {
        return preferredColors;
    }

    public void setPreferredColors(List<String> preferredColors) {
        this.preferredColors = preferredColors;
    }

    public List<String> getPreferredSizes() {
        return preferredSizes;
    }

    public void setPreferredSizes(List<String> preferredSizes) {
        this.preferredSizes = preferredSizes;
    }

    public List<String> getPreferredPresentations() {
        return preferredPresentations;
    }

    public void setPreferredPresentations(List<String> preferredPresentations) {
        this.preferredPresentations = preferredPresentations;
    }

    @Override
    public String toString() {
        return "Preferences{" +
                "maxPrice=" + maxPrice +
                ", preferredFlowers=" + preferredFlowers +
                ", preferredColors=" + preferredColors +
                ", preferredSizes=" + preferredSizes +
                ", preferredPresentations=" + preferredPresentations +
                '}';
    }
}
