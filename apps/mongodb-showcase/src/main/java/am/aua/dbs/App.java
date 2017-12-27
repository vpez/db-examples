package am.aua.dbs;

import am.aua.dbs.dao.ProductDao;
import am.aua.dbs.dao.ProductDaoMongo;
import am.aua.dbs.model.Product;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) {

        Product product = new Product();
        product.setId("2");
        product.setName("Tea");
        product.setCategory("Beverage");
        product.setPrice(300);

        ProductDao productDao = new ProductDaoMongo();
        productDao.insert(product);
    }
}
