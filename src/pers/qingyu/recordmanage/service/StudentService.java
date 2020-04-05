package pers.qingyu.recordmanage.service;

import java.util.ArrayList;


import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import pers.qingyu.recordmanage.pojo.StudentFile;

public class StudentService {
	private static SessionFactory sessionFactory;
	static {
		sessionFactory =new Configuration().configure().buildSessionFactory();
	}
	
	public void addStudentFile (StudentFile student) {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		session.save(student);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

	public ArrayList<StudentFile> getAllStudent(){
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from StudentFile");
		@SuppressWarnings("unchecked")
		ArrayList<StudentFile> files = (ArrayList<StudentFile>) query.list();
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		return files;
	}
	
	public int getStudentCount () {
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		Query query = session.createQuery("from StudentFile");
		int count = query.list().size();
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
		
		return count;
	}
	
}
