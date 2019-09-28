package oscarblancarte.ipd.observer.impl;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */

/*Clase abstracta que utilizaremos como base para crear nuevos objetos Observables, 
la clase hereda de IObservable por lo que implementamos sus métodos.*/
public abstract class AbstractObservable implements IObservable {
    /*tenemos una lista de IObserver, éstos serán los Observer que 
    serán notificados cuando un cambio ocurra*/
    private final List<IObserver> observers = new ArrayList<>();

    
    /*Se implementan los métodos addObserver y removeObserver con el fin 
    de registrar y dar de baja a los Observers*/
    @Override
    public void addObserver(IObserver observer) {
        this.observers.add(observer);
    }

    @Override
    public void removeObserver(IObserver observer) {
        this.observers.remove(observer);
    }
    /*El método notifyAllObservers notificará a todos los 
    Observer que se encuentren en la lista observers*/
    @Override
    public void notifyAllObservers(String command, Object source) {
        for (IObserver observer : observers) {
            observer.notifyObserver(command, source);
        }
    }
}