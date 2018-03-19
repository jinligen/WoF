package Hrac;


import Itemy.ItemType;
import Itemy.Kluc;
import Itemy.IItem;
import Dvere.ZamykatelneDvere;
import Hra.Prikaz;
import java.util.ArrayList;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author kajanek6
 */
public class Hrac {
    private String meno;
    private Inventar inventar;

    public Hrac(String meno) {
        this.meno = meno;
        this.inventar = new Inventar();
    }

    public Inventar getInventar() {
        return inventar;
    }
    
    public boolean maKlucKDveram(ZamykatelneDvere dvere) {
        for (IItem item : inventar.getInventar()) {
            if (item.getTyp() == ItemType.ITEM_KLUC) {
                Kluc kluc = (Kluc)item;
                if (kluc.getDvere() == dvere)
                    return true;
            }   
        }
        return false;
    }
    
    public void nasadItem(String nazov) {
        inventar.nasadItem(nazov);
    }
}
