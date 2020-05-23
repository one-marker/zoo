package ru.marker.ObserverPattern;

import ru.marker.Animals.Animal;
import ru.marker.Events.Event;

import java.util.ArrayList;
import java.util.List;

public class Observable{

    /**
     * The Observable object has many observers
     */
    private List<Observer> observers;

    public Observable() {
        this.observers = new ArrayList<>();
    }


    /**
     * This method to adding observer to observable object
     * @param observer
     */
    public void addObserver(Observer observer) {
        this.observers.add(observer);
    }

    /**
     * Observable can notify all observers that observable something did {@link Event}
     * @param event This is event that observable did
     */
    public void notifyAllObservers(Event event){

        for (Observer observer : this.observers) {
            observer.callEvent(this, event);
        }
    }



    /**
     * We can call all observers about they states
     * @param states
     * @return True is someone of observers has true and false if all observer's has false
     */
    public boolean getStatusAllObservers(Animal.States states) {
        for (Observer observer : this.observers) {
            if (observer.callEvent(states) == true) {
                return true;
            }
        }

        return false;
    }




}
