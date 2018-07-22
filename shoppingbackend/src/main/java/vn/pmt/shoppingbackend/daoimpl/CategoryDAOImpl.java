package vn.pmt.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import vn.pmt.shoppingbackend.dao.CategoryDAO;
import vn.pmt.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {
	
	@Autowired
	private SessionFactory sessionFactory;
	private static List<Category> categories = new ArrayList<>();
	
	

	@Override
	public List<Category> list() {
		try {
			return sessionFactory.getCurrentSession().createQuery("FROM Category",Category.class).getResultList();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}


	@Override
	public Category get(int id) {
		try {
		return sessionFactory.getCurrentSession().get(Category.class, id);
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return null;
	}


	@Override
	
	public boolean add(Category category) {
		try {
			sessionFactory.getCurrentSession().persist(category);
			return true;
		}catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	

}
