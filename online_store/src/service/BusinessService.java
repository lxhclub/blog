package service;

import java.util.List;

import entity.Category;

public interface BusinessService {
	void addCategory(Category category);
	Category findCategory(String id);
	List<Category>getAllCategory();

}
