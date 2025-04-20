package Primer.something;

import HashMap.Hashable;

public class Url implements Hashable {
    String url;

    Url (String url) {
        this.url = url;
    }

    @Override
    public int getHash () {
        int hash = 0;
        for (int i = 0; i < url.length(); i++) {
            hash += url.charAt(i);
        }
        return hash;
    }

    @Override
    public String toString () {
        return url;
    }

    @Override
    public boolean equals (Object obj) {
        return url.equals(obj.toString());
    }
}
