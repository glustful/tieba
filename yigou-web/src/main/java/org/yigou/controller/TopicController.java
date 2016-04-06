package org.yigou.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.expression.spel.ast.OpAnd;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.yigou.model.Topic;
import org.yigou.service.ITopicService;

@Controller
@RequestMapping(value = "/topic")
public class TopicController {

	@Autowired
	ITopicService topicService;

	@ResponseBody
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public ModelMap add(Topic topic, String result) {
		String[] attachs = null;
		if (result != null && !result.equals("")) {
			if (result.endsWith(",")) {
				result = result.substring(0, result.length() - 1);
			}
			attachs = result.split(",");
		}
		boolean success = topicService.addTopic(topic, attachs);
		ModelMap mm = new ModelMap();
		if (success) {
			mm.put("status", true);
			mm.put("msg", "发布成功，请等待管理员审核");
		} else {
			mm.put("status", false);
			mm.put("msg", "发布失败，请稍后重试");
		}
		return mm;
	}
	
	@ResponseBody
	@RequestMapping(value="/query",method=RequestMethod.GET)
	public Object query(String page,String pageSize){
		int p1 = Integer.parseInt(page);
		int p2 = Integer.parseInt(pageSize);
		ArrayList<Topic> result = (ArrayList<Topic>) topicService.query(p1,p2); 
		ModelMap mm = new ModelMap();
		//if(result==null)
		mm.put("status", true);   
		mm.put("msg", "");
		mm.put("data", result);
		return mm;
	}
}
