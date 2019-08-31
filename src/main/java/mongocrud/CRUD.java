package mongocrud;

import java.util.Iterator;

import org.bson.Document;
import org.bson.conversions.Bson;

import com.mongodb.MongoClient;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;

public class CRUD {
	
	static MongoClient mongo;
	static MongoDatabase db;
	static MongoCollection<Document> collection;
	
	static void connectMongo()
	{
		mongo = new MongoClient("localhost", 27017);
		db = mongo.getDatabase("mongocrudtest");
		collection = db.getCollection("users");
	}
	
	static void Insert()
	{
		User user = createUser();
		collection.insertOne(createDoc(user));
	}
	
	static void FindAll()
	{ 
		FindIterable<Document> iterDoc = collection.find(); 
		Iterator<Document> it = iterDoc.iterator();
		while (it.hasNext()) 
		{  
			System.out.println(it.next()); 
		}
	}
	
	static void Update(int id)
	{
		Bson filter = new Document("id", id);   
		Bson newValue = new Document("role", "Java Developer").append("isEmployee", true);      
		Bson updateOperationDocument = new Document("$set", newValue);
		collection.updateOne(filter, updateOperationDocument);
		//collection.updateOne(Filters.eq("id", id), Updates.set("role", "Software Developer"));
	}
	
	static void Find(int id)
	{
		FindIterable<Document> iterDoc = collection.find(Filters.eq("id", id));
		for(Document doc : iterDoc)
		{
			System.out.println(doc);
		}
	}
	
	static void Delete(int id)
	{
		collection.deleteOne(Filters.eq("id", id));
	}
	
	static void DeleteAll()
	{
		collection.deleteMany(new Document());
	}
	
	public static void main(String[] args) {
		int val=3;
		int id=1;
		connectMongo();
		switch (val) {
		case 1:
			Insert();
			break;
		case 2:
			Find(id);
			break;
		case 3:
			Update(id);
			break;
		case 4:
			Delete(id);
			break;
		case 5:
			DeleteAll();
			break;
		default:
			break;
		}
		FindAll();
		mongo.close();
		System.out.println("Done...");
		/*User user = createUser();
		DBObject doc = createDBObject(user);
		
		MongoClient mongo = new MongoClient("localhost", 27017);
		DB db = mongo.getDB("journaldev");
		
		DBCollection col = db.getCollection("users");
		
		//create user
		WriteResult result = col.insert(doc);
		System.out.println(result.getUpsertedId());
		System.out.println(result.getN());
		System.out.println(result.isUpdateOfExisting());
		System.out.println(result.getLastConcern());
		
		//read example
		DBObject query = BasicDBObjectBuilder.start().add("_id", user.getId()).get();
		DBCursor cursor = col.find(query);
		while(cursor.hasNext()){
			System.out.println(cursor.next());
		}
		
		//update example
		user.setName("Pankaj Kumar");
		doc = createDBObject(user);
		result = col.update(query, doc);
		System.out.println(result.getUpsertedId());
		System.out.println(result.getN());
		System.out.println(result.isUpdateOfExisting());
		System.out.println(result.getLastConcern());
		
		//delete example
		result = col.remove(query);
		System.out.println(result.getUpsertedId());
		System.out.println(result.getN());
		System.out.println(result.isUpdateOfExisting());
		System.out.println(result.getLastConcern());
		
		//close resources
		mongo.close();*/
	}

	private static Document createDoc(User user) {
		Document doc = new Document();
		doc.put("id", user.getId());
		doc.put("name", user.getName());
		doc.put("role", user.getRole());
		doc.put("isEmployee", user.isEmployee());
		return doc;
		/*BasicDBObjectBuilder docBuilder = BasicDBObjectBuilder.start();
								
		docBuilder.append("_id", user.getId());
		docBuilder.append("name", user.getName());
		docBuilder.append("role", user.getRole());
		docBuilder.append("isEmployee", user.isEmployee());
		return docBuilder.get();*/
	}

	private static User createUser() {
		User user = new User(1,"Yash","Java Devloper",true);
		return user;
	}
}
