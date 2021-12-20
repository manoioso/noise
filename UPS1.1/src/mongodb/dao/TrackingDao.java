package mongodb.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.bson.Document;
import org.bson.types.ObjectId;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.model.Filters;

import mongodb.connection.MongoConnection;
import mongodb.converter.TrackingConverter;
import mongodb.model.Tracking;

public class TrackingDao {
    private MongoCollection<Document> coll;

    @SuppressWarnings("unchecked")
	public TrackingDao() throws IOException {
        this.coll = MongoConnection.getInstance().getTrackingColl();
    }

    public Tracking create(Tracking p) {
        Document doc = TrackingConverter.toDocument(p);
        this.coll.insertOne(doc);
        ObjectId id = (ObjectId) doc.get("_id");
        p.setId(id.toString());
        return p;
    }

    public void update(Tracking p) {
        this.coll.updateOne(Filters.eq("_id", new ObjectId(p.getId())), new Document("$set", TrackingConverter.toDocument(p)));
    }

    public void delete(String id) {
        this.coll.deleteOne(Filters.eq("_id", new ObjectId(id)));
    }

    public boolean exists(String id) {
        FindIterable<Document>  doc = this.coll.find(Filters.eq("_id", id)).limit(1);
        return doc != null;
    }

    public List<Tracking> getList() {
        List<Tracking> list = new ArrayList<Tracking>();
        MongoCursor<Document>  cursor = coll.find().iterator();
        try {
            while (cursor.hasNext()) {
                Document doc = cursor.next();
                Tracking p = TrackingConverter.toProduct(doc);
                list.add(p);
            }
        } finally {
            cursor.close();
        }
        return list;
    }

    public Tracking getProduct(String id) {
        Document doc = this.coll.find(Filters.eq("_id", new ObjectId(id))).first();
        return TrackingConverter.toProduct(doc);
    }
}
