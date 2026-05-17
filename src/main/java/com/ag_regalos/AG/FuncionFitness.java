package com.ag_regalos.AG;

import java.util.ArrayList;
import java.util.List;

import org.jgap.FitnessFunction;
import org.jgap.IChromosome;
import org.jgap.impl.IntegerGene;

public class FuncionFitness extends FitnessFunction {
    List<Producto> products;
    Preferences preferences;
    public FuncionFitness(List products,Preferences preferences){
        this.products=products;
        this.preferences=preferences;
    }
    @Override
    protected double evaluate(IChromosome chromosome) {
        double genreScore = 0;

        for (int i = 0; i < chromosome.size(); i++) {
            
            IntegerGene genInteger= (IntegerGene) chromosome.getGene(i);
            int index= genInteger.intValue();
            Producto producto = (Producto) products.get(index);
            genreScore = getScore(producto);
        }
        return genreScore;
    }
    
    private double getScore(Producto producto) {
    double score = 0;
    score += contarCoincidencias(producto.getTypeFlowers(), preferences.getPreferredFlowers());
    score += contarCoincidencias(producto.getColors(), preferences.getPreferredColors());
    score += contarCoincidencias(producto.getSize(), preferences.getPreferredSizes());
    score += contarCoincidencias(producto.getTypePresentations(), preferences.getPreferredPresentations());
    if (producto.getPrice() > preferences.getMaxPrice()) {
        score *= 0.10;
    }
        return (producto.getAverageStars() * 0.1)+score;
    }

    private int contarCoincidencias(List<String> listaProducto, List<String> listaPreferencias) {
        List<String> interseccion = new ArrayList<>(listaProducto);
        interseccion.retainAll(listaPreferencias); 
        return interseccion.size();
    }
}
