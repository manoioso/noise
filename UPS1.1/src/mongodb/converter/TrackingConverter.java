package mongodb.converter;

import org.bson.Document;
import org.bson.types.ObjectId;

import mongodb.model.Tracking;

public class TrackingConverter {

    // convert Tracking Object to MongoDB Document
    public static Document toDocument(Tracking p) {
        Document doc = new Document("name", p.getName()).append("price", p.getPrice());
        if (p.getId() != null) {
            doc.append("_id", new ObjectId(p.getId()));
        }
        return doc;
    }

    // convert MongoDB Document to Tracking
    public static Tracking toProduct(Document doc) {
        Tracking p = new Tracking();
        p.setName((String) doc.get("name"));
        p.setPrice((Double) doc.get("price"));
        p.setId(((ObjectId) doc.get("_id")).toString());
        p.setTrackingNumber((String) doc.get("TrackingNumber"));
        p.setCity((String) doc.get("city"));
        p.setBroker((String) doc.get("Broker"));
        return p;
    }

}