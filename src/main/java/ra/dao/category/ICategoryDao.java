package ra.dao.category;

import ra.model.Category;

import java.util.List;

public interface ICategoryDao {
    List<Category> findAll();
    List<Category> searchByName(String keyword);
    Category findById(Integer id);
    void save(Category category);  // vừa thêm moi vưa cap nhap
    void deleteById(Integer id);
}
