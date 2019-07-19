package com.boraji.tutorial.hibernate;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.hibernate.Session;

import com.boraji.tutorial.hibernate.entity.Country;
import com.boraji.tutorial.hibernate.entity.Customer;
import com.boraji.tutorial.hibernate.entity.State;

/**
 * @author imssbora
 */
public class MainApp {
  public static void main(String[] args) {
	//https://www.boraji.com/hibernate-5-basic-configuration-example
	  
    Session session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();

    // Check database version
    String sql = "select version()";

    String result = (String) session.createNativeQuery(sql).getSingleResult();
    System.out.println(result);
    
    //https://www.boraji.com/hibernate-5-remove-an-entity-example
    /*
    Customer customer2 = new Customer();
    customer2.setId(3L);
    customer2.setName("Name3");
    session.save(customer2);
    */
    
    
    //https://www.boraji.com/hibernate-5-get-load-and-byid-example
    
    // Obtain an entity using load() method
    Customer customer2 = session.load(Customer.class, 2L);
    System.out.println(customer2.getName());
    

    session.getTransaction().commit();
    session.close();
    
    session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    
    State s = new State();
    s.setId(10);
    s.setName("State10");
    
    
    Country c2 = new Country();
    c2.setId(1);
    c2.setName("Ukraine");
    
    Map<Integer,State> states2 = new HashMap<Integer,State>();
    states2.put(10, s);
    c2.setStates(states2);
    
    session.save(c2);
    
    session.getTransaction().commit();
    session.close();
    
    
    session = HibernateUtil.getSessionFactory().openSession();
    session.beginTransaction();
    
    //https://www.concretepage.com/hibernate/example-mapkey-hibernate
    
    Country c =(Country)session.get(Country.class, new Integer(1));
	Map<Integer,State> states = c.getStates();
	Iterator entries = states.entrySet().iterator();
	while (entries.hasNext()) {
	    Map.Entry entry = (Map.Entry) entries.next();
	    Integer key = (Integer)entry.getKey();
	    State value = (State)entry.getValue();
	    System.out.println("Key = " + key + ", Value = " + value.getName());
	}
    
    session.getTransaction().commit();
    session.close();
    
    

    
    HibernateUtil.shutdown();
  }
}
