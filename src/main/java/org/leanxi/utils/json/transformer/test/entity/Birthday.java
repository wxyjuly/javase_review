/**
 * Project Name:javase_review
 * File Name:Birthday.java
 * Package Name:org.leanxi.utils.json.transformer.test.entity
 * Date:2017年11月24日上午10:15:50
 * Copyright (c) 2017, 【Leon Xi】 All Rights Reserved.
 *
*/

package org.leanxi.utils.json.transformer.test.entity;
/**
 * ClassName:Birthday <br/>
 * Date:     2017年11月24日 上午10:15:50 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class Birthday {
	private String birthday ;
	
	public Birthday() {
	}

	public Birthday(String birthday) {
		this.birthday = birthday;
	}

	public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Birthday [birthday=" + birthday + "]";
	}
}

