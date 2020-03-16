/**#################################################################
 * 
 **#################################################################*/
package com.demo.hibernate.output;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.demo.hibernate.dao.BookDao;
import com.demo.hibernate.entity.Book;
import com.demo.hibernate.entity.Child;
import com.demo.hibernate.entity.Parent;
import com.demo.hibernate.utility.HibernateUtil;

/**#################################################################
 * @author ANICET ERIC KOUAME
 * @Date: 20 mars 2017
 * @Description:
 *Main
 *#################################################################*/

public class Main {

	 /**
	 * @param args
	 */
	/**
	 * @param args
	 */
	public static void main2(String[] args) 
	 {
	
		BookDao b=new BookDao();
		Book book=new Book();
      
	
		/**#################################################################
		 * Call Add book
		 *#################################################################*/
		b.saveBook("terminator", "Jame", 550);
		
		
		/**#################################################################
		 * Call get list book
		 *#################################################################*/
		List<Book> bt=b.getBooks();
		System.out.println(bt.get(0).getAuthor());
		
		

		/**#################################################################
		 * Update book
		 *#################################################################*/
		book.setAuthor("Anicet");
		book.setTitle("mecanique");
		book.setPrice(600);
		book.setId(1);		
		System.out.println(b.updateBook(book));
		
		
		/**#################################################################
		 * Delete book
		 *#################################################################*/
		System.out.println(b.deleteBook(2));
		
		
	 }
	
	public static void main(String[] args) {
		Session session = HibernateUtil.getSession(); 
		Transaction transaction = session.beginTransaction();
		Parent parent = new Parent();
		parent.setFirstName("parent");
		parent.setLastName("lname");
		Set<Child> childs = new HashSet<Child>();
		Child child = new Child();
		child.setAge(10);
		child.setFirstName("child");
		child.setLastName("lname");
		child.setParent(parent);
		childs.add(child);
		parent.setChildren(childs);
		session.save(parent);
		transaction.commit();
		session.close();
		//Parent p = (Parent)session.load(Parent.class, new Long(8));
		
//        Query query = session.getNamedQuery("HQL_GET_ALL_PARENT");
////        query = session.createSQLQuery("select * from Parent");
//        query.setLong("id", 2);
//        Parent p = (Parent)query.list().get(0);
//        List<Parent> parents =  query.list();
//        System.out.println(parents.size());
        
//		BookDao b=new BookDao();
//		b.saveParent();
	}
	
	  
}
