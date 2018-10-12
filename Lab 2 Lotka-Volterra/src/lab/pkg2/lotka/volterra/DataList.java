/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg2.lotka.volterra;

import java.util.ArrayList;

/**
 *
 * @author sophiaanderson
 */
public class DataList extends ArrayList<DataPair>{
    
    
    public String toString() {
        String returnMe="DPLIST:";
        
        for (DataPair nextPair : this) {
            returnMe += "\n\t" + nextPair.toString();
        }
        
        return returnMe;
    }
    
}
