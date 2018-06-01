package com.currency.convert.model;

public class PasswordValidatorBean {

	public PasswordValidatorBean() {
		// TODO Auto-generated constructor stub
	}

	private String password;
	private String confirmPassword;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPassword() {
		return confirmPassword;
	}

	public void setConfirmPassword(String confirmPassword) {
		this.confirmPassword = confirmPassword;
	}

	@Override
	public String toString() {
		return "PasswordValidatorBean [password=" + password + ", confirmPassword=" + confirmPassword + "]";
	}

}
