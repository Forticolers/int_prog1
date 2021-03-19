package carnet;

import carnet.domain.Carnet;
import carnet.console.Controler;
import carnet.domain.CarnetPleinException;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class Main {
    
    public static void main(String[] args) throws CarnetPleinException{
        Controler console = new Controler(Carnet.getInstanceDeDemo());
        console.execute();
    }
}
