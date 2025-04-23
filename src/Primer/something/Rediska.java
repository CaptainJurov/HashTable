package Primer.something;

import HashTable.Chain.ChainHashMap;


public class Rediska extends ChainHashMap<Url, Cache> {
    public Rediska () {
        super(16);
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
