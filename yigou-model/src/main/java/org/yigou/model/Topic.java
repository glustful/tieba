package org.yigou.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_topic")
public class Topic {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _id;
	private String pic;
	
	private String title;
	@Column(length=1000)
	private String content;
	private String symbox;// 标签
	private TopicStatus status;
	private int addUserId;
	private int verifyUserId;
	private boolean hasAttach;
	private int topCount;
	private int bottomCount;
	private Date date;

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getSymbox() {
		return symbox;
	}

	public void setSymbox(String symbox) {
		this.symbox = symbox;
	}

	public TopicStatus getStatus() {
		return status;
	}

	public void setStatus(TopicStatus status) {
		this.status = status;
	}

	public int getAddUserId() {
		return addUserId;
	}

	public void setAddUserId(int addUserId) {
		this.addUserId = addUserId;
	}

	public int getVerifyUserId() {
		return verifyUserId;
	}

	public void setVerifyUserId(int verifyUserId) {
		this.verifyUserId = verifyUserId;
	}

	public boolean isHasAttach() {
		return hasAttach;
	}

	public void setHasAttach(boolean hasAttach) {
		this.hasAttach = hasAttach;
	}

	public int getTopCount() {
		return topCount;
	}

	public void setTopCount(int topCount) {
		this.topCount = topCount;
	}

	public int getBottomCount() {
		return bottomCount;
	}

	public void setBottomCount(int bottomCount) {
		this.bottomCount = bottomCount;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
}


