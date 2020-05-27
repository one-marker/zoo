package ru.marker;

import org.apache.log4j.PropertyConfigurator;
import ru.marker.Animals.Animal;
import ru.marker.Events.Event;
import ru.marker.Zoo.Zoo;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Main {

    public static void main(String[] args) throws IOException {

        //connecting log4j settings
        Properties props = new Properties();
        props.load(new FileInputStream("src/main/resources/log4j.properties"));
        PropertyConfigurator.configure(props);

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

        Event.feedAnimal(zoo, null);


    }
}
