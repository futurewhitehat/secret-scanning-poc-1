import com.mongodb.client.*;
import org.bson.Document;

public class MongoDBExample {

    // Replace with your MongoDB URI
    private static final String MONGO_URI = "mongodb+srv://${mongo_user}:${mongo_pass}@cluster0.mongodb.net/?retryWrites=true&w=majority";

    // Replace with your DB and collection names
    private static final String DB_NAME = "testdb";
    private static final String COLLECTION_NAME = "testcollection";

    public static void main(String[] args) {
        // Create MongoDB client
        try (MongoClient mongoClient = MongoClients.create(MONGO_URI)) {

            // Access the database
            MongoDatabase database = mongoClient.getDatabase(DB_NAME);

            // Access the collection
            MongoCollection<Document> collection = database.getCollection(COLLECTION_NAME);

            // Read and print documents
            FindIterable<Document> documents = collection.find();

            System.out.println("Documents in collection:");
            for (Document doc : documents) {
                System.out.println(doc.toJson());
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
