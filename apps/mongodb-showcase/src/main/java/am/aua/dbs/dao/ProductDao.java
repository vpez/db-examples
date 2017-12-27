package am.aua.dbs.dao;

import am.aua.dbs.model.Product;

/**
 * @author Vahe Pezeshkian
 *         November 16, 2017
 */
public interface ProductDao {
    Product get(String id);
    Product insert(Product product);
}
