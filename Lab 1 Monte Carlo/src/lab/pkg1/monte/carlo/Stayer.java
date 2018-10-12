/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab.pkg1.monte.carlo;

/**
 *
 * @author sophiaanderson
 */
public class Stayer implements Contestant {

    @Override
    public int guess() {
        int random = (int) Math.floor(Math.random()*9)%3; 
        return random;
    }

    @Override
    public boolean change() {
        return false;
    }
    
}
