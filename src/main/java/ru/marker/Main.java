package ru.marker;

import ru.marker.Animals.Animal;
import ru.marker.Events.Event;
import ru.marker.Zoo.Zoo;

import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        System.out.println("ZOO START");

        Zoo zoo = null;
        try {
            zoo = new Zoo("input.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        zoo.getAnimals().get(0).eat();
        System.out.println(zoo.getAnimals().toString());
        Event.feedAnimal(zoo, Animal.Types.Carnivore);
        System.out.println(zoo.getAnimals().toString());



    }
}
