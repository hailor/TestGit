package com.hand.database;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

import com.hand.entity.Customer;
import com.hand.entity.Language;

public class MyHQL {

	/**
	 * 执行delete和update操作
	 * @param hql  Hibernate的HQL语句
	 * @return 更新的记录数量
	 */
	public  boolean update(String hql){
		boolean result = true;
		Session session = null;
		Query query = null;
		try{
			session = Factory.getSession();
			query = session.createQuery(hql);
	        query.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			result = false;
		}finally {
			session.close();
		}
        return result;
	}
	
	public  boolean updateSQL(String sql){
		boolean result = true;
		Session session = null;
		Query query = null;
		try{
			session = Factory.getSession();
			query = session.createSQLQuery(sql);
	        query.executeUpdate();
		}catch(Exception e){
			e.printStackTrace();
			result = false;
		}finally {
			session.close();
		}
        return result;
	}
	
	/**
	 * 查询
	 * @param hql
	 * @return
	 */
	public  List select(String hql){
		List result = null;
		try{
			Session session = Factory.getSession();
			Query query = session.createQuery(hql);
			result= query.list();
	        session.close();
		}catch(Exception exception){
			exception.printStackTrace();
		}
		
        return result;
	}
	
	/**
	 * 通过id从数据库获得Customer
	 * @param customerId
	 * @return
	 */
	public  Customer getCustomer(Short customerId){
		Customer customer = null;
		Session session = Factory.getSession();
		Query query = session.createQuery("from Customer where customerId = "+customerId);
        List result = query.list();
        if(result.size() == 1){
        	customer = (Customer)query.list().get(0);
        }
        session.close();
        return customer;
	}
	
	public  Object getCustomerTest(Class ob,Short customerId){
		Object result = null;
		Transaction tx = null;
		Session session = null;
		try{
			session = Factory.getSession();
			tx = session.beginTransaction();
			result = session.get(ob, customerId);
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			result = null;
		} finally {
			session.close();
		}
		
		return result;
	}
	
	public  boolean add(Object ob){
		boolean result = true;
		Transaction tx = null;
		Session session = null;
		try{
			session = Factory.getSession();
			tx = session.beginTransaction();
			session.save(ob);
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			result = false;
		} finally {
			session.close();
		}
		
		return result;
	}
	
	public  boolean delete(Object ob){
		boolean result = true;
		Transaction tx = null;
		Session session = null;
		try{
			session = Factory.getSession();
			tx = session.beginTransaction();
			session.delete(ob);
			tx.commit();
		} catch(Exception e){
			e.printStackTrace();
			tx.rollback();
			result = false;
		} finally {
			session.close();
		}
		
		return result;
	}
	
	
}
