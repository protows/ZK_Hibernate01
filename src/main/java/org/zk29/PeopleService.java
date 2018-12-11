package org.zk29;

import java.util.List;
import base.People;

public interface PeopleService {
	public List<People> findAll();
	public List<People> find(String keyword);
}


