package org.jim.core.utils;

import org.checkerframework.checker.fenum.qual.SwingTextOrientation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Properties;

public class Prop {

    private Logger logger=LoggerFactory.getLogger(Prop.class);

    private Properties properties;

    public Prop(String fileName){
        this(fileName,"UTF-8");
    }

    /**
     * 将磁盘配置文件通过类加载器加载成输入流   将流转成Properties属性对象
     * @param fileName
     * @param encode
     */
    public Prop(String fileName,String encode){
        //将当前位置的配置文件加载
        InputStream is = null;
        this.properties=null;
        try {
            is = this.getClassLoader().getResourceAsStream(fileName);
            if(is==null){
                throw new IllegalArgumentException("properties file not found in classpath"+fileName);
            }
            this.properties=new Properties();
            this.properties.load(new InputStreamReader(is,encode));
        } catch (IOException e) {
//            e.printStackTrace();
            //抛出异常
            throw new RuntimeException("Error load properties file:"+e);
        }finally {
            //释放流
            if(is!=null){
                try {
                    is.close();
                } catch (IOException e) {
//                    e.printStackTrace();
                    logger.error(e.getMessage(),e);
                }
            }
        }
    }

    //获得当前类的类加载器  **当前线程所在上下文的类加载器**
    public  ClassLoader getClassLoader(){
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        return contextClassLoader!=null? contextClassLoader:this.getClass().getClassLoader();
    }

    //通过File对象完成
    public Prop(File file){
        this(file,"UTF-8");
    }

    public Prop(File file, String encode){

        this.properties=null;//可能之前多次使用过，先将该公共对象置为null

        if (file == null) {
            throw new IllegalArgumentException("File can not be null.");
        } else if (!file.isFile()) {
            throw new IllegalArgumentException("File not found : " + file.getName());
        }else{
            FileInputStream is =null;
            try {
                is=new FileInputStream(file);
                this.properties=new Properties();
                this.properties.load(new InputStreamReader(is,encode));
            } catch (IOException e) {
                throw new RuntimeException("Error loading properties file.", e);
            }finally {
                if(is!=null){
                    try {
                        is.close();
                    } catch (IOException e) {
                        logger.error(e.getMessage(),e);
                    }
                }
            }
        }

    }


    //通过key获取value配置   Properties对象
    public String get(String key){
        return this.properties.getProperty(key);
    }

    public String get(String key,String defaultValue){
        return this.properties.getProperty(key,defaultValue);
    }

    public Integer getInt(String key){
        return this.getInt(key,(Integer)null);
    }

    public Integer getInt(String key,Integer defaultValue){
        String value=this.properties.getProperty(key);
        return value!=null? Integer.parseInt(value.trim()):defaultValue;
    }

    public Long getLong(String key){
        return this.getLong(key,(Long)null);
    }

    public Long getLong(String key,Long defaultValue){
        String value=this.properties.getProperty(key);
        return value!=null? Long.parseLong(value.trim()):defaultValue;
    }

    public Boolean getBoolean(String key) {
        return this.getBoolean(key, (Boolean) null);
    }

    public Boolean getBoolean(String key, Boolean defaultValue) {
        String value = this.properties.getProperty(key);
        if (value != null) {
            value = value.toLowerCase().trim();
            if ("true".equals(value)) {
                return true;
            } else if ("false".equals(value)) {
                return false;
            } else {
                throw new RuntimeException("The value can not parse to Boolean : " + value);
            }
        } else {
            return defaultValue;
        }
    }

    public boolean containsKey(String key) {
        return this.properties.containsKey(key);
    }

    public Properties getProperties() {
        return this.properties;
    }
}
