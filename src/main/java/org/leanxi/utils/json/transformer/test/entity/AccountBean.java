/**
 * Project Name:javase_review
 * File Name:AccountBean.java
 * Package Name:org.leanxi.utils.json.transformer.test.bean
 * Date:2017年11月24日上午10:14:15
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leanxi.utils.json.transformer.test.entity;

import org.leanxi.utils.json.transformer.test.entity.Birthday;

/**
 * ClassName:AccountBean <br/>
 * Date:     2017年11月24日 上午10:14:15 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class AccountBean {
	private int id ;
	private String name ;
	private String email ;
	private String address ;
	private Birthday birthday ;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public Birthday getBirthday() {
		return birthday;
	}
	public void setBirthday(Birthday birthday) {
		this.birthday = birthday;
	}
	@Override
	public String toString() {
		return "AccountBean [id=" + id + ", name=" + name + ", email=" + email + ", address=" + address + ", birthday="
				+ birthday + "]";
	}
}

