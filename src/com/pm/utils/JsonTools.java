package com.pm.utils;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;


import com.pm.bean.User;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;


/**
 * 这是一个工具类
 * 这里专门处理Java对象转Json字符串的功能
 * @ClassName JsonTools
 * @author sz-agatha-henry
 * @date 2014年11月3日 下午15:00:47 
 * @version 1.0
 */
public class JsonTools {

    public JsonTools() {
    }
    // 第1种方法Object value
    public static String createJsonString(String key,Object value){
        Gson gson = new Gson();
        String str = gson.toJson(value);//就可以转换成Json数据格式
		return str;
    }
    // 第2种方法Object value
    public static String createJsonString2(Object value){
        Gson gson = new Gson();
        String str = gson.toJson(value);//就可以转换成Json数据格式
		return str;
    }
    public static List<User> StringFromJson (String jsondata)
	{     
		Type listType = new TypeToken<List<User>>(){}.getType();
		Gson gson=new Gson();
		ArrayList<User> list=gson.fromJson(jsondata, listType);
		return list;
	}
    /* 
     * 通过引入gson jar包 写入 json 数据 
     */
    public static String getJsonData(List<?> list)  
    {  
    	//此处要注意，时常会出现说找不到Gson类的情况，这时我们只需要将导入的包和系统提供换换顺序就行了  
        Gson gson=new Gson();//利用google提供的gson将一个list集合写成json形式的字符串  
        String jsonstring=gson.toJson(list);  
        return jsonstring;  
    }  
    /**
     * @param object
     * 			 是对解析集合的类型
     * @return
     */
    // 接受对象转换为JSON数据格式并且作为字符串输出.
    public static String createJsonString3(String key,Object value){
    	JSONObject jsonObj = new JSONObject(); 
    	jsonObj.put(key, value);
        return jsonObj.toString();
    }
}
