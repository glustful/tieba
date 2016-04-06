package org.yigou.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "t_topicattach")
public class TopicAttach {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int _id;
	private int topicId;
	private String sourceAddress;
	private String smallAddress;
	private String description;

	public int get_id() {
		return _id;
	}

	public void set_id(int _id) {
		this._id = _id;
	}

	public int getTopicId() {
		return topicId;
	}

	public void setTopicId(int topicId) {
		this.topicId = topicId;
	}

	public String getSourceAddress() {
		return sourceAddress;
	}

	public void setSourceAddress(String sourceAddress) {
		this.sourceAddress = sourceAddress;
	}

	public String getSmallAddress() {
		return smallAddress;
	}

	public void setSmallAddress(String smallAddress) {
		this.smallAddress = smallAddress;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}
