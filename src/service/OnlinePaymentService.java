package service;

public interface OnlinePaymentService {
	
	public Double paymentFree(Double amount);
	public Double interest(Double amount, Integer months);

}
