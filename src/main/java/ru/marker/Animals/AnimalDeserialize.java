package com.sberbank.zoo;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Класс предназначен для корректной десериализации JSON объектов, содержащих информацию об животных из зоопарка
 */
public class AnimalDeserialize {

    @SerializedName("Herbivore")
    private List<Herbivore> herbivores;
    @SerializedName("Carnivore")
    private List<Carnivore> carnivores;

    public List<Herbivore> getHerbivores() {
        return this.herbivores;
    }
    public List<Carnivore> getCarnivores() {
        return this.carnivores;
    }
}
