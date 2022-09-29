package com.homeloan.entity;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Customer_Table")
public class Customer 
{
	@Id
	@SequenceGenerator(name = "usr_seq", initialValue = 10001, allocationSize = 1)
	@GeneratedValue(generator = "usr_seq", strategy = GenerationType.SEQUENCE)
	private int userId;
	
	@Column(unique=true)
	private String email;
	private String password;
	private String firstName;
	private String middleName;
	private String lastName;
	private Long phone;
	private String dob;
	private String gender;
	private String nationality;
	
	@Column(unique=true)
	private Long aadharNo;
	
	@Column(unique=true)
	private String panNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="FK_Income")
	@JsonIgnore
	private IncomeDetails income;

	/* @OneToOne(fetch=FetchType.EAGER, cascade=CascadeType.ALL) */
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="FK_Loan")
	@JsonIgnore
	private LoanApplication loan;
	
	public Customer() 
	{
		super();
	}
	
	public Customer(int userId, String email, String password, String firstName, String middleName, String lastName,
			Long phone, String dob, String gender, String nationality, Long aadharNo, String panNo,
			IncomeDetails income, LoanApplication loan) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.firstName = firstName;
		this.middleName = middleName;
		this.lastName = lastName;
		this.phone = phone;
		this.dob = dob;
		this.gender = gender;
		this.nationality = nationality;
		this.aadharNo = aadharNo;
		this.panNo = panNo;
		this.income = income;
		this.loan = loan;
	}

	public IncomeDetails getIncome() {
		return income;
	}

	public void setIncome(IncomeDetails income) {
		this.income = income;
	}

	public LoanApplication getLoan() {
		return loan;
	}

	public void setLoan(LoanApplication loan) {
		this.loan = loan;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getMiddleName() {
		return middleName;
	}

	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}

	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getNationality() {
		return nationality;
	}
	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
	public Long getAadharNo() {
		return aadharNo;
	}
	public void setAadharNo(Long aadharNo) {
		this.aadharNo = aadharNo;
	}
	public String getPanNo() {
		return panNo;
	}
	public void setPanNo(String panNo) {
		this.panNo = panNo;
	}

	@Override
	public String toString() {
		return "Customer [userId=" + userId + ", email=" + email + ", password=" + password + ", firstName=" + firstName
				+ ", middleName=" + middleName + ", lastName=" + lastName + ", phone=" + phone + ", dob=" + dob
				+ ", gender=" + gender + ", nationality=" + nationality + ", aadharNo=" + aadharNo + ", panNo=" + panNo
				+ ", income=" + income + ", loan=" + loan + "]";
	}

}
