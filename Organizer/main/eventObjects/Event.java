package eventObjects;

import java.io.Serializable;
import java.util.Date;
import java.util.Random;

@SuppressWarnings("serial")
public class Event implements Serializable{
	
	
	private Date date;
	private String marker;
	private String description;
	private String type;
	private int identificationNumber;
	
	public Event(){
		this.identificationNumber = new Random().nextInt((99999)+5000);
	}
	public int getIdentificationNumber() {
		return this.identificationNumber;
	}
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}
	public String getMarker() {
		return marker;
	}
	public void setMarker(String marker) {
		this.marker = marker;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
