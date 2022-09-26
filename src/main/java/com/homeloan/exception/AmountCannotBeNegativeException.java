package com.homeloan.exception;

public class AmountCannotBeNegativeException extends Exception
{
	public AmountCannotBeNegativeException(String msg)
	{
		super(msg);
	}
}
