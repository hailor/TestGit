package com.hand.handtest;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	ConfigurableApplicationContext context = null;
    try{	
    context = new ClassPathXmlApplicationContext("ApplicationContext.xml");
    }catch(Exception e){
    	System.out.println("找不到配置文件");
    	e.printStackTrace();
    }
    FilmJDBCTemplate studentJDBCTemplate = 
    		      (FilmJDBCTemplate)context.getBean("FilmJDBCTemplate");     
    Scanner sc = new Scanner(System.in);
    String title = null;
    String description = null;
    Integer language_id = null;
    System.out.println("Context Start" );
    System.out.println("请输入电影名称(title):" );
    title = sc.next();
    System.out.println("请输入电影描述(description):" );
    description = sc.next();
    System.out.println("请输入语言ID(language_id):" );
    language_id = sc.nextInt();
    //context.start();//Spring事件
    //spring自定义事件
    BeforeInsertEventPublisher bip = (BeforeInsertEventPublisher) context.getBean("BeforeInsertFilmEventPublisher");
    bip.publish();
    studentJDBCTemplate.create(title,description,language_id);
    //context.stop();
    AfterInsertEventPublisher aip = (AfterInsertEventPublisher) context.getBean("AfterInsertFilmEventPublisher");
    aip.publish();
    System.out.println("Context Stop" );
    }
}
