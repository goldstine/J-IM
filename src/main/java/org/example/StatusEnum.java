package org.example;

public enum StatusEnum {

    ENABLE("1","启用"),DISABLE("2","关闭");

    private String code;

    private String name;

    StatusEnum(String code,String name){
        this.code=code;
        this.name=name;
    }

}
