package mongodb.connection;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

public class MongoConnection {
	
    // singleton old skool :-)
    private static MongoConnection instance = null;
    private MongoClient mongoClient;
    private MongoDatabase database;
    private Properties props;
   
	@SuppressWarnings("rawtypes")
	private MongoCollection trackingColl;

    
    @SuppressWarnings("rawtypes")
	public MongoCollection getTrackingColl() {
		return this.trackingColl;
	}

	//private constructor to avoid client applications to use constructor
    private MongoConnection() throws IOException  {
    	
    	InputStream s =getClass().getResourceAsStream("/config.properties");
    	props = new Properties();
    	props.load(s);
    	
    	
        this.mongoClient = new MongoClient(
            new MongoClientURI(
            	props.getProperty("atlas_uri")
            )

        );

        this.database = this.mongoClient.getDatabase(props.getProperty("db"));
        this.trackingColl = this.database.getCollection(props.getProperty("tracking_collection"));
    }

    public static MongoConnection getInstance() throws IOException{
        if(instance == null){
            synchronized (MongoConnection.class) {
                if(instance == null){
                    instance = new MongoConnection();
                }
            }
        }
        return instance;
    }
    


    public MongoClient getMongoClient() {
        return this.mongoClient;
    }


    public MongoDatabase getDatabase() {
        return this.database;
    }
    
}