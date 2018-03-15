/**
 * Project Name:javase_review
 * File Name:InstanceFactory.java
 * Package Name:com.leonxi.javase.juc.artconcurrentbook.chapter03.doublecheckedlocking
 * Date:2018年1月22日下午11:17:44
 * Copyright (c) 2018, 【Leon Xi】 All Rights Reserved.
 *
*/

package com.leonxi.javase.juc.artconcurrentbook.chapter03.doublecheckedlocking;

/**
 * 单例安全，标准写法
 * ClassName:InstanceFactory <br/>
 * Date:     2018年1月22日 下午11:17:44 <br/>
 * @author   Leon Xi
 * @version  v1.0
 * @see 	 
 */
public class InstanceFactory {
    private static class InstanceHolder {
        public static Instance instance = new Instance();
    }

    public static Instance getInstance() {
        return InstanceHolder.instance; //这里将导致InstanceHolder类被初始化
    }

    static class Instance {
    }
}

