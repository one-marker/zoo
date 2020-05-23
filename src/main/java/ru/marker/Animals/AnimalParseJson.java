package ru.marker.Animals;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Класс предназначен для корректной десериализации JSON объектов, содержащих информацию об животных из зоопарка
 */
public class AnimalDeserialize {


    @SerializedName("Carnivore")
    private List<Carnivore> carnivores;

    @SerializedName("Herbivore")
    private List<Herbivore> herbivores;


    public List<Animal> getAnimals() {
        List<Animal> animals = new ArrayList<>();
        animals.addAll(carnivores);
        animals.addAll(herbivores);
        return animals;
    }


}
