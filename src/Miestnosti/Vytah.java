/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Miestnosti;

import Dvere.IDvere;
import Dvere.VytahoveDvere;
import Hra.IPrikazy;
import Hra.Prikaz;
import java.util.ArrayList;
import java.util.Map;

/**
 *
 * @author kajanek6
 */
public class Vytah extends Miestnost implements IPrikazy {
    private int poschodie;
    private int najnizsiePoschodie;
    private int najvyssiePoschodie;
    
    public Vytah(String nazov, String popis, int najnizsiePoschodie, int najvyssiePoschodie) {
        super(nazov, popis);
        this.poschodie = 0;
        this.najnizsiePoschodie = najnizsiePoschodie;
        this.najvyssiePoschodie = najvyssiePoschodie;
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
                ArrayList<String> list = prikaz.getParameters();
                if (list.size() != 1) {
                    System.out.println("Ake poschodie?");
                    break;
                }
                int vyslednePoschodie = Integer.parseInt(list.get(0));
                if (vyslednePoschodie < this.najnizsiePoschodie ||
                        vyslednePoschodie > this.najvyssiePoschodie) {
                    System.out.println("Take poschodie neexistuje.");
                    break;
                }                    
                zavolajVytah(vyslednePoschodie);
                break;
            case "vypisPoschodia":
                for(int i = this.najnizsiePoschodie; i <= this.najvyssiePoschodie; ++i)
                    System.out.print(i + " ");
                System.out.println("");
                break;
        }
        return false;
    }

    public int getPoschodie() {
        return poschodie;
    }

    public void zavolajVytah(int poschodie) {
        this.poschodie = poschodie;
    }
    
    @Override
    public void vypisVychody() {
        System.out.println("Teraz si v miestnosti " + this.getPopis());
        System.out.print("Vychody: ");
        for (Map.Entry<String, IDvere> data : this.getMiestnosti().entrySet()) {
            IDvere dvere = data.getValue();
            if (dvere instanceof VytahoveDvere) {
                VytahoveDvere vytahDvere = (VytahoveDvere)dvere;
                if (vytahDvere.getPoschodie() == this.poschodie)
                    System.out.print(data.getKey()+ " ");
            } else {
                System.out.print(data.getKey()+ " ");
            }
        }
        System.out.println();
    }
    
    @Override
    public IDvere getPrechod(String ciel) {
        IDvere prechod = this.getMiestnosti().get(ciel);
        if (prechod instanceof VytahoveDvere) {
            VytahoveDvere vytahDvere = (VytahoveDvere) prechod;
            if (vytahDvere.getPoschodie() == this.poschodie) {
                return prechod;
            } else {
                System.out.println("Nie si na spravnom poschodi.");
                return null;
            }
        }
        System.out.println("Toto nikdy nema nastat. - Vytah error chod niekam.");
        return null;
    }
}
