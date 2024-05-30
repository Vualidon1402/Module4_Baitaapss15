package ra.controller;

import ra.model.Category;
import ra.service.CategoryServiceImpl;
import ra.service.ICategoryService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CategoryController", value = "/category")
public class CategoryController extends HttpServlet {
    private static final ICategoryService categoryService = new CategoryServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "LIST":
                    // hiển thị danh sáchkii
                    request.setAttribute("categories", categoryService.findAll());
                    request.getRequestDispatcher("/WEB-INF/views/category/list-category.jsp")
                            .forward(request, response);
                    break;
                case "DELETE":
                    // lấy id
                    Integer idDel = Integer.valueOf(request.getParameter("id"));
                    // tiến hành xóa

                    categoryService.deleteById(idDel);

                    response.sendRedirect("/category?action=LIST");
                    break;
                case "ADD":
                    request.getRequestDispatcher("/WEB-INF/views/category/add-category.jsp").forward(request, response);
                    break;
                case "EDIT":
                    // lấy ra id
                    Integer idEdit = Integer.valueOf(request.getParameter("id"));
                    request.setAttribute("category", categoryService.findById(idEdit));
                    request.getRequestDispatcher("/WEB-INF/views/category/edit-category.jsp").forward(request, response);
                    break;
                case "SEARCH":
                    String keyword = request.getParameter("keyword");
                    request.setAttribute("categories", categoryService.searchByName(keyword));
                    request.setAttribute("keyword", keyword);
                    request.getRequestDispatcher("/WEB-INF/views/list-category.jsp").forward(request, response);
                    break;
            }
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // set uft-8
        request.setCharacterEncoding("UTF-8");
        String action = request.getParameter("action");
        if (action != null) {
            switch (action) {
                case "ADD":
                    Category category = getCategoryFromRequest(request);
                    categoryService.save(category);

                    response.sendRedirect("/category?action=LIST");
                    break;
                case "UPDATE":
                    Integer idEdit = Integer.valueOf(request.getParameter("id"));
                    Category categoryEdit = getCategoryFromRequest(request);
                    categoryEdit.setCategoryId(idEdit);
                    categoryService.save(categoryEdit);
                    response.sendRedirect("/category?action=LIST");
                    break;
            }
        }
    }

    private Category getCategoryFromRequest(HttpServletRequest request) {
        String categoryName = request.getParameter("name");
        boolean categoryStatus = Boolean.parseBoolean(request.getParameter("status"));
        System.out.println("categoryName: " + categoryName + " categoryStatus: " + categoryStatus);
        return new Category(null, categoryName, categoryStatus);
    }
}
