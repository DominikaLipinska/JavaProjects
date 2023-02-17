import java.util.ArrayList;
import java.util.List;

public class Cennik  {
    private static Cennik instance = null;
    private List<Herbaty> herbaty;

    private Cennik(){herbaty = new ArrayList<>();}

    public static Cennik pobierzCennik(){
        if(instance == null){
            instance = new Cennik();
        }
        return instance;
    }


    public void dodaj(String nazwa, String smak, int cena) {
        dodaj(nazwa,smak,0,cena,cena);
    }

    public void dodaj(String nazwa, String smak, int limit,
                      int cenapowyzej, int cenaponizej) {
        switch (nazwa){
            case "czarna" -> herbaty.add(new Czarna(smak,limit,cenapowyzej,cenaponizej));
            case "czerwona" -> herbaty.add(new Czerwona(smak,limit,cenapowyzej,cenaponizej));
            case "niebieska" -> herbaty.add(new Niebieska(smak,limit,cenapowyzej,cenaponizej));
            case "zielona" -> herbaty.add(new Zielona(smak,limit,cenapowyzej,cenaponizej));
        }
    }

    public List<Herbaty> getHerbaty() {
        return herbaty;
    }

    @Override
    public String toString() {
        return herbaty.toString();
    }
}
