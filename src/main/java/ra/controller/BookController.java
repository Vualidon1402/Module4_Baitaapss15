package ra.controller;

import ra.model.Book;
import ra.model.Category;
import ra.service.BookServiceImpl;
import ra.service.CategoryServiceImpl;
import ra.service.IBookService;
import ra.service.ICategoryService;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;
import java.util.List;

@WebServlet(name = "BookController", value = "/book")
public class BookController extends HttpServlet {
    private static final IBookService bookService = new BookServiceImpl();
    private static final ICategoryService categoryService = new CategoryServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "LIST":

                    List<Book> bookData = bookService.findAll();
                    request.setAttribute("books", bookData);
                    System.out.println("bookData: " + bookData);
                    request.getRequestDispatcher("/WEB-INF/views/book/list-book.jsp")
                            .forward(request, response);

                    break;

                case "DELETE":
                    Integer idDel = Integer.valueOf(request.getParameter("id"));
                    bookService.deleteById(idDel);
                    response.sendRedirect("/book?action=LIST");
                    break;
                case "ADD":
                    List<Category> categories = categoryService.findAll();
                    request.setAttribute("category", categories);
                    request.getRequestDispatcher("/WEB-INF/views/book/add-book.jsp").forward(request, response);
                    break;
                case "EDIT":
                    Integer idEdit = Integer.valueOf(request.getParameter("id"));
                    request.setAttribute("book", bookService.findById(idEdit));
                    request.getRequestDispatcher("/WEB-INF/views/book/edit-book.jsp").forward(request, response);
                    break;
                case "SEARCH":
                    String keyword = request.getParameter("keyword");
                    request.setAttribute("books", bookService.searchByName(keyword));
                    request.setAttribute("keyword", keyword);
                    request.getRequestDispatcher("/WEB-INF/views/book/list-book.jsp").forward(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "ADD":
                    Book book = getBookFromRequest(request);
                    bookService.save(book);
                    response.sendRedirect("/book?action=LIST");
                    break;
                case "UPDATE":
                    Integer idEdit = Integer.valueOf(request.getParameter("id"));
                    Book b = getBookFromRequest(request);
                    b.setBookId(idEdit);

                    bookService.save(b);
                    response.sendRedirect("/book?action=LIST");
                    break;
            }
        }
    }
    private Book getBookFromRequest(HttpServletRequest request) {
        String bookName = request.getParameter("name");
        Integer categoryId = Integer.valueOf(request.getParameter("categoryId"));
        Double bookPrice = Double.valueOf(request.getParameter("price"));
        Integer stock = Integer.valueOf(request.getParameter("stock"));
        Integer totalPages = Integer.valueOf(request.getParameter("totalPages"));
        Date yearCreated = Date.valueOf(request.getParameter("yearCreated"));
        String author = request.getParameter("author");
        Boolean bookStatus = Boolean.valueOf(request.getParameter("status"));
        return new Book(null,categoryId, bookName, bookPrice, stock, totalPages, yearCreated, author, bookStatus);
    }
}