package br.com.sicredi.sincronizacaoreceita.domain;
/**
* <b>ClientData</b>
* This class is the structure domain to be used in CSV data information
* @author - Rogerio de C.B.
*/
public class ClientData {
	private String agency;
	private String account;
	private String balance;
	private String status;
	private String result;

	public String getAgency() {
		return agency;
	}

	public void setAgency(String agency) {
		this.agency = agency;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getBalance() {
		return balance;
	}

	public void setBalance(String balance) {
		this.balance = balance;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

	@Override
	public String toString() {
		return "ClientData{" +
	                "agency='" + agency + "'" +
	                ", account ='" + account + "'" +
	                ", balance='" + balance + "'" +
	                ", status='" + status + "'" +
	                ", result='" + result + "'" +
	                '}';
	}
}
