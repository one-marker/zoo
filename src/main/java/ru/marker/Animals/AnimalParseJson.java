package ru.marker.Animals;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Class to Parse JSON file
 */
public class AnimalParseJson {


    @SerializedName("Carnivore")
    private List<Carnivore> carnivores;

    @SerializedName("Herbivore")
    private List<Herbivore> herbivores;

    /**
     * get all animals
     * @return list of animals
     */
    public List<Animal> getAnimals() {
        //System.out.println(carnivores);
        List<Animal> animals = new ArrayList<>();
        animals.addAll(carnivores);
        animals.addAll(herbivores);
        return animals;
    }


}
