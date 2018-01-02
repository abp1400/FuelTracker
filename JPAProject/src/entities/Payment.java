package entities;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="payment")
public class Payment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="store_name")
	private String storeName;
	
	private String address;
	
	private String grade;
	
	private double gallon;
	
	@Column(name="price_per_gallon")
	private double pricePerGallon;
	
	@Column(name="total_price")
	private double totalPrice;
	
	private Date date;

	public String getStoreName() {
		return storeName;
	}

	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public double getGallon() {
		return gallon;
	}

	public void setGallon(double gallon) {
		this.gallon = gallon;
	}

	public double getPricePerGallon() {
		return pricePerGallon;
	}

	public void setPricePerGallon(double pricePerGallon) {
		this.pricePerGallon = pricePerGallon;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Payment [id=" + id + ", storeName=" + storeName + ", address=" + address + ", grade=" + grade
				+ ", gallon=" + gallon + ", pricePerGallon=" + pricePerGallon + ", totalPrice=" + totalPrice + ", date="
				+ date + "]";
	}
	
	

}
