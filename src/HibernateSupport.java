
/*
 * HibernateSupport
 * For save or deletion operations of POJOs to MySQL DB
 * Author:       Muesluem Atas
 * Last Change:  11.03.2019
 */

import org.hibernate.*;
import org.hibernate.cfg.*;
import org.hibernate.service.*;

import java.io.File;

public class HibernateSupport {
	private static SessionFactory sessionFactory;

	static {
		System.out.println("HibernateSupport: Constructor");
		init();
	}

	private static void init() {
		//TODO: specify hibernate.cfg.xml path in the next line
		String path = "src/hibernate.cfg.xml";
		File configFile = new File(path);
		Configuration configuration = new Configuration();

		//TODO: add all classes you want to annotate
		configuration.addAnnotatedClass(Player.class);
		configuration.addAnnotatedClass(Team.class);
		configuration.addAnnotatedClass(Trainer.class);

		configuration.configure(configFile);

		ServiceRegistry serviceRegistry = new ServiceRegistryBuilder()
				.applySettings(configuration.getProperties()).buildServiceRegistry();
		try {
			sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (Exception e) {
            System.err.println("Initial SessionFactory creation failed." + e);
            throw new ExceptionInInitializerError(e);
        }
	}

	private static Session getCurrentSession() {
		return sessionFactory.getCurrentSession();
	}

	public static void beginTransaction() {getCurrentSession().beginTransaction(); }

	public static void commitTransaction() {getCurrentSession().getTransaction().commit();}

	public static boolean commit(Object obj) {
		try { getCurrentSession().saveOrUpdate(obj);}
		catch (HibernateException e) { return false; }
		return true;
	}

	public static void deleteObject(Object obj){getCurrentSession().delete(obj);}
}
