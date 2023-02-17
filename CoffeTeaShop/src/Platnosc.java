public enum Platnosc {
    PRZELEW("przelew"), KARTA("karta");
    private final String name;

    Platnosc(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
