/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hrac;

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
    private EquippableItem [] sloty;
    public Inventar() {
        this.inventar = new ArrayList<>();
        this.sloty = new EquippableItem[SlotyInventara.MAX_SLOTOV.getValue()];
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

    public void vypisPopisItemu(Prikaz prikaz) {
        if (!prikaz.maParameter()) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Chod kam?");
            return;
        }

        String nazovItemu = prikaz.getParameter();
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
    
    public void nasadItem(String nazov) {
        IItem item = dajItem(nazov);
        if (item == null) {
            System.out.println("Nepodarilo sa najst item.");
            return;
        }
        
        if (item instanceof EquippableItem) {
            EquippableItem equipItem = (EquippableItem)item;
            int slotId = equipItem.getSlot().getValue();
            EquippableItem momentalnyItem = sloty[slotId];
            if (momentalnyItem != null) {
                this.zoberItemDoInventara(momentalnyItem);
            }
            sloty[slotId] = equipItem;
            this.odoberItemZInventara(equipItem);
        } else {
            System.out.println("Tento item sa neda nasadit.");
            return;
        }
    }
    
    public boolean maEquipnute(ItemType typ) {
        for (EquippableItem item : sloty) {
            if (item.getTyp() == typ)
                return true;
        }
        return false;
    }
}
