package am.aua.dbs;

import am.aua.dbs.dao.OrderDaoMongo;
import am.aua.dbs.model.Order;
import am.aua.dbs.model.Product;

import java.util.Date;

/**
 * @author Vahe Pezeshkian
 *         November 16, 2017
 */
public class OrdersApp {
    public static void main(String[] args) {

        Product coffee = new Product();
        coffee.setId("1");
        coffee.setCategory("Beverage");
        coffee.setName("Espresso");
        coffee.setPrice(200);

        Order order = new Order();
        order.setId("1");
        order.setOrderDate(new Date());
        order.setProduct(coffee);

        OrderDaoMongo orderDaoMongo = new OrderDaoMongo();
        orderDaoMongo.insert(order);
    }
}
