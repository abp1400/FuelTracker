package data;

import java.util.List;

import entities.Payment;

public interface PaymentDAO {

	public List<Payment> index();
	public Payment show(int id);
	public Payment create(String json);
	public Boolean delete(int id);
	public Payment update(String json, int id);

}
