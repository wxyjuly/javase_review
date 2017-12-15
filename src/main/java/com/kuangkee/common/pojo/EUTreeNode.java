package com.kuangkee.common.pojo;

/**
 * easyUI树形控件节点格式
 * ClassName: EUTreeNode <br/>
 * date: 2017年12月15日 上午10:25:48 <br/>
 * @author Leon Xi
 * @version v1.0
 */
public class EUTreeNode {

	private long id;
	private String text;
	private String state;
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
