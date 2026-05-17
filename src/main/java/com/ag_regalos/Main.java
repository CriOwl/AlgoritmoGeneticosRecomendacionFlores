package com.ag_regalos;
import java.util.List;

import com.ag_regalos.AG.AlgoritmoGenetico;
import com.ag_regalos.AG.Preferences;
public class Main {
    public static void main(String[] args) {
        AlgoritmoGenetico algoritmoGenetico= new AlgoritmoGenetico();
        float maxPrice=20;
        //TYPE_FLOWERS Naturales,Artificiales,Mixtas
        // COLORS Rojo "Blanco","Rosado","Amarillo","Azul","Morado","Naranja","Dorado","Plateado","Verde","Negro","Multicolor"
        //SIZES    "Pequeño","Mediano","Grande"
        //TYPE_PRESENTATIONS     "Ramo", "Caja", "Canasta", "Florero"
        // Estrellas 0-5
        // PRICES double 
        List<String> preferredFlowers= List.of("Artificiales");
        List<String> preferredColors= List.of("Azul","Rojo");
        List<String> preferredSizes= List.of("Mediano");
        List<String> preferredPresentations= List.of("Ramo","Caja");
        Preferences preferencias= new Preferences(maxPrice,preferredFlowers,preferredColors,preferredSizes,preferredPresentations);
        algoritmoGenetico.init(preferencias);
        algoritmoGenetico.funcionarAlgoritmoGenetico();
    }
}