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

    public boolean equals (Url obj) {
        return url.equals(obj.url);
    }
}
