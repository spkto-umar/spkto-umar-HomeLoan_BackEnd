package com.homeloan.entity;
import javax.persistence.*;


@Entity
@Table(name="loan_applications")
public class LoanApplication 
{
		@Id
		@SequenceGenerator(name = "appid_seq", initialValue = 6001, allocationSize = 1)
		@GeneratedValue(generator = "appid_seq", strategy = GenerationType.SEQUENCE)
		private int applicationId;
		
		private double loanAmount;
		private int tenure;
		private int interest;
		private String status;
			
		@OneToOne(mappedBy="loan")
		private Customer customer;
		
		public LoanApplication(int applicationId, double loanAmount, int tenure, int interest, String status, Customer customer) {
			super();
			this.applicationId = applicationId;
			this.loanAmount = loanAmount;
			this.tenure = tenure;
			this.interest = interest;
			this.status = status;
			this.customer = customer;
		}

		public LoanApplication() {
			super();
			// TODO Auto-generated constructor stub
		}

		public int getApplicationId() {
			return applicationId;
		}

		public void setApplicationId(int applicationId) {
			this.applicationId = applicationId;
		}

		public double getLoanAmount() {
			return loanAmount;
		}

		public void setLoanAmount(double loanAmount) {
			this.loanAmount = loanAmount;
		}

		public int getTenure() {
			return tenure;
		}

		public void setTenure(int tenure) {
			this.tenure = tenure;
		}

		public int getInterest() {
			return interest;
		}

		public void setInterest(int interest) {
			this.interest = interest;
		}

		public String getStatus() {
			return status;
		}

		public void setStatus(String status) {
			this.status = status;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		@Override
		public String toString() {
			return "LoanApplication [applicationId=" + applicationId + ", loanAmount=" + loanAmount + ", tenure="
					+ tenure + ", interest=" + interest + ", status=" + status + ", customerid=" + customer.getUserId() + "]";
		}
		

}
