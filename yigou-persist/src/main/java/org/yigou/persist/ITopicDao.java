package org.yigou.persist;

import java.util.ArrayList;
import java.util.List;

import org.yigou.model.Topic;
import org.yigou.model.TopicAttach;

public interface ITopicDao {

	boolean add(Topic topic,ArrayList<TopicAttach> attachs) throws Exception;
  
	List query(int page, int size);
}
