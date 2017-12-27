package am.aua.dbs.dao;

import am.aua.dbs.model.Product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author Vahe Pezeshkian
 *         November 16, 2017
 */
public class ProductDaoMySQL implements ProductDao {

    private Connection connection;

    public ProductDaoMySQL() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            connection = DriverManager.getConnection("JDBC_URL","USERNAME","PASSWORD");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Product get(String id) {
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM Products WHERE id = " + id);

            if (resultSet.next()) {
                Product product = new Product();
                product.setId(resultSet.getString("id"));
                // ...
                return product;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public Product insert(Product product) {
        try {
            Statement statement = connection.createStatement();
            boolean result = statement.execute("INSERT INTO...");    // TODO implement

            if (!result) {
                System.out.println("What the failure");     // TODO handle exception
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
