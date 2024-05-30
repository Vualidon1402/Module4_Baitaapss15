package ra.service;

import ra.dao.category.CategoryDaoImpl;
import ra.dao.category.ICategoryDao;
import ra.model.Category;

import java.util.List;

public class CategoryServiceImpl implements ICategoryService {
    private static final ICategoryDao categoryDao = new CategoryDaoImpl();

    @Override
    public List<Category> findAll() {
        return categoryDao.findAll();
    }

    @Override
    public List<Category> searchByName(String keyword) {
        return categoryDao.searchByName(keyword);
    }

    @Override
    public Category findById(Integer id) {
        return categoryDao.findById(id);
    }

    @Override
    public void save(Category category) {
        categoryDao.save(category);
    }

    @Override
    public void deleteById(Integer id) {
        categoryDao.deleteById(id);

    }
}
