package controllers;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import data.PaymentDAO;
import entities.Payment;


@RestController
public class PaymentController {

	@Autowired
	private PaymentDAO dao;

	@RequestMapping(path = "payments", method = RequestMethod.GET)
	public List<Payment> index() {
		return dao.index();

	}

	@RequestMapping(path = "payments/{id}", method = RequestMethod.GET)
	public Payment show(@PathVariable int id) {

		return dao.show(id);
	}

	@RequestMapping(path = "payments", method = RequestMethod.POST)
	public Payment create(@RequestBody String json, HttpServletResponse res) {
		Payment p = dao.create(json);
		if (p == null) {
			res.setStatus(400);

		} else {
			res.setStatus(201);
		}
		return p;
	}

	@RequestMapping(path = "payments/{id}", method = RequestMethod.DELETE)
	public Boolean delete(@PathVariable int id) {

		return dao.delete(id);
	}

	@RequestMapping(path = "payments/{id}", method = RequestMethod.PUT)
	public Payment update(@RequestBody String json, HttpServletResponse res, @PathVariable int id) {
		Payment p = dao.update(json, id);
		if (p == null) {
			res.setStatus(400);
		} else {
			res.setStatus(200);
		}
		return p;
	}

}
