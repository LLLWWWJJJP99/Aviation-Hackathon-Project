package dao;

import java.util.List;

import domain.Category;

public interface CategoryDao
{

    public void addCategory(Category category);

    public List getAllCategory();

    public Category findCategoryById(String id);

    /**
     * @param category
     */
    public void updateCategory(Category category);

    /**
     * @param id
     */
    public void deleteCategoryById(String id);
}
