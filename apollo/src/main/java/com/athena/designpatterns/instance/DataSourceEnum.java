package com.athena.designpatterns.instance;

/**
 * Created by yaser.zhang on 2019/8/15.
 */
public enum DataSourceEnum {
    // Java规范字规定，每个枚举类型及其定义的枚举变量在JVM中都是唯一的，因此在枚举类型的序列化和反序列化上，Java做了特殊的规定。

    // 枚举对象
    DATASOURCE;
    private DBConnection connection = null;
    private DataSourceEnum(){
        connection = new DBConnection();
    }
    public DBConnection getConnection(){
        return connection;
    }
}

/*
public final class DataSourceEnum extends Enum
{
    public static DataSourceEnum[] values(){
        return (DataSourceEnum[])$VALUES.clone();
    }
	//toString的逆方法，返回指定名字，给定类的枚举常量
    public static DataSourceEnum valueOf(String name){
        return (DataSourceEnum)Enum.valueOf(creational/singleton/dbconn/DataSourceEnum, name);
    }
	//私有构造函数，参数有 此枚举常量的名称，枚举常量的序号
    private DataSourceEnum(String s, int i){
        super(s, i);
        //单例对象的属性
        connection = null;
        connection = new DBConnection();
    }

    public DBConnection getConnection(){
        return connection;
    }
	//单例对象
    public static final DataSourceEnum DATASOURCE;
    //单例对象的属性
    private DBConnection connection;
    private static final DataSourceEnum $VALUES[];
    static
    {
    	//与饿汉式相似，类初始化时创建单例对象
        DATASOURCE = new DataSourceEnum("DATASOURCE", 0);
        $VALUES = (new DataSourceEnum[] {
            DATASOURCE
        });
    }
}
---------------------
版权声明：本文为CSDN博主「宏志有缘再见」的原创文章，遵循CC 4.0 by-sa版权协议，转载请附上原文出处链接及本声明。
原文链接：https://blog.csdn.net/qq_38844728/article/details/88903939
*/
