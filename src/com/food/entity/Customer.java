package com.food.entity;

public class Customer {
	    private String customerId;
	    private String custName;
		private String password;
	    private String custEmail;
	    private String contact;
	    private String address;
	    private String dropLocation;
	    public Customer() {
			super();
			// TODO Auto-generated constructor stub
		}
	    public Customer(String customerId, String custName, String password, String custEmail, String contact,
				String address, String dropLocation) {
			super();
			this.customerId = customerId;
			this.custName = custName;
			this.password = password;
			this.custEmail = custEmail;
			this.contact = contact;
			this.address = address;
			this.dropLocation = dropLocation;
		}
	    @Override
		public String toString() {
			return "Customer [customerId=" + customerId + ", custName=" + custName + ", password=" + password
					+ ", custEmail=" + custEmail + ", contact=" + contact + ", address=" + address + ", dropLocation="
					+ dropLocation + "]";
		}
	    
	    public String getCustomerId() {
			return customerId;
		}

		public void setCustomerId(String customerId) {
			this.customerId = customerId;
		}

		public String getCustName() {
			return custName;
		}

		public void setCustName(String custName) {
			this.custName = custName;
		}

		public String getPassword() {
			return password;
		}

		public void setPassword(String password) {
			this.password = password;
		}

		public String getCustEmail() {
			return custEmail;
		}

		public void setCustEmail(String custEmail) {
			this.custEmail = custEmail;
		}

		public String getContact() {
			return contact;
		}

		public void setContact(String contact) {
			this.contact = contact;
		}

		public String getAddress() {
			return address;
		}

		public void setAddress(String address) {
			this.address = address;
		}

		public String getDropLocation() {
			return dropLocation;
		}

		public void setDropLocation(String dropLocation) {
			this.dropLocation = dropLocation;
		}		
		
}


