public class HerbalTest {
    static double wartosc(Koszyk k, String smak) {
        double wartosc = 0;
        for(Herbaty h: k.getKoszyk()){
            if(h.getSmak() == smak){
                wartosc += h.getCena()* h.getIlosc();
            }
        }
        return wartosc;
    }
    public static void main(String[] args) {

        Cennik cennik = Cennik.pobierzCennik();
        cennik.dodaj("zielona", "imbir", 4, 70, 80);
        cennik.dodaj("czarna", "kiwi", 120);
        cennik.dodaj("czerwona", "truskawka", 80);
        cennik.dodaj("zielona", "jaśmin", 150);

        Klient herbal = new Klient("herbal", 2000);
        herbal.dodaj(new Zielona("imbir", 5));
        herbal.dodaj(new Czerwona("truskawka", 5));
        herbal.dodaj(new Niebieska("wanilia", 3));
        herbal.dodaj(new Czarna("kiwi", 3));

        ListaZakupow listaHerbala = herbal.pobierzListeZakupow();

        System.out.println("Lista zakupów klienta " + listaHerbala);
        Koszyk koszykHerbala = new Koszyk(herbal);
        herbal.przepakuj(koszykHerbala);

        System.out.println("Po przepakowaniu, lista zakupów klienta " + herbal.pobierzListeZakupow());
        System.out.println("Po przepakowaniu, koszyk klienta " + koszykHerbala);

        System.out.println("Herbata truskawkowa w koszyku Herbala kosztowała:  "
                + wartosc(koszykHerbala, "truskawka"));

        herbal.zaplac("przelew");


        System.out.println("Po zapłaceniu, Herbalowi zostało : " + herbal.pobierzPortfel() + " zł");

        System.out.println("Po zapłaceniu, koszyk klienta " + herbal.pobierzKoszyk());
        System.out.println("Po zapłaceniu, koszyk klienta " + koszykHerbala);

        Klient kawus = new Klient("kawus", 620);

        kawus.dodaj(new Zielona("imbir", 3));
        kawus.dodaj(new Czarna("kiwi", 4));

        System.out.println("Lista zakupów klienta " + kawus.pobierzListeZakupow());

        Koszyk koszykKawusia = new Koszyk(kawus);

        kawus.przepakuj(koszykKawusia);

        System.out.println("Po przepakowaniu, lista zakupów klienta " + kawus.pobierzListeZakupow());
        System.out.println("Po przepakowaniu, koszyk klienta " + kawus.pobierzKoszyk());

        kawus.zaplac("karta");

        System.out.println("Po zapłaceniu, Kawusiowi zostało : " + kawus.pobierzPortfel() + " zł");
        System.out.println("Po zapłaceniu, koszyk klienta " + koszykKawusia);

    }
}
