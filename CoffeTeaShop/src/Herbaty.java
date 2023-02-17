abstract class Herbaty implements Comparable{
    private String rodzaj;
    private String smak;
    private double ilosc;
    private int cena = -1;
    private int limit;
    private int cenapowyzej;
    private int cenaponizej;

    public Herbaty(String rodzaj, String smak, int limit, int cenapowyzej, int cenaponizej) {
        this.rodzaj = rodzaj;
        this.smak = smak;
        this.limit = limit;
        if(cenaponizej == cenapowyzej) this.cena = cenaponizej;
        this.cenapowyzej = cenapowyzej;
        this.cenaponizej = cenaponizej;
    }

    public Herbaty(String rodzaj, String smak, double ilosc) {
        this.rodzaj = rodzaj;
        this.smak = smak;
        this.ilosc = ilosc;
    }

    public String getRodzaj() {
        return rodzaj;
    }
    public String getSmak() {
        return smak;
    }
    public double getIlosc() {
        return ilosc;
    }
    public int getCena() {
        return cena;
    }
    public int getCenapowyzej() {
        return cenapowyzej;
    }
    public int getCenaponizej() {
        return cenaponizej;
    }

    public void setCena(Herbaty herbaty){
        if(ilosc <= herbaty.limit){
            this.cena = herbaty.getCenaponizej();
        }else this.cena = herbaty.getCenapowyzej();

        this.cenaponizej = herbaty.getCenaponizej();
        this.cenapowyzej = herbaty.getCenapowyzej();
    }
    public void setIlosc(double ilosc) {
        this.ilosc = ilosc;
    }
    public void addIlosc(double ilosc) {
        this.ilosc += ilosc;
    }


    @Override
    public String toString() {
        return rodzaj + ", smak: " + smak + ", ilość "
                + ilosc + " kg, cena " + cena + "\n" ;
    }

    @Override
    public int compareTo(Object o) {
        Herbaty h = (Herbaty)o;
        if(this.rodzaj.compareTo(h.rodzaj) == 0){
            return this.smak.compareTo(h.smak);
        }else return -1;
    }

    public double compareToValue(Object o) {
        Herbaty h = (Herbaty)o;
        double valueT = this.cena * this.ilosc;
        double valueH = h.cena * h.ilosc;
        return valueT-valueH;
    }
}
