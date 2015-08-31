package com.hand.Exam7_1;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hand.database.MyHQL;
import com.hand.entity.Address;
import com.hand.entity.Customer;
import com.hand.entity.Payment;
import com.hand.entity.Rental;
import com.hand.entity.Store;

/**
 * Hello world!
 *
 */
public class App 
{
	private Customer customer;
	private Scanner read;
	private MyHQL myhql;
	private int store_id = 1;
	
	
	public App(){
		ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("com/hand/ApplicationContext.xml");
		context.start();
		myhql = context.getBean("myhql",MyHQL.class);
		customer = new Customer();
		
		
		customer.setStore((Store)myhql.select("from Store where storeId = "+store_id).get(0));
		System.out.println("FirstName(first_name):");
		read = new Scanner(System.in);
		customer.setFirstName(read.nextLine());
		
		System.out.println("LastName(last_name):");
		read = new Scanner(System.in);
		customer.setLastName(read.nextLine());
		
		System.out.println("Email(email):");
		read = new Scanner(System.in);
		customer.setEmail(read.nextLine());
		
		System.out.println("请输入Address ID:");
		read = new Scanner(System.in);
		List list = myhql.select("from Address where addressId = "+Integer.valueOf(read.nextShort()));
//		Address a = (Address)myhql.getCustomerTest(Address.class, read.nextShort());
		while(list.size()==0){
			System.out.println("你输入的Address ID不存在，请重新输入:");
			read = new Scanner(System.in);
			list = myhql.select("from Address where addressId = "+Integer.valueOf(read.nextLine()));
		}
		customer.setAddress((Address)list.get(0));
		
		
    	java.sql.Date date = new java.sql.Date(new Date().getTime());
    	customer.setCreateDate(date);
    	customer.setLastUpdate(date);
    	
    	if(myhql.add(customer)){
    		System.out.println("已经保存的数据如下:");
    		System.out.println("ID:"+customer.getCustomerId());
    		System.out.println("First_name:"+customer.getFirstName());
    		System.out.println("Last_name:"+customer.getLastName());
    		System.out.println("Email:"+customer.getEmail());
    		System.out.println("Address:"+customer.getAddress().getAddress());
    	} else{
    		System.out.println("------------------"+"error"+"------------------");
    	}
    	System.out.println("请输入要删除的Customer的ID:");
    	read = new Scanner(System.in);
    	Short id = read.nextShort();
    	Customer c = (Customer)myhql.getCustomerTest(Customer.class,id);
    	while(c == null){
    		System.out.println("输入错误，请重新输入要删除的Customer的ID:");
        	read = new Scanner(System.in);
    		c = (Customer)myhql.getCustomerTest(Customer.class,read.nextShort());
    	}
    	if(myhql.delete(c)){
    		System.out.println("你输入的ID为"+""+"的Customer已经删除.");
    	} else{
    		System.out.println("------------------"+"CustomerID错误"+"------------------");
    	}
    	
    	context.stop();
	}
	
	
    public static void main( String[] args )
    {
    	new App();
    }
}
