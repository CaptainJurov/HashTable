package Primer.something;

import HashTable.HashFunctions.DivRem;
import HashTable.OpenAdress.ClosedHashMap;


public class Rediska extends ClosedHashMap<Url, Cache> {
    public Rediska () {
        super(16, new DivRem<Url>());
    }
    public void insert(String address, String cache) {
        Url url = new Url(address);
        Cache cache1 = new Cache(cache);
        super.insert(url, cache1);
    }
    public Cache getCache(String url) {
        return super.get(new Url(url));
    }
    public void removeCache(String url) {
        super.remove(new Url(url));
    }
}
