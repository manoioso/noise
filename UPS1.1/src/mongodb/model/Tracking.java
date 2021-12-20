package mongodb.model;

public class Tracking {
    private String id;
    private String name;
    private double price;
    private String TrackingNumber;
    private String city;
    private String Broker;

	public String getBroker() {
		return Broker;
	}

	public void setBroker(String broker) {
		Broker = broker;
	}

    public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}


	public String getTrackingNumber() {
		return TrackingNumber;
	}

	public void setTrackingNumber(String trackingNumber) {
		TrackingNumber = trackingNumber;
	}

	public Tracking() {}

    public Tracking(String id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
