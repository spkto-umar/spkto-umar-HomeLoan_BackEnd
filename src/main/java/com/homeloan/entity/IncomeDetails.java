package com.homeloan.entity;

import javax.persistence.*;

@Entity
@Table(name="IncomeDetails_Table")
public class IncomeDetails 
{
		@Id
		@SequenceGenerator(name = "propid_seq", initialValue = 101, allocationSize = 1)
		@GeneratedValue(generator = "propid_seq", strategy = GenerationType.SEQUENCE)
		private int incomeId;
		
		private String propertyName;
		private String propertyLocation;
		private double amount;
		private int retirementAge;
		private double monthlySalary;
		private String organization;
		
		@OneToOne(mappedBy="income")
		//@JoinColumn(name="userId")
		private Customer customer;

		public IncomeDetails() {
			super();
			// TODO Auto-generated constructor stub
		}

		public IncomeDetails(int incomeId, String propertyName, String propertyLocation, double amount,
				int retirementAge, double monthlySalary, String organization, Customer customer) {
			super();
			this.incomeId = incomeId;
			this.propertyName = propertyName;
			this.propertyLocation = propertyLocation;
			this.amount = amount;
			this.retirementAge = retirementAge;
			this.monthlySalary = monthlySalary;
			this.organization = organization;
			this.customer = customer;
		}


		
		public int getRetirementAge() {
			return retirementAge;
		}

		public void setRetirementAge(int retirementAge) {
			this.retirementAge = retirementAge;
		}

		public double getMonthlySalary() {
			return monthlySalary;
		}

		public void setMonthlySalary(double monthlySalary) {
			this.monthlySalary = monthlySalary;
		}

		public String getOrganization() {
			return organization;
		}

		public void setOrganization(String organization) {
			this.organization = organization;
		}

		public int getIncomeId() {
			return incomeId;
		}

		public void setIncomeId(int incomeId) {
			this.incomeId = incomeId;
		}

		public String getPropertyName() {
			return propertyName;
		}

		public void setPropertyName(String propertyName) {
			this.propertyName = propertyName;
		}

		public String getPropertyLocation() {
			return propertyLocation;
		}

		public void setPropertyLocation(String propertyLocation) {
			this.propertyLocation = propertyLocation;
		}

		public double getAmount() {
			return amount;
		}

		public void setAmount(double amount) {
			this.amount = amount;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}

		@Override
		public String toString() {
			return "IncomeDetails [incomeId=" + incomeId + ", propertyName=" + propertyName + ", propertyLocation="
					+ propertyLocation + ", amount=" + amount + ", retirementAge=" + retirementAge + ", monthlySalary="
					+ monthlySalary + ", organization=" + organization + ", customerid=" + customer.getUserId() + "]";
		}

		
}
