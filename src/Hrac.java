
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
    private ArrayList<IItem> inventar;

    public Hrac(String meno) {
        this.meno = meno;
        this.inventar = new ArrayList<>();
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
    
    public boolean maKlucKDveram(ZamykatelneDvere dvere) {
        for (IItem item : inventar) {
            if (item.getTyp() == ItemType.ITEM_KLUC) {
                Kluc kluc = (Kluc)item;
                if (kluc.getDvere() == dvere)
                    return true;
            }   
        }
        return false;
    }
}
