package Primer.something;

public class Cache {
    private String data;

    Cache (String data) {
        this.data = data;
    }

    public String getData () {
        return data;
    }

    @Override
    public String toString () {
        return data;
    }
}
