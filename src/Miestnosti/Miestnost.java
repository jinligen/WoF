package Miestnosti;

/**
 * Trieda Miestnost realizuje jednu miestnost/priestor v celom priestore hry.
 * Kazda "miestnost" je z inymi miestnostami spojena vychodmi. 
 * Vychody z miestnosti su oznacovane svetovymi stranami sever, vychod, juh
 * a zapad. Pre kazdy vychod si miestnost pamata odkaz na susednu miestnost
 * alebo null, ak tym smerom vychod nema.
 *
 * @author  Michael Kolling, David J. Barnes
 * @version 2006.03.30
 * @author  lokalizacia: Lubomir Sadlon, Jan Janech
 * @version 2012.02.21
 */
import Itemy.IItem;
import Dvere.IDvere;
import Hra.Prikaz;
import NPC.IPokecatelny;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class Miestnost {
    private String popisMiestnosti;
    private String nazov;
    private HashMap<String, IDvere> miestnosti;
    private ArrayList<IItem> predmety;
    private boolean trebaNavleky;
    private HashMap<String, IPokecatelny> npc;

    /**
     * Vytvori miestnost popis ktorej je v parametrom.
     * Po vytvoreni miestnost nema ziadne vychody. Popis miesnost strucne 
     * charakterizuje.
     * 
     * @param popis text popisu miestnosti.
     */    
    public Miestnost(String nazov, String popis) {
        this.popisMiestnosti = popis;
        this.nazov = nazov;
        this.miestnosti = new HashMap<>();
        this.predmety = new ArrayList<>();
        this.trebaNavleky = false;
        this.npc = new HashMap<>();
    }
    
    public Miestnost(String nazov, String popis, boolean trebaNavleky) {
        this.popisMiestnosti = popis;
        this.nazov = nazov;
        this.miestnosti = new HashMap<>();
        this.predmety = new ArrayList<>();
        this.trebaNavleky = trebaNavleky;
        this.npc = new HashMap<>();
    }
    
    public void pridajItemDoMiestnosti(IItem item) {
        this.predmety.add(item);
    }
    
    public void pridajNpcDoMiestnosti(IPokecatelny npc) {
        this.npc.put(npc.getNazov(), npc);
    }
    
    public void vypisNpc() {
        for (IPokecatelny npc : npc.values()) {
            System.out.print(npc.getNazov() + " ");
        }
        System.out.println();
    }
    
    public IPokecatelny dajNpc(String meno) {
        return this.npc.get(meno);
    }

    /**
     * Nastavi vychody z miestnosti. Kazdy vychod je urceny bud odkazom 
     * na miestnost alebo hodnotou null, ak vychod tym smerom neexistuje.
     * 
     * @param sever miestnost smerom na sever.
     * @param vychod miestnost smerom na vychod.
     * @param juh miestnost smerom na juh.
     * @param zapad miestnost smerom na zapad.
     */
    public void nastavVychod(String nazovDveri, IDvere dvere) {
        this.miestnosti.put(nazovDveri, dvere);
    }

    /**
     * @return textovy popis miestnosti.
     */
    public String getPopis() {
        return this.popisMiestnosti;
    }

    public void vypisVychody() {
        System.out.println("Teraz si v miestnosti " + this.getPopis());
        System.out.print("Vychody: ");
        for (Map.Entry<String, IDvere> data : this.miestnosti.entrySet()) {
            System.out.print(data.getKey()+ " ");
        }
        System.out.println();
    }
    
    public IDvere getPrechod(String ciel) {
        return this.miestnosti.get(ciel);
    }
    
    public String getNazov() {
        return this.nazov;
    }
    
    public void vypisPredmety() {
        for (IItem item : predmety) {
            System.out.print(item.getNazov() + " ");
        }
        System.out.println();
    }
    
    public IItem zoberPredmet(Prikaz prikaz) {
        ArrayList<String> list = prikaz.getParameters();
        if (list.size() < 1) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Aky predmet?");
            return null;
        }

        String nazov = list.get(0);
        
        IItem hladany = null;
        for (IItem item : predmety) {
            if (item.getNazov().equals(nazov))
            {
                hladany = item;
                break;
            }
        }
        
        if (hladany == null)
        {
            System.out.println("Predmet sa nenasiel.");
            return null;
        }
        
        predmety.remove(hladany);
        return hladany;
    }

    public boolean isTrebaNavleky() {
        return trebaNavleky;
    }
    
    public Collection<IDvere> getVsetkyDvere() {
        return this.miestnosti.values();
    }
}
