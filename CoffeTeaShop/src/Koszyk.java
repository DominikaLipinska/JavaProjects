import java.util.ArrayList;
import java.util.List;

public class Koszyk {
    private String wlasciciel;
    private List<Herbaty> koszyk;
    private int wartoscKoszyka;

    public Koszyk( Klient wlasciciel) {
        this.wlasciciel = wlasciciel.getWlasciciel();
        this.koszyk = new ArrayList<>();
        this.wartoscKoszyka = 0;
    }

    public int getWartoscKoszyka() {
        return wartoscKoszyka;
    }
    public List<Herbaty> getKoszyk() {
        return koszyk;
    }

    public void setKoszyk(Herbaty produkt) {
        koszyk.add(produkt);
        wartoscKoszyka += produkt.getCena()*produkt.getIlosc();
    }
    public void setIlosc(Herbaty produkt, double ilosc){
        produkt.addIlosc(ilosc);
        wartoscKoszyka += ilosc*produkt.getCena();
    }

    public boolean remove(Herbaty produkt){
        return koszyk.remove(produkt);
    }

   /*     public Herbaty max(){
        Herbaty max = koszyk.get(0);
        int i = 0;
        for (Herbaty h: koszyk) {
            if(i == 0)
                max = h;
            else if(h.compareToValue(max) > 0){
                max = h;
            }
            i++;
        }
        return max;
    }*/
    public Herbaty min(){
        Herbaty min = koszyk.get(0);
        for (Herbaty h: koszyk) {
            if(h.compareToValue(min) < 0){
                min = h;
            }
        }
        return min;
    }

    @Override
    public String toString() {
        if(koszyk.size() !=0){
            String result = wlasciciel + ":\n";
            for (Herbaty h: koszyk) {
                result += h.toString();
            }
            return result;
        }else
            return "--pusto";
    }
}
