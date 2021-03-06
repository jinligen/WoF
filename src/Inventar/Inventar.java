/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventar;

import Hra.Prikaz;
import Itemy.EquippableItem;
import Itemy.IItem;
import Itemy.ItemType;
import java.util.ArrayList;

/**
 *
 * @author kajanek6
 */
public class Inventar {
    private ArrayList<IItem> inventar;

    public Inventar() {
        this.inventar = new ArrayList<>();
    }

    public ArrayList<IItem> getInventar() {
        return inventar;
    }
    
    public boolean zoberItemDoInventara(IItem item) {
        this.inventar.add(item);
        return true;
    }
    
    public void odoberItemZInventara(IItem item) {
        this.inventar.remove(item);
    }
    
    public boolean oblecItem(IItem item) {
        return false;
    }

    public void vypisInventar() {
        for (IItem item : this.inventar) {
            System.out.print(item.getNazov() + " ");
        }
        System.out.println();
    }
    
    public void vypisInventar(ItemType typ) {
        for (IItem item : this.inventar) {
            if (item.getTyp() == typ)
                System.out.print(item.getNazov() + " ");
        }
        System.out.println();
    }

    public void vypisPopisItemu(Prikaz prikaz) {
        ArrayList<String> list = prikaz.getParameters();
        if (list.size() < 1) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Chod kam?");
            return;
        }

        String nazovItemu = list.get(0);
        for (IItem item : this.inventar) {
            if (item.getNazov().equals(nazovItemu))
            {
                System.out.println(item.getNazov() + ": " +item.getPopis());
                break;
            }
        }
    }

    public boolean maItem(String nazov) {        
        for (IItem item : inventar) {
            if (item.getNazov().equals(nazov))
               return true; 
        }
        return false;
    }
    
    public IItem dajItem(String nazov) {
        for (IItem item : inventar) {
            if (item.getNazov().equals(nazov))
               return item; 
        }
        return null;
    }
}
