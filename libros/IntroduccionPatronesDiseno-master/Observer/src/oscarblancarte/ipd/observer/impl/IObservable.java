package oscarblancarte.ipd.observer.impl;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */

//Esta es la interface que todos los objetos que desean ser observados deberán implementar.
public interface IObservable {
    /*addObserver: Permite registrar un Observer con el fin de ser notificado 
    cuando algún cambio suceda.*/
    public void addObserver(IObserver observer);
    /*removeObserver: Permite a un Observer darse de baja, con lo que ya no
    será notificado cuando algún cambio suceda*/
    public void removeObserver(IObserver observer);
    /*notifyAllObservers: Método desde el cual se notifica un cambio a los Observers. 
    Cuando un cambio ocurra en la configuración este método será ejecutado,
    notificando a todos los observer registrados.*/
    public void notifyAllObservers(String command, Object source);
}