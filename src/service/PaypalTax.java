package service;

public class PaypalTax implements OnlinePaymentService {

	@Override
	public Double paymentFree(Double amount) {
		return amount + 0.02 * amount;
	}

	@Override
	public Double interest(Double amount, Integer months) {

		return amount + amount * 0.01 * months;

	}
}
