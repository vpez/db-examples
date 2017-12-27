package am.aua.dbs.dao;

import am.aua.dbs.model.Order;
import com.google.gson.Gson;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @author Vahe Pezeshkian
 *         November 16, 2017
 */
public class OrderDaoMongo {
    private MongoDatabase db;

    public OrderDaoMongo() {
        MongoClient mongoClient = new MongoClient();
        db = mongoClient.getDatabase("MongoPlay");
    }

    public Order insert(Order order) {
        Gson gson = new Gson();
        Document document = Document.parse(gson.toJson(order));
        db.getCollection("orders").insertOne(document);
        return order;
    }
}
