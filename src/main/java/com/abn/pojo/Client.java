package com.abn.pojo;

public class Client {
	
	
	
	
	
	private String clientType; 
	private String accountNumber;
	private String clientNumber;
	private String subAccountNumber;
	
	
	public String getClientType() {
		return clientType;
	}
	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	public String getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	public String getClientNumber() {
		return clientNumber;
	}
	public void setClientNumber(String clientNumber) {
		this.clientNumber = clientNumber;
	}
	public String getSubAccountNumber() {
		return subAccountNumber;
	}
	public void setSubAccountNumber(String subAccountNumber) {
		this.subAccountNumber = subAccountNumber;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountNumber == null) ? 0 : accountNumber.hashCode());
		result = prime * result + ((clientNumber == null) ? 0 : clientNumber.hashCode());
		result = prime * result + ((clientType == null) ? 0 : clientType.hashCode());
		result = prime * result + ((subAccountNumber == null) ? 0 : subAccountNumber.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Client other = (Client) obj;
		if (accountNumber == null) {
			if (other.accountNumber != null)
				return false;
		} else if (!accountNumber.equals(other.accountNumber))
			return false;
		if (clientNumber == null) {
			if (other.clientNumber != null)
				return false;
		} else if (!clientNumber.equals(other.clientNumber))
			return false;
		if (clientType == null) {
			if (other.clientType != null)
				return false;
		} else if (!clientType.equals(other.clientType))
			return false;
		if (subAccountNumber == null) {
			if (other.subAccountNumber != null)
				return false;
		} else if (!subAccountNumber.equals(other.subAccountNumber))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Client [clientType=" + clientType + ", accountNumber=" + accountNumber + ", clientNumber="
				+ clientNumber + ", subAccountNumber=" + subAccountNumber + "]";
	}
}
