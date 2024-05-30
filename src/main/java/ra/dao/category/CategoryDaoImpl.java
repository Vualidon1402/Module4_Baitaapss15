package ra.dao.category;

import ra.model.Category;
import ra.util.ConnectDB;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CategoryDaoImpl implements ICategoryDao {
    @Override
    public List<Category> findAll() {
        List<Category> categories = new ArrayList<>();
        // mo 1 ket noi
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("select * from category");
            //thuc thi sql
            ResultSet rs = callSt.executeQuery(); // thuc thi cau lenh select
            while (rs.next()){
                Category category = new Category(
                        rs.getInt("category_id"),
                        rs.getString("category_name"),
                        rs.getBoolean("category_status")
                ) ;
                categories.add(category);
            }
            return categories;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }

    }

    @Override
    public List<Category> searchByName(String keyword) {
        List<Category> categories = new ArrayList<>();
        // mo 1 ket noi
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("select * from category like ?}");
            // truyen tham so
            callSt.setString(1,keyword);
            // thuc thi sql
            ResultSet rs = callSt.executeQuery(); // thuc thi cau lenh select
            if (rs.next()){
                Category category = new Category(
                        rs.getInt("category_id"),
                        rs.getString("category_name"),
                        rs.getBoolean("category_status")
                ) ;
                categories.add(category);
            }
            return categories;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public Category findById(Integer id) {
        Category category = null;
        // mo 1 ket noi
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("select * from category where category_id =?");
            // truyen tham so
            callSt.setInt(1,id);
            // thuc thi sql
            ResultSet rs = callSt.executeQuery(); // thuc thi cau lenh select
            if (rs.next()){
                category = new Category(
                        rs.getInt("category_id"),
                        rs.getString("category_name"),
                        rs.getBoolean("category_status")
                ) ;
            }
            return category;
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
    }

    @Override
    public void save(Category category) {
        // mo 1 ket noi
        Connection conn = ConnectDB.getConnection();
        PreparedStatement callSt = null;
        try {
            if (category.getCategoryId()==null){
                callSt = conn.prepareStatement("insert into category(category_name, category_status) value (?,?)");
                callSt.setString(1,category.getCategoryName());
                callSt.setBoolean(2,category.isCategoryStatus());
            }else {
                callSt = conn.prepareCall("update  category set category_name =?, category_status=? where category_id = ?");
                callSt.setString(1,category.getCategoryName());
                callSt.setBoolean(2,category.isCategoryStatus());
                callSt.setInt(3,category.getCategoryId());
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
        // mo 1 ket noi
        Connection conn = ConnectDB.getConnection();
        try {
            CallableStatement callSt = conn.prepareCall("delete from category where category_id = ?");
            // truyen tham so
            callSt.setInt(1,id);
            // thuc thi sql
            callSt.executeUpdate(); // thuc thi cau lenh delete
        }catch (SQLException e){
            throw new RuntimeException(e);
        }finally {
            ConnectDB.closeConnection(conn);
        }
    }


    }






