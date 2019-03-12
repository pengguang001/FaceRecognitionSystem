package com.pm.bean;

import com.pm.bean.Sex;
/**
 * 性别枚举类型;枚举类，F:falmen/M:man;
 * @author sz-agatha-wang
 *  --此类暂时不使用--
 */
public enum Sex {
	 F("女", 1), M("男", 2);
	// 成员变量
   private String name;
   private int index;
   
   // 构造方法
	private Sex(String name, int index) {
		this.name = name;
		this.index = index;
	}
	// 普通方法
   public static String getName(int index) {
       for (Sex s : Sex.values()) {
           if (s.getIndex() == index) {
               return s.name;
           }
       }
       return null;
   }
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getIndex() {
		return index;
	}
	public void setIndex(int index) {
		this.index = index;
	}
   
}