package Hra;


import Miestnosti.Miestnost;
import Dvere.Dvere;
import Hrac.Hrac;
import Itemy.Isic;
import Itemy.Kluc;
import Dvere.ZamykatelneDvere;
import Dvere.IDvere;
import Dvere.VytahoveDvere;
import Itemy.ItemType;
import Itemy.Navleky;
import Miestnosti.Vytah;
import NPC.Vratnik;
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
public class Mapa {
    private Miestnost aktualnaMiestnost;
    private Hra hra;

    public Mapa(Hra hra) {
        this.hra = hra;
        this.vytvorMiestnosti();
    }

    /**
     * Vytvori mapu hry - miestnosti.
     */
    private void vytvorMiestnosti() {
        // vytvorenie miestnosti
        Miestnost terasa = new Miestnost("terasa", "terasa - hlavny vstup na fakultu");
        Miestnost aula = new Miestnost("aula", "aula");
        Miestnost bufet = new Miestnost("bufet", "bufet");
        Miestnost labak = new Miestnost("pocitacoveLaboratorium","pocitacove laboratorium");
        Miestnost kancelaria = new Miestnost("kancelaria","kancelaria spravcu pocitacoveho laboratoria");
        // infocentrum
        // vratnica
        Miestnost fra12 = new Miestnost("FRA12", "Najs ucebna", true);
        Miestnost chodba = new Miestnost("chodba","Pozor smyka sa");
        Miestnost infocentrum = new Miestnost("infocentrum", "Questnovna");
        Miestnost vratnica = new Miestnost("vratnica","Straty a nalezy");
        Vytah vytah = new Vytah("Vytah","Vytah v chodbe", -1, 3);
        Miestnost dolnaChodba = new Miestnost("dolnachodba","Chodba na dolnom poschodi");
        Miestnost dekanat = new Miestnost("dekanat","Dekanat na prvom poschodi");
        Miestnost atg = new Miestnost("atg","Ucebna ATG");
        Miestnost fra323 = new Miestnost("fra323","Nahodna ucebna");
        // vytah
        // zbrojnica
        // heliport
        // ponorkova zakladna
        
        Dvere chodbaFra12 = new Dvere(chodba, fra12, PodmienkyVstupu.PODMIENKA_ISIC);
        chodba.nastavVychod(fra12.getNazov(), chodbaFra12);
        fra12.nastavVychod(chodba.getNazov(), chodbaFra12);
        
        VytahoveDvere chodbaVytah = new VytahoveDvere(chodba, vytah, PodmienkyVstupu.PODMIENKA_ZIADNA, vytah, 0);
        chodba.nastavVychod(vytah.getNazov(), chodbaVytah);
        vytah.nastavVychod(chodba.getNazov(), chodbaVytah);
        
        VytahoveDvere dolnaChodbaVytah = new VytahoveDvere(dolnaChodba, vytah, PodmienkyVstupu.PODMIENKA_ZIADNA, vytah, -1);
        dolnaChodba.nastavVychod(vytah.getNazov(), dolnaChodbaVytah);
        vytah.nastavVychod(dolnaChodba.getNazov(), dolnaChodbaVytah);
        
        VytahoveDvere dekanatVytah = new VytahoveDvere(dekanat, vytah, PodmienkyVstupu.PODMIENKA_ZIADNA, vytah, 1);
        dekanat.nastavVychod(vytah.getNazov(), dekanatVytah);
        vytah.nastavVychod(dekanat.getNazov(), dekanatVytah);
        
        VytahoveDvere atgVytah = new VytahoveDvere(atg, vytah, PodmienkyVstupu.PODMIENKA_ZIADNA, vytah, 2);
        atg.nastavVychod(vytah.getNazov(), atgVytah);
        vytah.nastavVychod(atg.getNazov(), atgVytah);
        
        VytahoveDvere fra323Vytah = new VytahoveDvere(fra323, vytah, PodmienkyVstupu.PODMIENKA_ZIADNA, vytah, 3);
        fra323.nastavVychod(vytah.getNazov(), fra323Vytah);
        vytah.nastavVychod(fra323.getNazov(), fra323Vytah);
        
        Dvere chodbaTerasa = new Dvere(chodba, terasa, PodmienkyVstupu.PODMIENKA_ZIADNA);
        chodba.nastavVychod(terasa.getNazov(), chodbaTerasa);
        terasa.nastavVychod(chodba.getNazov(), chodbaTerasa);
        
        Dvere chodbaLabak = new Dvere(chodba, labak, PodmienkyVstupu.PODMIENKA_ZIADNA);
        chodba.nastavVychod(labak.getNazov(), chodbaLabak);
        labak.nastavVychod(chodba.getNazov(), chodbaLabak);
        
        Dvere chodbaVratnica = new Dvere(chodba, vratnica, PodmienkyVstupu.PODMIENKA_ZIADNA);
        chodba.nastavVychod(vratnica.getNazov(), chodbaVratnica);
        vratnica.nastavVychod(chodba.getNazov(), chodbaVratnica);
        
        Dvere infocentrumVratnica = new Dvere(infocentrum, vratnica, PodmienkyVstupu.PODMIENKA_ZIADNA);
        vratnica.nastavVychod(infocentrum.getNazov(), infocentrumVratnica);
        infocentrum.nastavVychod(vratnica.getNazov(), infocentrumVratnica);
        
        Dvere bufetChodba = new Dvere(bufet, chodba, PodmienkyVstupu.PODMIENKA_ISIC);
        bufet.nastavVychod(chodba.getNazov(), bufetChodba);
        chodba.nastavVychod(bufet.getNazov(), bufetChodba);
        
        // inicializacia miestnosti = nastavenie vychodov
        Dvere terasaAula = new Dvere(terasa, aula, PodmienkyVstupu.PODMIENKA_ZIADNA);
        terasa.nastavVychod(aula.getNazov(), terasaAula);
        aula.nastavVychod(terasa.getNazov(), terasaAula);
        Dvere terasaLabak = new Dvere(terasa, labak, PodmienkyVstupu.PODMIENKA_ZIADNA);
        terasa.nastavVychod(labak.getNazov(), terasaLabak);
        labak.nastavVychod(terasa.getNazov(), terasaLabak);
        Dvere terasaBufet = new Dvere(terasa, bufet, PodmienkyVstupu.PODMIENKA_ZIADNA);
        terasa.nastavVychod(bufet.getNazov(), terasaBufet);
        bufet.nastavVychod(terasa.getNazov(), terasaBufet);
        ZamykatelneDvere labakKancelaria = new ZamykatelneDvere(labak, kancelaria);
        labak.nastavVychod(kancelaria.getNazov(), labakKancelaria);
        kancelaria.nastavVychod(labak.getNazov(), labakKancelaria);
        
        
        
        // pridavanie predmetov
        Vratnik vratnik = new Vratnik(this.hra);
        vratnik.getInventar().zoberItemDoInventara(new Kluc("StriebornyKluc","",-1, labakKancelaria));
        vratnica.pridajNpcDoMiestnosti(vratnik);
        infocentrum.pridajItemDoMiestnosti(new Isic());
        bufet.pridajItemDoMiestnosti(new Navleky("Navleky", "Made in China",20));

        this.aktualnaMiestnost = terasa;  // startovacia miestnost hry
    }
    
