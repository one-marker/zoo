package ru.marker.Events;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.marker.Animals.Animal;
import ru.marker.Zoo.Zoo;

/**
 * enum Event include all event what can happen in zoo
 */
public enum Event {

    FEED_CARNIVORE,
    FEED_HERBIVORE,
    NOISE,
    MORNING,
    NIGHT,
    THUNDER;


    private static final Logger logger = LoggerFactory.getLogger(Event.class);

    /**
     * This method convert animal type to event
     * @param animalType Herbivore | Carnivore
     * @return
     */
    private static Event feedEvent(Animal.Types animalType) {
        if (animalType == Animal.Types.Herbivore) return FEED_HERBIVORE;
        return FEED_CARNIVORE;
    }


    /**
     * This method set atmos in zoo
     * @param zoo
     * @param atmos MORNING | THUNDER |NIGHT
     */
    public static void setAtmos(Zoo zoo, Event atmos) {
        switch (atmos) {
            case MORNING:
                logger.info("event MORNING");
                break;
            case NIGHT:
                logger.info("event NIGHT");
                break;
            case THUNDER:
                logger.info("event THUNDER");
                break;
            default:
                logger.error("event not available");
                return;
        }

        zoo.setZooAtmos(atmos);
        zoo.notifyAllObservers(atmos);
    }

    /**
     * This method is created to feed animal with special type
     * @param zoo
     * @param type animals type that  we want to feed
     */
    public static void feedAnimal(Zoo zoo, Animal.Types type) {
        if (type == null) {
            logger.error("event not available");
            return;
        }

        zoo.notifyAllObservers(Event.feedEvent(type));

        for (Animal animal : zoo.getAnimals()) {
            if (animal.equals(type)) {
                animal.eat();
            }
        }
        setAtmos(zoo, zoo.getZooAtmos());


    }



}