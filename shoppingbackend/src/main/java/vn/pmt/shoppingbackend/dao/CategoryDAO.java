package vn.pmt.shoppingbackend.dao;

import java.util.List;

import vn.pmt.shoppingbackend.dto.Category;

public interface CategoryDAO {

	List<Category> list();
	Category get(int id);
}
