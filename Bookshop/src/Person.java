import java.io.Serializable;

abstract class Person implements Serializable {
    private String firstName;
    private String latsName;
    private  String phoneNumber;
    private String email;
    private Adres adres;

    public Person(String firstName, String latsName) {
        this.firstName = firstName;
        this.latsName = latsName;
    }

    public Person(String firstName, String latsName, String phoneNumber, String email, Adres adres) {
        this(firstName,latsName);
        this.phoneNumber = phoneNumber;
        this.email = email;
        this.adres = adres;
    }

    @Override
    public String toString() {
        return firstName + " " + latsName;
    }
}
