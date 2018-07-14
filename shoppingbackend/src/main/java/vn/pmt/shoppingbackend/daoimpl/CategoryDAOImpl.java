package vn.pmt.shoppingbackend.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import vn.pmt.shoppingbackend.dao.CategoryDAO;
import vn.pmt.shoppingbackend.dto.Category;

@Repository("categoryDAO")
public class CategoryDAOImpl implements CategoryDAO {
	
	private static List<Category> categories = new ArrayList<>();
	
	static {
		Category c = new Category();
		c.setId(1);
		c.setName("Television");
		c.setDescription("This is some description for television!");
		c.setImageURL("CAT_1.png");
		categories.add(c);
		c = new Category();
		c.setId(2);
		c.setName("Mobile");
		c.setDescription("This is some description for Mobile!");
		c.setImageURL("CAT_2.png");
		categories.add(c);
		c = new Category();
		c.setId(3);
		c.setName("Laptop");
		c.setDescription("This is some description for Laptop!");
		c.setImageURL("CAT_3.png");
		categories.add(c);
	}
	

	@Override
	public List<Category> list() {
		// TODO Auto-generated method stub
		return categories;
	}


	@Override
	public Category get(int id) {
		for(Category category:categories) {
			if(category.getId()==id)
				return category;
		}
		return null;
	}
	

}
