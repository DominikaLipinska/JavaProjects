public class Klient {
    private String wlasciciel;
    private int portfel;
    private ListaZakupow lista;
    private Koszyk koszyk;

    public Klient(String wlasciciel, int portfel) {
        this.wlasciciel = wlasciciel;
        this.portfel = portfel;
        this.lista = new ListaZakupow(wlasciciel);
    }

    public ListaZakupow pobierzListeZakupow() {
        return lista;
    }
    public int pobierzPortfel() {
        return portfel;
    }
    public Koszyk pobierzKoszyk() {
        return koszyk;
    }
    public String getWlasciciel() {
        return wlasciciel;
    }

    public void dodaj(Herbaty produkt){
        lista.add(produkt);
    }
    public void removeKoszyk(){
        Herbaty[] toRemove = new Herbaty[koszyk.getKoszyk().size()];
        int index = 0;
        for (Herbaty h : koszyk.getKoszyk()) {
            toRemove[index++] = h;
        }

        for (Herbaty h:toRemove) {
            koszyk.remove(h);
        }
    }

    public void przepakuj(Koszyk koszykHerbala) {
        Herbaty[] toRemove = new Herbaty[lista.getLista().size()];
        int index = 0;
        for (Herbaty h : lista.getLista()) {
            if(h.getCena()>0){
                toRemove[index] = h;
                koszykHerbala.setKoszyk(h);
            }
            index++;
        }
        for (Herbaty h:toRemove) {
            lista.remove(h);
        }
        koszyk=koszykHerbala;
    }
    public void zaplac(String platnosc) {
        Herbaty min = koszyk.min();
        double prowizja = 0;
        if (platnosc == Platnosc.PRZELEW.getName())
            prowizja = 5;
        else if (platnosc == Platnosc.KARTA.getName())
            prowizja = 0.01 * koszyk.getWartoscKoszyka();

        if (prowizja != 0) {
            if (portfel - koszyk.getWartoscKoszyka() - prowizja > 0) {
                portfel -= koszyk.getWartoscKoszyka() + prowizja;
                removeKoszyk();
                if (lista.search(min)) {
                    przepakuj(koszyk);
                }
            } else {
                double val = 0.5;
                koszyk.setIlosc(min, -val);
                if (!lista.search(min)) {
                    lista.dodaj(min.getRodzaj(), min.getSmak(), val);
                } else {
                    for (Herbaty h : lista.getLista()) {
                        if (min.compareTo(h) == 0)
                            h.addIlosc(val);
                    }
                }
                zaplac(platnosc);
            }
        }
    }
}