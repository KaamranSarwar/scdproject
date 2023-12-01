package DAO;

import Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    public static void addProduct(Product p )
    {
        Connection connection = DBConnector.getConnection();
        String Query = "Insert Into product(id,pname,price,QinP,tP,totalQuantity,expDate,des,cId) values(?,?,?,?,?,?,?,?,?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            preparedStatement.setInt(1,p.getId());
            preparedStatement.setString(2, p.getName());
            preparedStatement.setDouble(3,p.getPrice());
            preparedStatement.setInt(4,p.getQuantityInPack());
            preparedStatement.setInt(5,p.getTotalPacks());
            preparedStatement.setInt(6,p.getTotalQuantity());
            preparedStatement.setDate(7,new  java.sql.Date(p.getExpDate().getTime()));
            preparedStatement.setString(8,p.getDescription());
            preparedStatement.setInt(9,p.getCategoryID());
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void deleteProduct(int id)
    {
        Connection connection = DBConnector.getConnection();
        String Query = "DELETE from product where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void deleteSoldProducts()
    {
        Connection connection = DBConnector.getConnection();
        String Query = "DELETE from product where totalQuantity = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(Query);
            preparedStatement.setInt(1,0);
            preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    public static void updateProduct(Product p)
    {
        Connection connection = DBConnector.getConnection();
        String query = "UPDATE product set pname = ?,price = ?,QinP = ?,tP=?,totalQuantity=?,des = ?,cId = ? where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, p.getName());
            preparedStatement.setDouble(2,p.getPrice());
            preparedStatement.setInt(3,p.getQuantityInPack());
            preparedStatement.setInt(4,p.getTotalPacks());
            preparedStatement.setInt(5,p.getTotalQuantity());
            preparedStatement.setString(6,p.getDescription());
            preparedStatement.setInt(7,p.getCategoryID());
            preparedStatement.setInt(8,p.getId());
            int count = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static void updateProductQuantity(int totalPacks,int total,int pid)
    {
        Connection connection = DBConnector.getConnection();
        String query = "UPDATE product set tP=?,totalQuantity=? where id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, totalPacks);
            preparedStatement.setInt(2,total);
            preparedStatement.setInt(3,pid);
            int count = preparedStatement.executeUpdate();
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }
    public static boolean checkID(int cid)
    {
        Connection connection = DBConnector.getConnection();
        String Query = "select id from product where id = ?;";
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
    public static List<Product> getAllProducts()
    {
        List<Product> products = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        String Query = "Select * from product;";
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(Query);
            while (resultSet.next())
            {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int QperP = resultSet.getInt(4);
                int TotalPacket = resultSet.getInt(5);
                int total = resultSet.getInt(6);
                java.util.Date date = resultSet.getDate(7);
                String des = resultSet.getString(8);
                int Category = resultSet.getInt(9);
                Product p = new Product(id,name,price,QperP,TotalPacket,total,date,des,Category);
                products.add(p);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public static List<Product> getProductsByName(String productName) {
        List<Product> products = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        String query = "SELECT * FROM product WHERE pname LIKE ?";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + productName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int QperP = resultSet.getInt(4);
                int TotalPacket = resultSet.getInt(5);
                int total = resultSet.getInt(6);
                java.util.Date date = resultSet.getDate(7);
                String des = resultSet.getString(8);
                int Category = resultSet.getInt(9);
                Product p = new Product(id, name, price, QperP, TotalPacket, total, date, des, Category);
                products.add(p);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    public static List<Product> getProductsByCategoryAndSubcategories(String categoryName) {
        List<Product> products = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        String query = "WITH RECURSIVE subcategories AS (\n" +
                "    SELECT id FROM category WHERE cname LIKE ?\n" +
                "    UNION ALL\n" +
                "    SELECT c.id FROM category c\n" +
                "    INNER JOIN subcategories sc ON c.parentId = sc.id\n" +
                ")\n" +
                "SELECT p.* FROM product p\n" +
                "JOIN subcategories s ON p.cid = s.id";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, "%" + categoryName + "%");
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String name = resultSet.getString(2);
                double price = resultSet.getDouble(3);
                int QperP = resultSet.getInt(4);
                int TotalPacket = resultSet.getInt(5);
                int total = resultSet.getInt(6);
                java.util.Date date = resultSet.getDate(7);
                String des = resultSet.getString(8);
                int category = resultSet.getInt(9); // Update this index to match the category ID column
                Product p = new Product(id, name, price, QperP, TotalPacket, total, date, des, category);
                products.add(p);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
        public static void moveExpiredProducts() {
            try (Connection connection = DBConnector.getConnection()) {
                String selectExpiredProductsQuery = "SELECT * FROM product WHERE expDate <= CURDATE()";

                // Fetch expired products
                try (PreparedStatement selectStatement = connection.prepareStatement(selectExpiredProductsQuery)) {
                    try (ResultSet resultSet = selectStatement.executeQuery()) {
                        while (resultSet.next()) {
                            int productId = resultSet.getInt("id");
                            String productName = resultSet.getString("pname");
                            double price = resultSet.getDouble("price");
                            String expiredDate = resultSet.getString("expDate");
                            String description = resultSet.getString("des");

                            // Insert expired product into expired_products table
                            insertIntoExpiredProducts(connection, productId, productName, price, expiredDate, description);

                            // Delete expired product from product table
                            deleteExpiredProduct(connection, productId);
                        }
                    }
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        // Method to insert expired product into expired_products table
        private static void insertIntoExpiredProducts(Connection connection, int productId, String productName,
                                                      double price, String expiredDate, String description) throws SQLException {
            String insertQuery = "INSERT INTO expired_products (id, pname, price, expired_date, description) VALUES (?, ?, ?, ?, ?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setInt(1, productId);
                insertStatement.setString(2, productName);
                insertStatement.setDouble(3, price);
                insertStatement.setString(4, expiredDate);
                insertStatement.setString(5, description);
                insertStatement.executeUpdate();
            }
        }

        // Method to delete expired product from product table
        private static void deleteExpiredProduct(Connection connection, int productId) throws SQLException {
            String deleteQuery = "DELETE FROM product WHERE id = ?";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                deleteStatement.setInt(1, productId);
                deleteStatement.executeUpdate();
            }
        }
}
