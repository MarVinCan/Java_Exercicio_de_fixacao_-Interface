package service;

import java.util.Calendar;
import java.util.Date;

import entities.Contract;
import entities.Installment;

public class ContractService {

	private OnlinePaymentService oPS;
	private Contract contract;

	public ContractService() {
	}

	public ContractService(Contract contract,OnlinePaymentService oPS) {
		this.contract = contract;
		this.oPS = oPS;
	}

	public OnlinePaymentService getOPS() {
		return oPS;
	}

	public void setOPS(OnlinePaymentService oPS) {
		this.oPS = oPS;
	}

	public Contract getContract() {
		return contract;
	}

	public void setContract(Contract contract) {
		this.contract = contract;
	}

	public void processContract(Contract contract,int months) {
		double intallmentValue = contract.getTotalValue()/months;
		Calendar cal = Calendar.getInstance();
		
		for(int i=1;i<=months;i++) {
			cal.setTime(contract.getDate());
			cal.add(Calendar.MONTH, i);
			Date d = cal.getTime();
			contract.addInstallment(new Installment(d,oPS.paymentFree(oPS.interest(intallmentValue, i)))); 
		}
					
	}
}
