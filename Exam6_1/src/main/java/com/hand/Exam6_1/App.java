package com.hand.Exam6_1;

import java.util.Scanner;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.hand.jdbc.MySQL;

/**
 * Hello world!
 *
 */
public class App 
{
	public App(){
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("com/hand/ApplicationContext.xml");
//		ConfigurableApplicationContext context = new FileSystemXmlApplicationContext("conf/ApplicationContext.xml");
		context.start();
		MySQL mysql = context.getBean("mysql",MySQL.class);
		
		Scanner read;
		System.out.println("请输入电影名称（title）：");
		read = new Scanner(System.in);
		String title = read.nextLine();
		
		System.out.println("请输入电影描述（description）：");
		read = new Scanner(System.in);
		String description = read.nextLine();
		
		System.out.println("请输入语言ID（language_id）：");
		read = new Scanner(System.in);
		String language_id = read.nextLine();
		read.close();
		
		mysql.beforePublish();
		String sql = "insert into film(title,description,language_id) values("+"'"+title+"',"+"'"+description+"',"+language_id+")";
		if(mysql.update(sql)){
			mysql.afterPublish();
		} else{
			System.out.println("数据输入错误！");
		}
		context.stop();
		
		
	}
	
	
	
    public static void main( String[] args )
    {
    		App a = new App();
    		System.out.println("----------------------------------");
    		
        
    }
}
