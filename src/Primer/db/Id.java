package Primer.db;

import HashMap.Hashable;

public class Id implements Hashable {
    public final int id;
    public Id (int id) {this.id = id;}
    @Override
    public int getHash () {
        return id;
    }

    @Override
    public boolean equals (Object obj) {
        return obj.equals(id);
    }
}
