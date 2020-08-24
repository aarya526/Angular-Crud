package com.crud.service;

import com.crud.model.PaymentCallback;
import com.crud.model.PaymentDetail;

public interface PaymentService {

	PaymentDetail proceedPayment(PaymentDetail paymentDetail);

	String payuCallback(PaymentCallback paymentResponse);

	void savePaymentDetail(PaymentDetail paymentDetail);

}
