package ra.dao.book;

import ra.model.Book;
import ra.model.Category;

import java.util.List;

public interface IBookDao {
    List<Book> findAll();
    List<Book> searchByName(String keyword);
    Book findById(Integer id);
    void save(Book book);  // vừa thêm moi vưa cap nhap
    void deleteById(Integer id);
}
