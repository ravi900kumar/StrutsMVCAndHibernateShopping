package java9r.dao.com;
 import entites.com.*;
 import utill.com.*;

import java.util.List;

import javax.xml.crypto.dsig.Transform;

import javassist.compiler.ast.Keyword;
import javassist.convert.Transformer;

import org.hibernate.*;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;

import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.hibernate.type.*;
public class ProductDAOImpl  {
private SessionFactory sessionFactory=HibernateUtil.getSessionFactory();
 
	
	@SuppressWarnings("unchecked")
	public List<Product> findAll(){
		try {		
			if(!sessionFactory.getCurrentSession().getTransaction().isActive())
				sessionFactory.getCurrentSession().getTransaction().begin();
			return sessionFactory.getCurrentSession().createCriteria(Product.class)
					.list();
			
		} catch (Exception e) {
			return null;
		}
	}
	 

	public Product find(int id){
		try {
			if(!sessionFactory.getCurrentSession().getTransaction().isActive())
				sessionFactory.getCurrentSession().getTransaction().begin();
		return (Product)sessionFactory.getCurrentSession().createCriteria(Product.class)
				.add(Restrictions.eq("id",id)).uniqueResult();
		
			
		} catch (Exception e) {
			return null;
		}
	}

 
 

}
