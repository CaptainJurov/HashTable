package Primer.db;

import HashMap.*;


public class Database extends HashMap<Id, User>{
    public Database () {
        super(16);
    }
    public void insert(int id, String name, int phone) {
        Id num = new Id(id);
        User user = new User(name, phone);
        super.insert(num, user);
    }
    public User getUser(int id) {
        return super.get(new Id(id));
    }
    public void removeUser(int id) {
        super.remove(new Id(id));
    }
    public void showInfo() {
        for (LinkedList<Id, User> i : table) {

        }
    }
}
