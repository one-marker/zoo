import org.junit.Assert;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import ru.marker.Animals.Animal;
import ru.marker.Animals.Carnivore;
import ru.marker.Animals.Herbivore;
import ru.marker.Events.Event;
import ru.marker.Zoo.Zoo;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class TestZoo extends Assert {

    Zoo zoo;


    @Before
    public void CreateZoo() throws FileNotFoundException {
        this.zoo = new Zoo("input.json");
    }


    @Test
    public void FeedCarnivoreTest() {
        this.keepCalm();
        Event.setAtmos(this.zoo, Event.MORNING);
        Event.feedAnimal(zoo, Animal.Types.Carnivore);
        assertEquals("FeedCarnivore",
                Arrays.asList(
                        Animal.States.CALM,
                        Animal.States.CALM),
                Arrays.asList(
                        this.AnimalsState(Animal.Types.Carnivore),
                        this.AnimalsState(Animal.Types.Herbivore))
        );
    }

    @Test
    public void FeedHerbivoreTest() {
        this.keepCalm();
        Event.setAtmos(this.zoo, Event.MORNING);
        Event.feedAnimal(zoo, Animal.Types.Herbivore);
        assertEquals("FeedHerbivore",
                Arrays.asList(
                        Animal.States.NOISE,
                        Animal.States.CALM),
                Arrays.asList(
                        this.AnimalsState(Animal.Types.Carnivore),
                        this.AnimalsState(Animal.Types.Herbivore))
        );


    }


    @Test
    public void FeedHerbivoreCarnivoreTest() {
        this.keepCalm();
        Event.feedAnimal(zoo, Animal.Types.Herbivore);
        Event.feedAnimal(zoo, Animal.Types.Carnivore);
        assertEquals("FeedHerbivoreCarnivore",
                Arrays.asList(
                        Animal.States.CALM,
                        Animal.States.CALM),
                Arrays.asList(
                        this.AnimalsState(Animal.Types.Carnivore),
                        this.AnimalsState(Animal.Types.Herbivore))
        );
    }

    @Test
    public void FeedCarnivoreHerbivoreTest() {
            this.keepCalm();
            Event.feedAnimal(zoo, Animal.Types.Carnivore);
            Event.feedAnimal(zoo, Animal.Types.Herbivore);
            assertEquals("FeedCarnivoreHerbivore",
                    Arrays.asList(
                            Animal.States.NOISE,
                            Animal.States.CALM),
                    Arrays.asList(
                            this.AnimalsState(Animal.Types.Carnivore),
                            this.AnimalsState(Animal.Types.Herbivore))
            );
     }

    @Test
    public void SleepWithoutNoiseTest() {
        this.keepCalm();
        Event.setAtmos(this.zoo, Event.NIGHT);
        assertEquals("SleepWithoutNoise",
                Arrays.asList(
                        Animal.States.SLEEP,
                        Animal.States.SLEEP),
                Arrays.asList(
                        this.AnimalsState(Animal.Types.Carnivore),
                        this.AnimalsState(Animal.Types.Herbivore))
        );
    }

    @Test
    public void SleepWithHerbivoreNoiseTest() {
        this.keepCalm();


        Event.setAtmos(this.zoo, Event.NIGHT);
        Event.feedAnimal(zoo, Animal.Types.Herbivore);

        assertEquals("SleepWithHerbivoreNoise",
                Arrays.asList(
                        Animal.States.NOISE,
                        Animal.States.CALM),
                Arrays.asList(
                        this.AnimalsState(Animal.Types.Carnivore),
                        this.AnimalsState(Animal.Types.Herbivore))
        );


    }
    @Test
    public void SleepWithCarnivoreNoiseTest() {
        this.keepCalm();


        Event.setAtmos(this.zoo, Event.NIGHT);
        Event.feedAnimal(zoo, Animal.Types.Carnivore);

        assertEquals("SleepWithCarnivoreNoise",
                Arrays.asList(
                        Animal.States.SLEEP,
                        Animal.States.SLEEP),
                Arrays.asList(
                        this.AnimalsState(Animal.Types.Carnivore),
                        this.AnimalsState(Animal.Types.Herbivore))
        );


    }

    @Test
    public void ThunderTest() {
        this.keepCalm();
        Event.setAtmos(this.zoo, Event.THUNDER);
        assertEquals("Thunder",
                Arrays.asList(
                        Animal.States.NOISE,
                        Animal.States.NOISE),
                Arrays.asList(
                        this.AnimalsState(Animal.Types.Carnivore),
                        this.AnimalsState(Animal.Types.Herbivore))
        );
    }

    @Test
    public void WakeUpTest() {
        this.keepCalm();
        Event.setAtmos(this.zoo, Event.NIGHT);
        assertEquals("Sleep",
                Arrays.asList(
                        Animal.States.SLEEP,
                        Animal.States.SLEEP),
                Arrays.asList(
                        this.AnimalsState(Animal.Types.Carnivore),
                        this.AnimalsState(Animal.Types.Herbivore))
        );

        Event.setAtmos(this.zoo, Event.MORNING);
        assertEquals("Morning wake up",
                Arrays.asList(
                        Animal.States.CALM,
                        Animal.States.CALM),
                Arrays.asList(
                        this.AnimalsState(Animal.Types.Carnivore),
                        this.AnimalsState(Animal.Types.Herbivore))
        );
    }


    @Ignore
    public void keepCalm() {
        Event.feedAnimal(zoo, Animal.Types.Herbivore);
        Event.feedAnimal(zoo, Animal.Types.Carnivore);
    }
    @Ignore
    public Animal.States AnimalsState(Animal.Types type) {

        Iterator iterator = this.zoo.getAnimals().iterator();

        Animal animal = null;
        while (iterator.hasNext()){
            animal = (Animal)iterator.next();
            if (type == Animal.Types.Herbivore  && animal instanceof Herbivore) {
                return animal.getState();
            }
            if (type == Animal.Types.Carnivore  && animal instanceof Carnivore) {
                return animal.getState();
            }

        }



        return null;
    }
}
