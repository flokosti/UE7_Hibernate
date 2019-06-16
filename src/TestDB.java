public class TestDB {

    public static void main(String[] args) {
        Team t1 = new Team("FC Barcelona");
        Team t2 = new Team ("Manchester City");
        Team t3 = new Team("Real Madrid");
        Team t4 = new Team ( "FC Liverpool");

        Trainer tr1 = new Trainer("Ernesto Valverde", t1);
        Trainer tr2 = new Trainer("Pep Guardiola", t2);
        Trainer tr3 = new Trainer("Zinedine Zidane", t3);
        Trainer tr4 = new Trainer("Jürgen Klopp", t4);

        Player p1 = new Player("Toni Kroos", 29, t3);
        Player p2 = new Player("Gareth Bale", 29, t3);
        Player p3 = new Player("Mohamed Salah", 26, t4);
        Player p4 = new Player("Sadio Mane", 27, t4);
        Player p5 = new Player("Lionel Messi", 31, t1);
        Player p6 = new Player("Sergio Agüero", 30, t2);

        HibernateSupport.beginTransaction();
        t1.saveToDB();
        t2.saveToDB();
        t3.saveToDB();
        t4.saveToDB();
        HibernateSupport.commitTransaction();

        HibernateSupport.beginTransaction();
        tr1.saveToDB();
        tr2.saveToDB();
        tr3.saveToDB();
        tr4.saveToDB();
        HibernateSupport.commitTransaction();

        HibernateSupport.beginTransaction();
        p1.saveToDB();
        p2.saveToDB();
        p3.saveToDB();
        p4.saveToDB();
        p5.saveToDB();
        p6.saveToDB();
        HibernateSupport.commitTransaction();

        t1.setTrainer(tr1);
        t2.setTrainer(tr2);
        t3.setTrainer(tr3);
        t4.setTrainer(tr4);

        HibernateSupport.beginTransaction();
        t1.saveToDB();
        t2.saveToDB();
        t3.saveToDB();
        t4.saveToDB();
        HibernateSupport.commitTransaction();

        t1.addPlayer(p5);
        t2.addPlayer(p6);
        t3.addPlayer(p1);
        t3.addPlayer(p2);
        t4.addPlayer(p3);
        t4.addPlayer(p4);

        HibernateSupport.beginTransaction();
        t1.saveToDB();
        t2.saveToDB();
        t3.saveToDB();
        t4.saveToDB();
        HibernateSupport.commitTransaction();
    }
}
