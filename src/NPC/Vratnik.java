/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NPC;

import Hra.Hra;
import Hra.Prikaz;
import Hrac.Hrac;
import Inventar.Inventar;
import Itemy.IItem;
import Itemy.ItemType;
import java.util.ArrayList;

/**
 *
 * @author kajanek6
 */
public class Vratnik implements IPokecatelny{
    private Inventar inventar;
    private Hra hra;
    
    // konstantne pole nazvov prikazov
    private static final String[] PLATNE_PRIKAZY = {
        "vypisKluce","dajKluc","odid","pomoc"
    };

    public String[] getPlatnePrikazy() {
        return PLATNE_PRIKAZY;
    }

    public Vratnik(Hra hra) {
        this.inventar = new Inventar();
        this.hra = hra;
    }
    
    @Override
    public boolean spracujPrikaz(Prikaz prikaz) {
        String nazovPrikazu = prikaz.getNazov();
        switch(nazovPrikazu) {
            case "vypisKluce":
                this.inventar.vypisInventar(ItemType.ITEM_KLUC);
                break;
            case "dajKluc":
                ArrayList<String> list = prikaz.getParameters();
                if (list.size() < 1) {
                    System.out.println("Aky kluc?");
                    break;
                }

                String nazovKluca = list.get(0);
                IItem kluc = inventar.dajItem(nazovKluca);
                if (kluc == null) {
                    System.out.println("Kluc sa nenasiel.");
                    break;
                }
                
                if (kluc.getTyp() != ItemType.ITEM_KLUC) {
                    System.out.println("Kluc sa nenasiel.");
                    break;
                }
                Hrac hrac = hra.getHrac();
                hrac.getInventar().zoberItemDoInventara(kluc);
                this.inventar.odoberItemZInventara(kluc);
                break;
            case "odid":
                return true;
            case "pomoc":
                getPrikazy();
                break;
        }
        return false;
    }

    @Override
    public void getPrikazy() {
        System.out.println("Mozes pouzit tieto prikazy:");
        for (String string : PLATNE_PRIKAZY) {
            System.out.print(string + " ");
        }
    }

    @Override
    public String getNazov() {
        return "Vratnik";
    }

    public Inventar getInventar() {
        return inventar;
    }
}
