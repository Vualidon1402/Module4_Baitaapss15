package ra.service;

import ra.model.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();
    List<Book> searchByName(String keyword);
    Book findById(Integer id);
    void save(Book product);  // vừa thêm moi vưa cap nhap
    void deleteById(Integer id);

}
