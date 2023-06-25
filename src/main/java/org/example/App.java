package org.example;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {

//        测试枚举类
        StatusEnum enable = Enum.valueOf(StatusEnum.class, "ENABLE");
        System.out.println(enable);
        System.out.println(enable==StatusEnum.ENABLE);

        StatusEnum[] values = StatusEnum.values();
        for (StatusEnum value : values) {
            System.out.println(value.ordinal());
        }
    }
}
