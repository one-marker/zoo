package ru.marker.Animals;

import ru.marker.Events.Event;
import ru.marker.ObserverPattern.Observable;

/**
 * The class models the behavior of herbivores
 */
public class Herbivore extends Animal{


    public Herbivore(String type) {
        super(type);
    }

    @Override
    public String toString() {
        return super.toString() + "\nHerbivore{}";
    }

    /**
     * Method for comparing animal types
     * @param type
     * @return  true if this animal type equals input animal type
     */
    @Override
    public boolean equals(Animal.Types type) {
        if (type == Types.Herbivore) return true;
        return false;
    }
    /**
     * The method handles the event when someone is going to feed animals
     * @param observable
     * @param event
     */
    @Override
    public void callEvent(Observable observable, Event event) {
        super.callEvent(observable, event);
        if ((event == Event.FEED_HERBIVORE) && (this.getState() != States.NOISE)) {
            this.noise();
            observable.notifyAllObservers(Event.NOISE);
        }
    }
}
