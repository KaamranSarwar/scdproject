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
                String selectExpiredProductsQuery = "SELECT * FROM pos.product WHERE expDate <= CURDATE()";

                try (PreparedStatement selectStatement = connection.prepareStatement(selectExpiredProductsQuery)) {
                    try (ResultSet resultSet = selectStatement.executeQuery()) {
                        while (resultSet.next()) {
                            int productId = resultSet.getInt("id");
                            String productName = resultSet.getString("pname");
                            double price = resultSet.getDouble("price");
                            int QinP = resultSet.getInt("QinP");
                            int tP = resultSet.getInt("tP");
                            int totalQuantity = resultSet.getInt("totalQuantity");
                            Date expiredDate = resultSet.getDate("expDate");
                            String description = resultSet.getString("des");
                            String catname=CategoryDAO.getName(resultSet.getInt("cId"));
                            // Insert expired product into expired_products table
                            insertIntoExpiredProducts(connection, productId, productName, price, QinP, tP, totalQuantity, expiredDate, description,catname);
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
                                                      double price, int QinP, int tP, int totalQuantity,
                                                      Date expiredDate, String description,String catname) throws SQLException {
            String insertQuery = "INSERT INTO expired_products (id, pname, price, QinP, tP, totalQuantity, expired_date, description,cname) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                insertStatement.setInt(1, productId);
                insertStatement.setString(2, productName);
                insertStatement.setDouble(3, price);
                insertStatement.setInt(4, QinP);
                insertStatement.setInt(5, tP);
                insertStatement.setInt(6, totalQuantity);
                insertStatement.setDate(7, expiredDate);
                insertStatement.setString(8, description);
                insertStatement.setString(9,catname);
                insertStatement.executeUpdate();
            }
        }

        // Method to delete expired product from product table
        private static void deleteExpiredProduct(Connection connection, int productId) throws SQLException {
            String deleteQuery = "DELETE FROM pos.product WHERE id = ?";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                deleteStatement.setInt(1, productId);
                deleteStatement.executeUpdate();
            }
        }

    public static List<Product> getAllExpiredProducts() {
        List<Product> expiredProducts = new ArrayList<>();
        try (Connection connection = DBConnector.getConnection()) {
            String selectExpiredProductsQuery = "SELECT * FROM expired_products";
            try (PreparedStatement selectStatement = connection.prepareStatement(selectExpiredProductsQuery)) {
                try (ResultSet resultSet = selectStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String pname = resultSet.getString("pname");
                        double price = resultSet.getDouble("price");
                        int quantityInPack = resultSet.getInt("QinP");
                        Date expiredDate = resultSet.getDate("expired_date");
                        String description = resultSet.getString("description");
                        int totalpack=resultSet.getInt("tP");
                        int totalquantity=resultSet.getInt("totalQuantity");
                        String categoryname=resultSet.getString("cname");
                        int cid=CategoryDAO.getID(categoryname);
                        Product expiredProduct = new Product(id, pname, price, quantityInPack, totalpack, totalquantity, expiredDate, description, cid);
                        expiredProducts.add(expiredProduct);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle or log the exception appropriately
        }
        return expiredProducts;
    }
    public static List<Product> getProductsNearExpiry() {
        List<Product> nearExpiryProducts = new ArrayList<>();
        try (Connection connection = DBConnector.getConnection()) {
            String selectProductsQuery = "SELECT id, pname, price, QinP, tP, totalQuantity, expDate, des, cId FROM product WHERE expDate <= DATE_ADD(CURDATE(), INTERVAL 15 DAY)";
            try (PreparedStatement selectStatement = connection.prepareStatement(selectProductsQuery)) {
                try (ResultSet resultSet = selectStatement.executeQuery()) {
                    while (resultSet.next()) {
                        int id = resultSet.getInt("id");
                        String pname = resultSet.getString("pname");
                        double price = resultSet.getDouble("price");
                        int quantityInPack = resultSet.getInt("QinP");
                        int totalPacks = resultSet.getInt("tP");
                        int totalQuantity = resultSet.getInt("totalQuantity");
                        Date expDate = resultSet.getDate("expDate");
                        String description = resultSet.getString("des");
                        int categoryId = resultSet.getInt("cId");
                        Product product = new Product(id, pname, price, quantityInPack, totalPacks, totalQuantity, expDate, description, categoryId);
                        nearExpiryProducts.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return nearExpiryProducts;
    }

}
