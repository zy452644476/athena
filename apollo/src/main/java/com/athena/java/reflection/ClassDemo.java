package com.athena.java.reflection;

import java.lang.annotation.Annotation;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by yaser.zhang on 2019/8/13.
 */
public class ClassDemo {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        // 不会初始化静态块
        Class clazz = XYZ.class;
        System.out.println("------");
        // 会初始化，会初始化静态属性、执行静态代码块
        Class clazz2 = Class.forName("com.athena.java.reflection.XYZ");

        XYZ xyz = new XYZ("123");

        String clazzName=clazz.getName();//获取类名，含包名
        String clazzSimpleName=clazz.getSimpleName();//获取类名，不含包名
        System.out.println("getName："+clazzName+"\tgetSimpleName："+clazzSimpleName);

        Package p=clazz.getPackage();//获取包
        System.out.println("getPackage："+p);

        Class superClass=clazz.getSuperclass();//获取父类
        System.out.println("getSuperclass："+superClass);

        Class[] interfaces=clazz.getInterfaces();//获取实现接口
        System.out.println("getInterfaces:"+interfaces.length);

        Constructor[] cons=clazz.getConstructors();//构造方法
        System.out.println("getConstructors:"+cons.length);

        Method[] methods=clazz.getMethods();//获取所有方法
        System.out.println("getMethods:"+methods.length);
        for(Method method:methods){
            System.out.println("method.getName:"+method);
        }

        Method method=clazz.getMethod("getProp1", null);//获取指定方法
        System.out.println("getMethod(,):"+method);
        Object methodVlaue=method.invoke(xyz, null);//调用方法
        System.out.println("method.invoke(,):"+methodVlaue);

        Method method3=clazz.getMethod("setProp3",Double.class);//获取指定方法
        Object methodVlaue3=method3.invoke(xyz, 2.0);//调用setter方法，该方法没有返回值，所以methodVlaue3为null；此处注意参数2.0 ，不能用null

        Field[] fields=clazz.getDeclaredFields();//获取变量
        System.out.println("getDeclaredFields:"+fields.length);
        for(Field field:fields){
            field.setAccessible(true);
            field.set(xyz,null);//设置字段的值
            System.out.println("field.getAnnotations:"+field.getAnnotations().length+"\tfield.getName:"+field.getName()+"\tfield.get:"+field.get(xyz));//获取实例属性名和值
        }

        Annotation[] annos=clazz.getAnnotations();//获取类注解
        System.out.println("getAnnotations:"+annos.length);
    }
}
