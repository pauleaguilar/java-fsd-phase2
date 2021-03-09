package com.example;


import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.User;


public class UserValidate {
	 
	
	public static boolean validate(String username, String password) {

	        Transaction transaction = null;
	        User user = null;
	        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
	            // start a transaction
	        	  transaction = session.beginTransaction();
	            // get an user object
	            user = (User) session.createQuery("FROM User U WHERE U.name = :username").setParameter("username", username)
	                .uniqueResult();

	            if (user != null && user.getPassword().equals(password)) {
	                return true;
	            }
	            // commit transaction
	            transaction.commit();
	        } catch (Exception e) {
	            if (transaction != null) {
	                transaction.rollback();
	            }
	            e.printStackTrace();
	        }
	        return false;
	    }

	}
