package org.yigou.service;

import java.util.List;

import org.yigou.model.Topic;

public interface ITopicService {
	boolean addTopic(Topic topic,String[] attachs);
	List query(int page,int size);
}
