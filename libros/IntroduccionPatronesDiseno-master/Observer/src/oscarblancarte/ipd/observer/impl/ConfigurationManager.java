package oscarblancarte.ipd.observer.impl;

import java.text.NumberFormat;
import java.text.SimpleDateFormat;

/**
 * @author Oscar Javier Blancarte Iturralde
 * @see http://www.oscarblancarteblog.com
 */

/*La clase ConfigurationManager es la clase que queremos observar 
debido a que en ella se encuentra la configuración de fecha y moneda*/
public class ConfigurationManager extends AbstractObservable {

    private SimpleDateFormat defaultDateFormat;
    private NumberFormat moneyFormat;

    private static ConfigurationManager configurationManager;

    private ConfigurationManager() {
    }

    public static ConfigurationManager getInstance() {
        if (configurationManager == null) {
            configurationManager = new ConfigurationManager();
        }
        return configurationManager;
    }

    public SimpleDateFormat getDefaultDateFormat() {
        return defaultDateFormat;
    }

    public void setDefaultDateFormat(SimpleDateFormat defaultDateFormat) {
//        System.out.println("Date Format change > " + 
//                (this.defaultDateFormat!=null 
//                        ?this.defaultDateFormat.toPattern():"Null") + " to " 
//                + defaultDateFormat.toPattern());
        this.defaultDateFormat = defaultDateFormat;
        notifyAllObservers("defaultDateFormat", this);
    }

    public NumberFormat getMoneyFormat() {
        return moneyFormat;
    }

    public void setMoneyFormat(NumberFormat moneyFormat) {
//        System.out.println("Date Format change > ");
        this.moneyFormat = moneyFormat;
        notifyAllObservers("moneyFormat", this);
    }
}