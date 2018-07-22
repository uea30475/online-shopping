package vn.pmt.shoppingbackend.dao;

import java.util.List;

import vn.pmt.shoppingbackend.dto.Category;

public interface CategoryDAO {

	boolean add(Category category);
	List<Category> list();
	Category get(int id);
}
