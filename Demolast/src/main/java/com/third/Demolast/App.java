package com.third.Demolast;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

/**
 * Hello world!
 *
 */
public class App 
{
	 
    public static void main( String[] args )
    {
    /*	StudentName sn=new StudentName();
    	sn.setFname("Mohammed");
    	sn.setMname("Noumaan");
    	sn.setLname("Faisal");
    	
        Student s=new Student();
        s.setId(1);
        s.setAddress("Bang");
        s.setName(sn);*/
    	
    	
    	Laptop laptop=new Laptop();
    	laptop.setLid(11);
    	laptop.setLname("Dell");
    	
    	Student1 s1= new Student1();
    	s1.setId(1);
    	s1.setName("Sam");
    	s1.setMarks(135);
    	s1.getLaptop().add(laptop);
    	
    	
        
       Configuration con = new Configuration().configure().addAnnotatedClass(Student1.class).addAnnotatedClass(Laptop.class);
        SessionFactory sf=con.buildSessionFactory();
       // SessionFactory sf=createSessionFactory();
        		
        Session session = sf.openSession();
        
        Transaction tx =session.beginTransaction();
        
        session.save(laptop);
        session.save(s1); 
     //  s= (Student) session.get(Student.class, 1);
        
        tx.commit(); 
        
        System.out.println(s1);
        
        
        
    }
    private static SessionFactory sessionFactory;
    private static ServiceRegistry serviceRegistry;
    
    public static SessionFactory createSessionFactory() {
        Configuration configuration = new Configuration();
        configuration.configure().addAnnotatedClass(Student1.class);
        ServiceRegistry serviceRegistry = new ServiceRegistryBuilder().applySettings(
                configuration.getProperties()). buildServiceRegistry();
        sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        return sessionFactory;
    }
    
    
    
   private static DataSource dataSource() {
		DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
		driverManagerDataSource.setUrl(environment.getProperty(URL));
		driverManagerDataSource.setUsername(environment.getProperty(USER));
		driverManagerDataSource.setPassword(environment.getProperty(PASSWORD));
		driverManagerDataSource.setDriverClassName(environment.getProperty(DRIVER));
		return driverManagerDataSource;
	}
    
}
