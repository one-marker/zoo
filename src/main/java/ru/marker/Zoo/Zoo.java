package ru.marker.Zoo;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonReader;
import ru.marker.Animals.Animal;
import ru.marker.Animals.AnimalParseJson;
import ru.marker.Animals.Carnivore;
import ru.marker.Animals.Herbivore;
import ru.marker.Events.Event;
import ru.marker.ObserverPattern.Observable;
import ru.marker.ObserverPattern.Observer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Zoo extends Observable {

    private Event zooAtmos = Event.MORNING;
    private List<Animal> animals;

    public Zoo(String Path) throws NullPointerException,
            FileNotFoundException,
            com.google.gson.JsonSyntaxException {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();

        JsonReader jsonReader = new JsonReader(new FileReader(new File(Path)));
        AnimalParseJson animalParseJson = gson.fromJson(jsonReader, AnimalParseJson.class);


        this.animals = new ArrayList<>();

        addAnimals(animalParseJson.getAnimals());
       // addAnimals(animalParseJson.getHerbivores());


    }

    /**
     * The method to get atmosphere from zoo
     * @return Event MORNING | THUNDER | NIGHT
     */
    public Event getZooAtmos() {
        return zooAtmos;
    }

    /**
     * The method to set atmosphere in zoo
     * @param zooAtmos
     */
    public void setZooAtmos(Event zooAtmos) {
        this.zooAtmos = zooAtmos;
    }

    /**
     * The method to add animals in zoo
     * @param animals
     */
    public void addAnimals(List<?> animals) {
        for (Object animal : animals) {
            if (animal instanceof Herbivore || animal instanceof Carnivore) {
                this.animals.add((Animal) animal);
                this.addObserver((Observer) animal);
            }
        }
    }
    /**
     * Метод Преобразует класс {@link Zoo} к строке.
     * @return строка типа {@link String}. Формат: совокупность строк {@link Herbivore#toString()} или {@link Carnivore#toString()}.
     */
    @Override
    public String toString() {
        String str = "";
        for (Animal animal : this.animals) {
            str += animal.toString() + "\n";
        }
        return str;
    }

    /**
     * Method to get animals from zoo
     * @return list of animals
     */
    public List<Animal> getAnimals(){return this.animals;}


}
