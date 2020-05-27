package ru.marker.Animals;

import ru.marker.Events.Event;
import ru.marker.ObserverPattern.Observable;
import ru.marker.ObserverPattern.Observer;

import java.util.Objects;

public abstract class Animal implements Observer {

    /**
     * Animal tupe
     */
    private String type;

    /**
     * Animal state
     */
    private States state;


    /**
     * Animal count
     */
    private int count;


    public Animal (String type) {
        this.type = type;
    }

    /**
     * Animal states: CALM | SLEEP | NOISE
     */
    public enum States {
        CALM,
        SLEEP,
        NOISE
    };

    /**
     *
     * @return Animal state
     */
    public final States getState() {
        return this.state;
    }


    /**
     *
     * @return Animal count
     */
    public int getCount() {
        return count;
    }


    /**
     * Animal types
     */
    public enum Types {
        Herbivore,
        Carnivore;
    };

    public void setType(String type) {
        this.type = type;
    }

    public void eat() {
        this.state = States.CALM;
    }

    public void noise() {
        this.state = States.NOISE;
    }

    public void sleep() {
        this.state = States.SLEEP;
    }

    public void wakeup() {
        this.state = States.CALM;
    }

    public String toString()
    {
        return "\n\nAnimal type: " + this.type +
                "\nAnimal state: " + this.state+
                "\nAnimal count: " + this.count;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return Objects.equals(type, animal.type) &&
                state == animal.state;
    }

    @Override
    public int hashCode() {
        return Objects.hash(type, state);
    }

    public abstract boolean equals(Types type);

    /**
     * This implements interface  {@link Observer}.
     * Observable can notify all observers that observable something did {@link Event}
     * This method call event for this animal {@link Event}
     * @param observable object class {@link Observable}
     * @param event событие {@link Event}, this event is calling by {@link Observable} in all {@link Observer}.
     * */
    @Override
    public void callEvent(Observable observable, Event event) {
        switch (event) {
            case THUNDER:
                    this.noise();
                break;
            case MORNING:
                if (this.state == States.SLEEP) {
                    this.wakeup();
                }
                break;
            case NIGHT:
                if (observable.getStatusAllObservers(States.NOISE) == false) {
                    this.sleep();
                }

                break;
        }
    }



    /**
     * Check animal status
     * @param states Animal object for compare
     * @return false if animals have different status
     */
    @Override
    public boolean callEvent(States states) {
        if (this.state == states) return true;
        return false;
    }


}
