package dhu.carnet;

import dhu.carnet.domain.Carnet;
import dhu.carnet.console.Controler;
import dhu.carnet.domain.CarnetPleinException;

/**
 *
 * @author dominique huguenin (dominique.huguenin at rpn.ch)
 */
public class Main {

    public static void main(String[] args) throws CarnetPleinException {
        if (args.length == 0) {
            Controler console = new Controler(Carnet.getInstanceDeDemo(), true);
            console.execute();
        } else {
            try{
            Controler console = new Controler(Carnet.getInstanceDeDemo(), args[0], Boolean.parseBoolean(args[1]));
            console.execute();
            }catch(Exception ex){
                throw new RuntimeException(ex);
            }
        }
    }
}
