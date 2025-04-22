package Primer.db;

public class User {
    private final String name;
    private final int phone;
    public User (String name, int phone) {
        this.name = name;
        this.phone = phone;
    }

    public String name() {return this.name;}
    public int phone() {return this.phone;}

    @Override
    public String toString () {
        return name;
    }
}
