package DAO;

import Model.Product;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
    /**
     * Adds a new product to the database.
     *
     * @param p The Product object to be added
     * @throws RuntimeException if there's an issue executing the SQL query
     */
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
    /**
     * Retrieves products with a low quantity (less than or equal to 50) from the database.
     *
     * @return A list of Product objects with low quantities
     * @throws RuntimeException if there's an issue executing the SQL query
     */
    public static List<Product> getLowQuantityProducts() {
        List<Product> products = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        String query = "SELECT * FROM product WHERE totalQuantity <= 50";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
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
                Product product = new Product(id, name, price, QperP, TotalPacket, total, date, des, Category);
                products.add(product);
            }
            connection.close();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    /**
     * Deletes a product from the database based on the given ID.
     *
     * @param id The ID of the product to be deleted
     * @throws RuntimeException if there's an issue executing the SQL query
     */
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
    /**
     * Deletes products with zero total quantity from the database.
     *
     * @throws RuntimeException if there's an issue executing the SQL query
     */
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
    /**
     * Updates product details in the database.
     *
     * @param p The Product object with updated details
     * @throws RuntimeException if there's an issue executing the SQL query
     */
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
    /**
     * Updates product quantity details in the database.
     *
     * @param totalPacks  The updated total packs
     * @param total       The updated total quantity
     * @param pid         The ID of the product to be updated
     * @throws RuntimeException if there's an issue executing the SQL query
     */
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
    /**
     * Checks if a product ID exists in the database.
     *
     * @param cid The ID of the product to check
     * @return {@code true} if the ID exists, {@code false} otherwise
     * @throws RuntimeException if there's an issue executing the SQL query
     */
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
    /**
     * Retrieves all products from the database.
     *
     * @return A list containing all Product objects retrieved from the database
     * @throws RuntimeException if there's an issue executing the SQL query
     */
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
    /**
     * Retrieves products by name from the database.
     *
     * @param productName The name of the product or a partial name to search for
     * @return A list containing Product objects with names similar to the provided name
     * @throws RuntimeException if there's an issue executing the SQL query
     */
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
    /**
     * Retrieves products from a specific category and its subcategories.
     *
     * @param categoryName The name or part of the name of the category
     * @return A list of products belonging to the specified category and its subcategories
     * @throws RuntimeException if there's an issue executing the SQL query
     */
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
    /**
     * Retrieves low stock products from a specific category and its subcategories.
     *
     * @param categoryName The name or part of the name of the category
     * @return A list of low stock products from the specified category and its subcategories
     * @throws RuntimeException if there's an issue executing the SQL query
     */
    public static List<Product> getLowStockProductsByCategory(String categoryName) {
        List<Product> products = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        String query = "WITH RECURSIVE subcategories AS (\n" +
                "    SELECT id FROM category WHERE cname LIKE ?\n" +
                "    UNION ALL\n" +
                "    SELECT c.id FROM category c\n" +
                "    INNER JOIN subcategories sc ON c.parentId = sc.id\n" +
                ")\n" +
                "SELECT p.* FROM product p\n" +
                "JOIN subcategories s ON p.cid = s.id\n" +
                "WHERE p.totalQuantity <= 50"; // Add condition for low stock
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
    /**
     * Moves expired products from the product table to the expired_products table in the database.
     * Deletes the expired products from the product table.
     */
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

    /**
     * Inserts an expired product into the expired_products table.
     *
     * @param connection    The database connection
     * @param productId     The ID of the expired product
     * @param productName   The name of the expired product
     * @param price         The price of the expired product
     * @param QinP          Quantity per packet of the expired product
     * @param tP            Total packets of the expired product
     * @param totalQuantity Total quantity of the expired product
     * @param expiredDate   The date when the product expired
     * @param description   Description of the expired product
     * @param catname       The category name of the expired product
     * @throws SQLException if there's an issue executing the SQL query
     */
        private static void insertIntoExpiredProducts(Connection connection, int productId, String productName,
                                                      double price, int QinP, int tP, int totalQuantity,
                                                      Date expiredDate, String description,String catname) throws SQLException {
            String insertQuery = "INSERT INTO expired_products (id, pname, price, QinP, tP, totalQuantity, expired_date, description,cname) VALUES (?, ?, ?, ?, ?, ?, ?, ?,?)";
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
    /**
     * Deletes an expired product from the product table.
     *
     * @param connection The database connection
     * @param productId  The ID of the expired product to be deleted
     * @throws SQLException if there's an issue executing the SQL query
     */
        private static void deleteExpiredProduct(Connection connection, int productId) throws SQLException {
            String deleteQuery = "DELETE FROM pos.product WHERE id = ?";
            try (PreparedStatement deleteStatement = connection.prepareStatement(deleteQuery)) {
                deleteStatement.setInt(1, productId);
                deleteStatement.executeUpdate();
            }
        }
    /**
     * Retrieves all expired products from the 'expired_products' table.
     *
     * @return A list of all expired products
     */
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
    /**
     * Retrieves products that are near their expiry date within the next 15 days.
     *
     * @return A list of products near their expiry date
     * @throws RuntimeException if there's an issue executing the SQL query
     */
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
    /**
     * Retrieves products from a specific category and its subcategories that are near expiry within the next 15 days.
     *
     * @param categoryName The name or part of the name of the category
     * @return A list of products near expiry from the specified category and its subcategories
     * @throws RuntimeException if there's an issue executing the SQL query
     */
    public static List<Product> getProductsByCategoryNearToExpiry(String categoryName) {
        List<Product> products = new ArrayList<>();
        Connection connection = DBConnector.getConnection();
        String query = "WITH RECURSIVE subcategories AS (\n" +
                "    SELECT id FROM category WHERE cname LIKE ?\n" +
                "    UNION ALL\n" +
                "    SELECT c.id FROM category c\n" +
                "    INNER JOIN subcategories sc ON c.parentId = sc.id\n" +
                ")\n" +
                "SELECT p.* FROM product p\n" +
                "JOIN subcategories s ON p.cid = s.id\n" +
                "WHERE p.expDate <= DATE_ADD(CURDATE(), INTERVAL 15 DAY)";
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
    /**
     * Retrieves products that were deleted based on the provided category name and its subcategories.
     *
     * @param categoryName The name of the category
     * @return A list of deleted products based on the specified category and its subcategories
     * @throws RuntimeException if there's an issue executing the SQL query
     */
    public static List<Product> getDeletedProductsByCategory(String categoryName) {
        List<Product> products = new ArrayList<>();
        try (Connection connection = DBConnector.getConnection()) {
            // Fetch the category IDs for the provided category name and its subcategories
            List<Integer> categoryIds = getCategoryAndSubcategoryIds(connection, categoryName);

            // Prepare the SQL query for fetching products based on category IDs
            String productQuery = "SELECT * FROM expired_products WHERE ";

            // Include the category IDs in the query
            for (int i = 0; i < categoryIds.size(); i++) {
                if (i != 0) {
                    productQuery += " OR ";
                }
                productQuery += "cname = ?";
            }

            try (PreparedStatement productStatement = connection.prepareStatement(productQuery)) {
                // Set the category IDs as parameters in the prepared statement
                for (int i = 0; i < categoryIds.size(); i++) {
                    productStatement.setString(i + 1, CategoryDAO.getName(categoryIds.get(i)));
                }

                try (ResultSet productResultSet = productStatement.executeQuery()) {
                    while (productResultSet.next()) {
                        // Fetch product details and add them to the list
                        int productId = productResultSet.getInt("id");
                        String productName = productResultSet.getString("pname");
                        double price = productResultSet.getDouble("price");
                        int qinpack=productResultSet.getInt("QinP");
                        int totalpack=productResultSet.getInt("tp");
                        int totquantity=productResultSet.getInt("totalQuantity");
                        Date expiredDate = productResultSet.getDate("expired_date");
                        String description = productResultSet.getString("description");
                        int cid=CategoryDAO.getID(productResultSet.getString("cname"));
                        Product product = new Product(productId, productName, price,qinpack,totalpack,totquantity, expiredDate, description,cid);
                        products.add(product);
                    }
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return products;
    }
    /**
     * Retrieves the category IDs for the provided category name and its subcategories.
     *
     * @param connection   The database connection
     * @param categoryName The name of the category
     * @return A list of category IDs for the specified category and its subcategories
     * @throws SQLException if there's an issue executing the SQL query
     */
    private static List<Integer> getCategoryAndSubcategoryIds(Connection connection, String categoryName) throws SQLException {
        // Use recursive query to fetch category IDs for the provided category and its subcategories
        String categoryQuery = "WITH RECURSIVE CategoryPath AS (" +
                "    SELECT id FROM pos.category WHERE cname = ?" +
                "    UNION ALL" +
                "    SELECT c.id FROM pos.category c INNER JOIN CategoryPath cp ON cp.id = c.parentid" +
                ")" +
                "SELECT id FROM CategoryPath";

        List<Integer> categoryIds = new ArrayList<>();
        try (PreparedStatement categoryStatement = connection.prepareStatement(categoryQuery)) {
            categoryStatement.setString(1, categoryName);
            try (ResultSet categoryResultSet = categoryStatement.executeQuery()) {
                while (categoryResultSet.next()) {
                    categoryIds.add(categoryResultSet.getInt("id"));
                }
            }
        }
        return categoryIds;
    }
    /**
     * Deletes all records from the 'expired_products' table.
     */
    public static void deleteAllFromExpired() {
        try (Connection connection = DBConnector.getConnection()) {
            String deleteQuery = "DELETE FROM expired_products";

            try (PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery)) {
                preparedStatement.executeUpdate();
                System.out.println("All records deleted from expired_products table.");
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
