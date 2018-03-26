/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Itemy;

import Inventar.SlotyInventara;

/**
 *
 * @author kajanek6
 */
public class EquippableItem extends Item {
    private SlotyInventara slot;
    private int vydrz;
    
    public EquippableItem(String nazov, String popis, int cena, ItemType typ, SlotyInventara slot, int vydrz) {
        super(nazov, popis, cena, typ);
        this.slot = slot;
        this.vydrz = vydrz;
    }

    public SlotyInventara getSlot() {
        return slot;
    }

    public int getVydrz() {
        return vydrz;
    }
}
