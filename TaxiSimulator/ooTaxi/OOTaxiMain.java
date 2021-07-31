
package ooTaxi;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * main Class: create a SImulation and execute it.
 * 
 * @author Nayeong Kim (s1006313)
 */
public class OOTaxiMain {

  public static void main(String[] args) {
    SimulationExecute sim = new SimulationExecute();
    
      try {
          sim.sim();
      } catch (InterruptedException ex) {
          Logger.getLogger(OOTaxiMain.class.getName()).log(Level.SEVERE, null, ex);
      }
    
  }
}
