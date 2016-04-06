package org.yigou.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.yigou.model.Topic;
import org.yigou.model.TopicAttach;
import org.yigou.model.TopicStatus;
import org.yigou.persist.ITopicDao;
import org.yigou.service.ITopicService;
@Service
@Transactional
public class TopicServiceImpl implements ITopicService {

	@Autowired
	ITopicDao topicDao;
	public boolean addTopic(Topic topic, String[] attachs) {
		boolean isAttach = attachs!=null && attachs.length>0;
		initTopic(topic,isAttach);
		ArrayList<TopicAttach> ats = initAttachs(attachs);
		if(ats!=null && ats.size()>0){
			topic.setPic(ats.get(0).getSmallAddress());
		}
		try {
			topicDao.add(topic, ats);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		return true;
	}
	private ArrayList<TopicAttach> initAttachs(String[] attachs) {
		if(attachs==null)
			return null;
		if(attachs.length<1)
			return null;
		ArrayList<TopicAttach> result = new ArrayList<TopicAttach>();
		for(String s: attachs){
			if(s==null || s.equals(""))
				continue;
			TopicAttach ta = new TopicAttach();
			ta.setSourceAddress(s);
			ta.setSmallAddress(s);
			result.add(ta);
		}
		return result;
		
	}
	private void initTopic(Topic topic,boolean hasAttach) {
		topic.setBottomCount(0);
		topic.setTopCount(0);
		topic.setDate(new Date());
		topic.setHasAttach(hasAttach);
		topic.setStatus(TopicStatus.ready);
		
	}
	public List query(int page, int size) {
		if(page<0){
			page = 0;
		}
		if(size<1){
			size = 20;
		}
		page *= size;
		return topicDao.query(page,size);
		
	}

}
