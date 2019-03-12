package com.pm.utils;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * 这是一个配置管理器
 * @ClassName ConfigManager
 * @author sz-agatha-wang
 * @date 2014年11月3日 下午15:00:47 
 * @version 1.0
 */
public class ConfigManager {
    /**
     * 读取数据库配置文件
     */
	private static ConfigManager configManager;
	private static Properties properties;
	
	/**
	 * 进行配置文件读取
	 */
    private ConfigManager(){
    	String config="dataSource.properties";
    	properties=new Properties();
    	InputStream in=ConfigManager.class.getClassLoader().getResourceAsStream(config);
    	
    	try {
			properties.load(in);
		} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
	//通过单 例模式设置实例化的个数
    public static ConfigManager getInstance(){
    	if(configManager==null){
    		configManager=new ConfigManager();
    	}
    	return configManager;
    }
   
    //通过key获取 对应的Value
    public String getString (String key){
       return properties.getProperty(key);
    }
}
