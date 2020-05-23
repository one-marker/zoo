package ru.marker.Events;

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
                break;
            case NIGHT:
                break;
            case THUNDER:
                break;
            default:
                throw new NullPointerException();
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
            throw new NullPointerException();
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