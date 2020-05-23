package ru.marker.Animals;

import ru.marker.Events.Event;
import ru.marker.ObserverPattern.Observable;

/**
 * The class models the behavior of carnivore
 */
public class Carnivore extends Animal{



    public Carnivore(String type){
        super(type);

    }
    @Override
    public String toString() {
        return super.toString() + "\nCarnivore{}";
    }

    /**
     * Method for comparing animal types
     * @param type
     * @return true if this animal type equals input animal type
     */
    @Override
    public boolean equals(Animal.Types type) {
        if (type == Animal.Types.Carnivore) return true;
        return false;
    }
    /**
     * The method handles the event when someone is making noise or someone is going to feed animals
     * @param observable
     * @param event
     */
    @Override
    public void callEvent(Observable observable, Event event) {
        super.callEvent(observable, event);
        if (((event == Event.FEED_CARNIVORE) || (event == Event.NOISE)) && (this.getState() != States.NOISE)) {
            this.noise();
            observable.notifyAllObservers(Event.NOISE);
        }
    }
}