        /** 
     * Vykona pokus o prechod do miestnosti urcenej danym smerom.
     * Ak je tym smerom vychod, hrac prejde do novej miestnosti.
     * Inak sa vypise chybova sprava do terminaloveho okna.
     */
    public void chodDoMiestnosti(Prikaz prikaz) {
        ArrayList<String> list = prikaz.getParameters();
        if (list.size() < 1) {
            // ak prikaz nema parameter - druhe slovo - nevedno kam ist
            System.out.println("Chod kam?");
            return;
        }

        String smer = list.get(0);

        // Pokus o opustenie aktualnej miestnosti danym vychodom.
        IDvere dvere = this.aktualnaMiestnost.getPrechod(smer);
        
        if (dvere == null) {
            System.out.println("Tam nie je vychod!");
            return;
        }
        
        Miestnost novaMiestnost = dvere.skusPrechod(this.aktualnaMiestnost, this.hra.getHrac());

        if (novaMiestnost == null) {
            System.out.println("Nemate opravnenie na vstup!");
        } else {
            if (novaMiestnost.isTrebaNavleky()) {
               if (!hra.getHrac().getInventar().maEquipnute(ItemType.ITEM_NAVLEKY)) {
                   System.out.println("Su potrebne navleky."); 
                   return;
               }
            }
            this.aktualnaMiestnost = novaMiestnost;
            this.aktualnaMiestnost.vypisVychody();
        }
    }

    public Miestnost getAktualnaMiestnost() {
        return aktualnaMiestnost;
    }
    
    public IDvere getDvere(String nazov) {
        return this.aktualnaMiestnost.getPrechod(nazov);
    }
}
