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
interface Contestant {
    public int guess();         // Which door the Contestant chooses; could be random or fixed
    public boolean change();    // Whether they want to switch or stay; true for a Switcher 
}


