package org.zk29;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import base.HibernateUtil;
import base.People;

public class PeopleModel {
	public List<People> findPeople(){
		Session session = HibernateUtil.getSessionFactory().openSession();
	    Transaction transaction = null;
	    transaction = session.beginTransaction();
	   List<People> persons = session.createQuery("from People").list();
	    transaction.commit();
        session.close();
        return persons;
      }
}
