package com.fox.alibaba.service.impl;

import org.springframework.stereotype.Service;

import com.fox.alibaba.dao.PaymentDao;
import com.fox.alibaba.pojo.Payment;
import com.fox.alibaba.service.PaymentService;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-23 14:45
* @version 1.0
*/
@Service
public class PaymentServiceImpl implements PaymentService {
	
	
	private final PaymentDao paymentDao;
	
//	@Autowired
	public PaymentServiceImpl(PaymentDao paymentDao) {
		this.paymentDao = paymentDao;
	}

	@Override
	public int create(Payment payment) {
		// TODO Auto-generated method stub
		 return paymentDao.create(payment);
	}

	@Override
	public Payment queryById(long id) {
		// TODO Auto-generated method stub
		return paymentDao.queryById(id);
	}

}

