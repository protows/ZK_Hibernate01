package org.zk29;

import base.People;
import base.HibernateUtil;
import java.util.LinkedList;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PeopleServiceImpl implements PeopleService{
	PeopleModel peopleModel = new PeopleModel();
	 List<People> peopleList = peopleModel.findPeople();
	
	public List<People> findAll(){
		return peopleList;
	}
	
	 public List<People> find(String keyword) {
		 List<People> result = new LinkedList<People>();
			if (keyword==null){
				result = peopleList;
			}else{
				for (People c: peopleList){
					if (c.getName().toLowerCase().contains(keyword.toLowerCase())){
						result.add(c);
					}
				}
			}
			return result;
	  }
}