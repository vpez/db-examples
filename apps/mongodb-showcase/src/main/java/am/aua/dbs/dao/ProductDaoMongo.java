package am.aua.dbs.dao;

import am.aua.dbs.model.Product;
import com.google.gson.Gson;
import com.mongodb.BasicDBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

/**
 * @author Vahe Pezeshkian
 *         November 16, 2017
 */
public class ProductDaoMongo implements ProductDao {

    private MongoDatabase db;

    public ProductDaoMongo() {
        MongoClient mongoClient = new MongoClient();
        db = mongoClient.getDatabase("MongoPlay");
    }

    public Product get(String id) {
        BasicDBObject query = new BasicDBObject();
        query.put("id", id);
        Document document = db.getCollection("products").find(query).first();

        Gson gson = new Gson();
        return gson.fromJson(document.toJson(), Product.class);
    }

    public Product insert(Product product) {
        Gson gson = new Gson();
        Document document = Document.parse(gson.toJson(product).replace("id", "_id"));
        db.getCollection("products").insertOne(document);
        return product;
    }

//    public Product insert(Product product) {
//        Gson gson = new Gson();
//        Document document = Document.parse(gson.toJson(product).replace("id", "_id"));
//        db.getCollection("products").insertOne(document);
//        return product;
//    }
}
