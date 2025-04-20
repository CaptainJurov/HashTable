import Primer.db.Database;
import Primer.something.Rediska;

public class Main {
    public static int getRandNum() {return (int) ((Math.random()*1000)%1000);}
    public static void main (String[] args) {
        System.out.println("\033[1;32mПримерчик с бд");
        Database db = new Database();
        db.insert(1, "Miku Hatsune", 3192007);
        db.insert(401, "Teto Kasane", 4012008);
        db.insert(2, "Kagamine Rin", 27122007);
        db.insert(3, "Kagamine Len", 27122007);
        db.insert(4, "Megurine Luka", 30012009);
        db.insert(5, "MEIKO", 5112004);
        db.insert(7, "GUMI", 26062009);

        db.removeUser(401);
        System.out.println(db);
        System.out.println("\n\033[1;31mПримерчик с импортозамещением Redis");

        Rediska redis = new Rediska();
        redis.insert("google.com", "чёта");
        redis.insert("pornhub.com", "очень много чёта)");
        redis.insert("doikidoiki.ru", "очень очень много чёта)");
        redis.insert("bongacams.com", "чут чут чёта)");
        redis.insert("sibsutis.ru", "огромный забитый на учёбу болт");
        redis.removeCache("razvod_na_dengi.com");
        redis.removeCache("google.com");
        System.out.println(redis);

        System.out.println("\n\033[1;33mПримерчик с флудом");
        Database db1 = new Database();
        for (int i=0;i<100;i++) {
            db1.insert(getRandNum(), "Z", 1);
        }
        for (int i=0;i<10;i++) {
            db1.removeUser(i);
        }
        System.out.println(db1);
        db1.getUser(getRandNum());

    }

}