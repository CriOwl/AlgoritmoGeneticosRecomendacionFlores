package com.ag_regalos.AG;

import java.util.ArrayList;
import java.util.List;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Gene;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
public class AlgoritmoGenetico {
        private Configuration config;
        private Preferences preferences;
        private List<Producto> products;
        private IChromosome bestProducts=null;
        public void loadListProducts() {
        products = new ArrayList<>();
        products.add(new Producto(
                "Amor Eterno",
                49.99f,
                List.of("Naturales"),
                List.of("Rojo", "Blanco"),
                List.of("Grande"),
                List.of("Ramo"),
                4.8f));
        products.add(new Producto(
                "Sueño Rosa",
                39.99f,
                List.of("Artificiales"),
                List.of("Rosado", "Pastel"),
                List.of("Mediano"),
                List.of("Caja"),
                4.5f));
        products.add(new Producto(
                "Primavera Dorada",
                59.99f,
                List.of("Mixtas"),
                List.of("Amarillo", "Dorado"),
                List.of("Grande"),
                List.of("Canasta"),
                4.9f));
        products.add(new Producto(
                "Luxury Roses",
                79.99f,
                List.of("Naturales"),
                List.of("Rojo"),
                List.of("Grande"),
                List.of("Florero"),
                5.0f));
        products.add(new Producto(
                "Sunshine Bouquet",
                29.99f,
                List.of("Naturales"),
                List.of("Amarillo", "Naranja"),
                List.of("Pequeño"),
                List.of("Ramo"),
                4.2f));
        products.add(new Producto(
                "Caja Romance",
                44.99f,
                List.of("Artificiales"),
                List.of("Rojo", "Rosado"),
                List.of("Mediano"),
                List.of("Caja"),
                4.6f));
        products.add(new Producto(
                "Elegancia Blanca",
                54.99f,
                List.of("Naturales"),
                List.of("Blanco"),
                List.of("Grande"),
                List.of("Florero"),
                4.7f));
        products.add(new Producto(
                "Golden Flowers",
                64.99f,
                List.of("Mixtas"),
                List.of("Dorado", "Amarillo"),
                List.of("Grande"),
                List.of("Canasta"),
                4.9f));
        products.add(new Producto(
                "Pure Love",
                34.99f,
                List.of("Naturales"),
                List.of("Rosado"),
                List.of("Pequeño"),
                List.of("Ramo"),
                4.1f));
        products.add(new Producto(
                "Deluxe Garden",
                89.99f,
                List.of("Mixtas"),
                List.of("Multicolor"),
                List.of("Grande"),
                List.of("Canasta"),
                5.0f));
        products.add(new Producto(
                "Pasión Roja",
                69.99f,
                List.of("Naturales"),
                List.of("Rojo"),
                List.of("Grande"),
                List.of("Caja"),
                4.8f));
        products.add(new Producto(
                "Fantasy Bloom",
                15.99f,
                List.of("Artificiales"),
                List.of("Morado", "Azul"),
                List.of("Mediano"),
                List.of("Florero"),
                4.3f));
        products.add(new Producto(
                "Magic Spring",
                37.99f,
                List.of("Mixtas"),
                List.of("Verde", "Blanco"),
                List.of("Mediano"),
                List.of("Ramo"),
                4.4f));
        products.add(new Producto(
                "Blue Sky",
                31.99f,
                List.of("Artificiales"),
                List.of("Azul"),
                List.of("Pequeño"),
                List.of("Caja"),
                4.0f));
        products.add(new Producto(
                "Royal Gold",
                95.99f,
                List.of("Naturales"),
                List.of("Dorado", "Blanco"),
                List.of("Grande"),
                List.of("Florero"),
                5.0f));
        products.add(new Producto(
                "Sweet Moments",
                27.99f,
                List.of("Naturales"),
                List.of("Pastel"),
                List.of("Pequeño"),
                List.of("Ramo"),
                4.1f));
        products.add(new Producto(
                "Dream Box",
                48.99f,
                List.of("Artificiales"),
                List.of("Rosado", "Blanco"),
                List.of("Mediano"),
                List.of("Caja"),
                4.5f));
        products.add(new Producto(
                "Nature Mix",
                58.99f,
                List.of("Mixtas"),
                List.of("Multicolor"),
                List.of("Grande"),
                List.of("Canasta"),
                4.7f));
        products.add(new Producto(
                "Romantic Night",
                73.99f,
                List.of("Naturales"),
                List.of("Rojo", "Negro"),
                List.of("Grande"),
                List.of("Caja"),
                4.9f));
        products.add(new Producto(
                "Fresh Harmony",
                33.99f,
                List.of("Naturales"),
                List.of("Blanco", "Verde"),
                List.of("Mediano"),
                List.of("Florero"),
                4.3f));
        }

        public void init(Preferences preferences){
                this.preferences= preferences;
                loadListProducts();
                try {
                        //Metodo de seleccion BestChromosomesSelector (Ranking)(90) , Ruleta(Random) (10)
                        //Metodo de cruce es CrossoverOperator (Mutacion por corte)
                        //Probabilidad de mutar (1/12)
                        config=new DefaultConfiguration();
                        FuncionFitness funcionF= new FuncionFitness(products,preferences);
                        config.setFitnessFunction(funcionF);
                        config.setPopulationSize(20);
                        //Cromosomas
                        //Solo un cromosoma que representa el index de la lista de la cual se escoge el mejor valor
                        Gene[] genEx = new Gene[1];
                        genEx[0]=new IntegerGene(config,0,products.size()-1);
                        genEx[0].setAllele(0);
                        Chromosome cromosoma= new Chromosome(config,genEx);
                        bestProducts=cromosoma;
                        config.setSampleChromosome(cromosoma);
                } catch (Exception e) {
                        System.out.println(e);
                }
        }
        public void funcionarAlgoritmoGenetico(){
                try {
                        Genotype population = Genotype.randomInitialGenotype(config);
                        IChromosome bestSolution= bestProducts;
                        for (int i = 0; i < 10; i++) {
                            population.evolve(5);
                            IChromosome candidateBestSolution = population.getFittestChromosome();
                                if (candidateBestSolution.getFitnessValue() > bestSolution.getFitnessValue()) {
                                        bestSolution = candidateBestSolution;
                                }
                        }
                        System.out.println("-------------------------");
                        Producto bestProduct= products.get(((IntegerGene)bestSolution.getGene(0)).intValue());
                        System.out.println("Recomendacion: "+bestProduct.toString());
                } catch (Exception e) {
                        System.out.println(e);
                }
        }
}
