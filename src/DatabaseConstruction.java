
import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;


public class DatabaseConstruction {

    public static void main(String[] args) {
        System.out.printf("Start");

        Configuration conf=new Configuration();
        conf.addAnnotatedClass(Player.class);
        conf.addAnnotatedClass(Team.class);
        conf.addAnnotatedClass(Trainer.class);

        conf.configure("hibernate.cfg.xml");

        new SchemaExport(conf).create(true, true);

    }
}