package ru.marker.ObserverPattern;


import ru.marker.Animals.Animal;
import ru.marker.Events.Event;

/**
 * Who looks at observable
 */
public interface Observer {

    public void callEvent(Observable observable, Event event);

    public boolean callEvent(Animal.States states);
}
