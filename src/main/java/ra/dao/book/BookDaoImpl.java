package ra.dao.book;

import ra.model.Book;
import ra.util.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookDaoImpl implements IBookDao {
    @Override
    public List<Book> findAll() {
        List<Book> books = new ArrayList<>();
        // mo 1 ket noi
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("select * from book");
            //thuc thi sql
            ResultSet rs = callSt.executeQuery(); // thuc thi cau lenh select
            while (rs.next()) {
                Book book = new Book(
                        rs.getInt("book_id"),
                        rs.getInt("category_id"),
                        rs.getString("book_name"),
                        rs.getDouble("book_price"),
                        rs.getInt("stock"),
                        rs.getInt("total_pages"),
                        rs.getDate("year_created"),
                        rs.getString("book_author"),
                        rs.getBoolean("book_status")
                );
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }

    }

    @Override
    public List<Book> searchByName(String keyword) {
        List<Book> books = new ArrayList<>();
        // mo 1 ket noi
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("select * from book like ?}");
            // truyen tham so
            callSt.setString(1, keyword);
            // thuc thi sql
            ResultSet rs = callSt.executeQuery(); // thuc thi cau lenh select
            if (rs.next()) {
                Book book = new Book(
                        rs.getInt("book_id"),
                        rs.getInt("category_id"),
                        rs.getString("book_name"),
                        rs.getDouble("book_price"),
                        rs.getInt("stock"),
                        rs.getInt("total_pages"),
                        rs.getDate("year_created"),
                        rs.getString("book_author"),
                        rs.getBoolean("book_status")
                );
                books.add(book);
            }
            return books;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public Book findById(Integer id) {
        Book book = null;
        // mo 1 ket noi
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("select * from book where book_id =?");
            // truyen tham so
            callSt.setInt(1, id);
            // thuc thi sql
            ResultSet rs = callSt.executeQuery(); // thuc thi cau lenh select
            if (rs.next()) {
                book = new Book(
                        rs.getInt("book_id"),
                        rs.getInt("category_id"),
                        rs.getString("book_name"),
                        rs.getDouble("book_price"),
                        rs.getInt("stock"),
                        rs.getInt("total_pages"),
                        rs.getDate("year_created"),
                        rs.getString("book_author"),
                        rs.getBoolean("book_status")
                );
            }
            return book;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }

    }

    @Override
    public void save
            (Book book) {
        Connection conn = ConnectDB.getConnection();
        PreparedStatement callSt = null;
        try {
            if (book.getBookId() == null) {
                callSt = conn.prepareStatement("insert into book(book_name, category_id, book_price, stock, total_pages, year_created, book_author, book_status) values (?,?,?,?,?,?,?,?)");
                callSt.setString(1, book.getBookName());
                callSt.setInt(2, book.getCategoryId());
                callSt.setDouble(3, book.getBookPrice());
                callSt.setInt(4, book.getStock());
                callSt.setInt(5, book.getTotalPages());
                callSt.setDate(6, book.getYearCreated());
                callSt.setString(7, book.getAuthor());
                callSt.setBoolean(8, book.isBookStatus());
            } else {
                callSt = conn.prepareCall("update book set book_name = ?, category_id = ?, book_price = ?, stock = ?, total_pages = ?, year_created = ?, book_author = ?, book_status = ? where book_id = ?");
                callSt.setString(1, book.getBookName());
                callSt.setInt(2, book.getCategoryId());
                callSt.setDouble(3, book.getBookPrice());
                callSt.setInt(4, book.getStock());
                callSt.setInt(5, book.getTotalPages());
                callSt.setDate(6, book.getYearCreated());
                callSt.setString(7, book.getAuthor());
                callSt.setBoolean(8, book.isBookStatus());
                callSt.setInt(9, book.getBookId());
            }
            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);

        } finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public void deleteById(Integer id) {
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("delete from book where book_id = ?");
            callSt.setInt(1, id);
            callSt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            ConnectDB.closeConnection(conn);
        }
    }
}
