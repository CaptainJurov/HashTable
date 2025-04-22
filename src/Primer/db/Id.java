package Primer.db;

public class Id {
    public final int id;
    public Id (int id) {this.id = id;}
    @Override
    public int hashCode () {
        return id;
    }

    @Override
    public boolean equals (Object obj) {
        return obj.equals(id);
    }
}
