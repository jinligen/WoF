/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Hrac;

/**
 *
 * @author kajanek6
 */
public enum SlotyInventara {
    HLAVA(0), 
    TELO(1),
    NOHY(2),
    MAX_SLOTOV(3);
    private final int id;
    SlotyInventara(int id) {
        this.id = id;
    }
    
    public int getValue() {
        return this.id;
    }
}
