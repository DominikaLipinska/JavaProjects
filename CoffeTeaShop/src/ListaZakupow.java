import java.util.ArrayList;
import java.util.List;

public class ListaZakupow{
    private String wlascicel;
    private List<Herbaty> lista;
    private Herbaty wCenniku;


    public ListaZakupow(String wlascicel) {
        this.lista = new ArrayList<>();
        this.wlascicel = wlascicel;
    }

    public boolean add(Herbaty produkt){
        if(czyWCenniku(produkt)){
            produkt.setCena(wCenniku);
        }
        lista.add(produkt);
        return true;
    }
    public void dodaj(String nazwa, String smak, double ilosc) {
        Herbaty produkt = null;
        switch (nazwa){
            case "czarna" -> produkt = new Czarna(smak,ilosc);
            case "czerwona" -> produkt = new Czerwona(smak,ilosc);
            case "niebieska" -> produkt = new Niebieska(smak,ilosc);
            case "zielona" -> produkt = new Zielona(smak,ilosc);
        }
        add(produkt);
    }
    public boolean remove(Herbaty produkt){
        return lista.remove(produkt);
    }

    public boolean search(Herbaty produkt){
        for (Herbaty h:lista) {
            if(produkt.compareTo(h)==0){
                return true;
            }
        }
        return false;
    }
    public boolean czyWCenniku(Herbaty produkt){
        boolean czy = false;
        Cennik cennik = Cennik.pobierzCennik();

        for (Herbaty h:cennik.getHerbaty()) {
            if(produkt.compareTo(h) == 0) {
                czy = true;
                wCenniku = h;
            }
        }
        return czy;
    }

    public List<Herbaty> getLista() {
        return lista;
    }

    @Override
    public String toString() {
        if(lista.size() !=0){
            String result = wlascicel + ":\n";
            for (Herbaty h: lista) {
                result += h.toString();
            }
            return result;
        }else
            return "--pusto";
    }
}
