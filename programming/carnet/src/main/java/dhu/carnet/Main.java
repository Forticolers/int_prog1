package dhu.carnet;

import dhu.carnet.domain.Carnet;
import dhu.carnet.console.Controler;
import dhu.carnet.domain.CarnetPleinException;

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
