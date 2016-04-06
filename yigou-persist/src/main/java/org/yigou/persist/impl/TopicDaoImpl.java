package org.yigou.persist.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.yigou.model.Topic;
import org.yigou.model.TopicAttach;
import org.yigou.persist.ITopicDao;
@Repository
public class TopicDaoImpl implements ITopicDao {

	@Autowired
	SessionFactory sessionFactory;
	public boolean add(Topic topic,ArrayList<TopicAttach> attachs) throws Exception{
		Session session = sessionFactory.getCurrentSession();
		Transaction tran = session.beginTransaction();
		int id = (Integer) session.save(topic);
		if(attachs!=null){
			for(TopicAttach ta:attachs){
				ta.setTopicId(id);
				session.save(ta);
			}
		}
		tran.commit();
		return true;
	}
	public List query(int page, int size) {
		Session session = sessionFactory.getCurrentSession();
		//Query query = session.createSQLQuery("select *from t_topic order by _id desc limit ?,?");
		//query.setInteger(0, page);
		//query.setInteger(1, size);
		Query query = session.createQuery("from Topic order by _id desc");
		query.setFirstResult(page);
		query.setMaxResults(size);
		return query.list();
		
		
	}

}
