package Dvere;


import Hrac.Hrac;
import Miestnosti.Miestnost;
import Dvere.IDvere;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kajanek6
 */
public class ZamykatelneDvere implements IDvere {
    private Miestnost vstup;
    private Miestnost vystup;
    private boolean jeZamknute;

    public ZamykatelneDvere(Miestnost vstup, Miestnost vystup) {
        this.vstup = vstup;
        this.vystup = vystup;
        this.jeZamknute = true;
    }
    
    public void prepniStavZamknutia() {
        this.jeZamknute = !this.jeZamknute;
        if (this.jeZamknute)
            System.out.println("Dvere sa zamkli.");
        else
            System.out.println("Dvere sa odomkli.");
    }
    
    @Override
    public Miestnost skusPrechod(Miestnost odkial, Hrac hrac) {
        if (this.jeZamknute) {
            System.out.println("Dvere su zamknute.");
            return null;   
        }
        
        Miestnost ciel;
        if (odkial == vstup) {
            ciel = vystup;
        } else {
            ciel = vstup;
        }
        return ciel;
    }

    @Override
    public String toString() {
        return this.vstup.getNazov() + "->" + this.vystup.getNazov();
    }
}
