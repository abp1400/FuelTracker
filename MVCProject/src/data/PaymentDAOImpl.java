package data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.fasterxml.jackson.databind.ObjectMapper;

import entities.Payment;

@Transactional
@Repository
public class PaymentDAOImpl implements PaymentDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public List<Payment> index() {
		List<Payment> p = new ArrayList<>();
		String query = "SELECT p from Payment p";
		p = em.createQuery(query, Payment.class).getResultList();
		return p;
	}

	@Override
	public Payment show(int id) {
		return em.find(Payment.class, id);
	}

	@Override
	public Payment create(String json) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Payment newPayment = mapper.readValue(json, Payment.class);
			em.persist(newPayment);
			em.flush();
			return newPayment;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public Boolean delete(int id) {
		Payment p = em.find(Payment.class, id);
		em.remove(p);
		if (em.find(Payment.class, id) == null) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Payment update(String json, int id) {
		ObjectMapper mapper = new ObjectMapper();
		try {
			Payment pprime = mapper.readValue(json, Payment.class);
			Payment managed = em.find(Payment.class, id);
			managed.setStoreName(pprime.getStoreName());
			managed.setAddress(pprime.getAddress());
			managed.setGrade(pprime.getGrade());
			managed.setGallon(pprime.getGallon());
			managed.setPricePerGallon(pprime.getPricePerGallon());
			managed.setTotalPrice(pprime.getTotalPrice());
			managed.setDate(pprime.getDate());		
			return managed;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}	
	}

}
