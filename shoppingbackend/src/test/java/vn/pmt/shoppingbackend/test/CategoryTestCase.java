package vn.pmt.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import vn.pmt.shoppingbackend.dao.CategoryDAO;
import vn.pmt.shoppingbackend.dto.Category;

public class CategoryTestCase {
	
	private static AnnotationConfigApplicationContext context;
	private static CategoryDAO categoryDAO;
	private Category category;
	
	@BeforeClass
	public static void init() {
		 context = new AnnotationConfigApplicationContext();
		 context.scan("vn.pmt.shoppingbackend");
		 //context.scan("vn.pmt.shoppingbackend.daoimpl");
		 //context.scan("vn.pmt.shoppingbackend.config");
		 context.refresh();
		 categoryDAO = 	(CategoryDAO) context.getBean("categoryDAO");

	}
	
	@Test
	public void testAddCategory() {
		category = new Category();
		category.setName("Television");
		category.setDescription("This is some description for television!");
		category.setImageURL("CAT_1.png"); 
		assertEquals("Successfully added category inside the table", true,categoryDAO.add(category));
		
	}

}
