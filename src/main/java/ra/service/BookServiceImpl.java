package ra.service;

import ra.dao.book.BookDaoImpl;
import ra.dao.book.IBookDao;
import ra.model.Book;

import java.util.List;

public class BookServiceImpl implements IBookService {
    private static final IBookDao bookDao = new BookDaoImpl();

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();

    }

    @Override
    public List<Book> searchByName(String keyword) {
        return bookDao.searchByName(keyword);
    }

    @Override
    public Book findById(Integer id) {
        return bookDao.findById(id);
    }

    @Override
    public void save(Book book) {
        bookDao.save(book);
    }

    @Override
    public void deleteById(Integer id) {
        bookDao.deleteById(id);
    }
}
