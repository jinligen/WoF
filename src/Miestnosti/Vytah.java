/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Miestnosti;

import Hra.IPrikazy;
import Hra.Prikaz;

/**
 *
 * @author kajanek6
 */
public class Vytah extends Miestnost implements IPrikazy {
    private int poschodie;
    
    public Vytah(String nazov, String popis) {
        super(nazov, popis);
        this.poschodie = 0;
    }
    
        // konstantne pole nazvov prikazov
    private static final String[] PLATNE_PRIKAZY = {
        "chodNaPoschodie","vypisPoschodia"
    };

    public String[] getPlatnePrikazy() {
        return PLATNE_PRIKAZY;
    }
    
    @Override
    public void getPrikazy() {
        for (String string : PLATNE_PRIKAZY) {
            System.out.print(string + " ");
        }
    }

    @Override
    public boolean spracujPrikaz(Prikaz prikaz) {
        String nazovPrikazu = prikaz.getNazov();
        switch(nazovPrikazu) {
            case "chodNaPoschodie":
                break;
            case "vypisPoschodia":
                break;
        }
        return false;
    }    
}
