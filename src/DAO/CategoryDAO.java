package DAO;

import Model.Category;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Used to store ,update and delete information of categories in the database.
 *
 */
public class CategoryDAO{
    /**
     * Adds the category in the database.
     * @param c category to be added.
     */
    public static void addCategory(Category c)
    {
        Connection connection = DBConnector.getConnection();

        if(c.getParentID() <= 0) {
            String Query = "Insert Into category(id,cname,des) values(?,?,?);";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(Query);
                preparedStatement.setInt(1,c.getId());
                preparedStatement.setString(2, c.getName());
                preparedStatement.setString(3,c.getDescription());
                preparedStatement.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        else
        {
            String Query = "Insert Into category(id,cname,des,parentId) values(?,?,?,?);";
            try {
                PreparedStatement preparedStatement = connection.prepareStatement(Query);
                preparedStatement.setInt(1,c.getId());
                preparedStatement.setString(2, c.getName());
                preparedStatement.setString(3,c.getDescription());
                preparedStatement.setInt(4,c.getParentID());
                preparedStatement.executeUpdate();
                connection.close();
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }

    }

    /**
     * Updates the information of category in the database.
     * @param c category to be updated.
     */
    public static void updateCategory(Category c)
    {
        Connection connection = DBConnector.getConnection();
        String query = "UPDATE category set cname = ?,des = ?,parentId = ? where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, c.getName());
            preparedStatement.setString(2,c.getDescription());
            if(c.getParentID() > 0)
            {
                preparedStatement.setInt(3,c.getParentID());

            }
            else
            {
                preparedStatement.setNull(3, java.sql.Types.INTEGER);
            }
            preparedStatement.setInt(4,c.getId());
            int count = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * Deletes the category from database.
     * @param id id of category.
     */
    public static void deleteCategory(int id)
    {
        Connection connection = DBConnector.getConnection();
        String Query = "DELETE from category where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Get all the categories in the database.
     * @return list of categories.
     */
    public static List<Category> getAllCategory()
    {
        List<Category> categories = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        String Query = "Select * from category;";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Query);
            while (resultSet.next())
            {
                Category c = new Category(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getInt(4));
                categories.add(c);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return categories;
    }

    /**
     * Get the name of particular category.
     * @param cid id of category.
     * @return name of category.
     */
    public static String getName(int cid)
    {
        Connection connection = DBConnector.getConnection();
        String Query = "select cname from category where id = ?;";
        String name = "";
        try {
            PreparedStatement ps = connection.prepareStatement(Query);
            ps.setInt(1,cid);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next())
            {
                return resultSet.getString("cname");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return name;
    }

    /**
     * Gets all the subcategories of a category
     * @param id id of category.
     * @return list of id's of sub categories.
     */
    public static List<Integer> getAllChilds( int id)
    {
        {
            List<Integer> subcategoryIds = new ArrayList<>();
                // Establish the database connection
            Connection connection = DBConnector.getConnection();
            String sql = "WITH RECURSIVE Subcategories AS ("
                            + "  SELECT id, cname, des, parentId"
                            + "  FROM category"
                            + "  WHERE id = ?"
                            + "  UNION ALL"
                            + "  SELECT c.id, c.cname, c.des, c.parentId"
                            + "  FROM category c"
                            + "  JOIN Subcategories s ON c.parentId = s.id"
                            + ")"
                            + "SELECT id FROM Subcategories WHERE id != ?";
            try  {
                PreparedStatement preparedStatement = connection.prepareStatement(sql);
                preparedStatement.setInt(1, id);
                preparedStatement.setInt(2, id);
                ResultSet resultSet = preparedStatement.executeQuery();
                while (resultSet.next()) {
                    int subcategoryId = resultSet.getInt("id");
                    subcategoryIds.add(subcategoryId);
                 }
            } catch (  SQLException e) {
                e.printStackTrace();
            }

            return subcategoryIds;
        }
    }

    /**
     *Get the id of category by name.
     * @param n name of category.
     * @return id of category.
     */

    public static int getID(String n)
    {
        Connection connection = DBConnector.getConnection();
        String Query = "select id from category where cname = ?;";
        String name = "";
        try {
            PreparedStatement ps = connection.prepareStatement(Query);
            ps.setString(1,n);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next())
            {
                return resultSet.getInt("id");
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    /**
     * Check the id of category in the database.
     * @param cid id of category.
     * @return true if it is present in the database.
     */
    public static boolean checkID(int cid)
    {
        Connection connection = DBConnector.getConnection();
        String Query = "select id from category where id = ?;";
        String name = "";
        try {
            PreparedStatement ps = connection.prepareStatement(Query);
            ps.setInt(1,cid);
            ResultSet resultSet = ps.executeQuery();
            if (resultSet.next())
            {
                return true;
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return false;
    }

}
