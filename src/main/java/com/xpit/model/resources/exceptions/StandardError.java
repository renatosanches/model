package com.xpit.model.resources.exceptions;

/* Back End - API REST 
 * Exeception Resource- Endpoint do Controlador Rest : StandardError = Objeto que recebe o erro 
 * Java + Spring Framework
 * Renato Sanches - XP IT Tecnologia 
 */

import java.io.Serializable;

//Objeto que recebe o erro
public class StandardError implements Serializable{	
	private static final long serialVersionUID = 1L;
	
	private Integer status;
	private String msg;
	private Long timeStamp;
	
	public StandardError(Integer status, String msg, Long timeStamp) {
		super();
		this.status = status;
		this.msg = msg;
		this.timeStamp = timeStamp;
	}
	
	public Integer getStatus() {
		return status;
	}
	public void setStatus(Integer status) {
		this.status = status;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	public Long getTimeStamp() {
		return timeStamp;
	}
	public void setTimeStamp(Long timeStamp) {
		this.timeStamp = timeStamp;
	}
	

	
}
