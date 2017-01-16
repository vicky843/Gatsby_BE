package com.vicky.gatsby.model;

import javax.persistence.Transient;

import org.springframework.stereotype.Component;

@Component
public class Errormsgs {
@Transient
	public String errorcode;
	@Transient
	public String errormsg;

	public String getErrorcode() {
		return errorcode;
	}

	public void setErrorcode(String errorcode) {
		this.errorcode = errorcode;
	}

	public String getErrormsg() {
		return errormsg;
	}

	public void setErrormsg(String errormsg) {
		this.errormsg = errormsg;
	}
	
}
