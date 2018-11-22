package com.audio1414.ssw.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.*;

@ApiModel(description = "Class representing a ping response for service.")
public class Ping {
	
	
    private String message;
    private String pingedOn;
    private String version;
    
	/**
	 * @param message
	 * @param pingedOn
	 * @param version
	 */
	public Ping(String message, String pingedOn, String version) {
		this.message = message;
		this.pingedOn = pingedOn;
		this.version = version;
	}
	
	/**
	 * @return the message
	 */
	public String getMessage() {
		return message;
	}
	/**
	 * @param message the message to set
	 */
	public void setMessage(String message) {
		this.message = message;
	}
	/**
	 * @return the pingedOn
	 */
	public String getPingedOn() {
		return pingedOn;
	}
	/**
	 * @param pingedOn the pingedOn to set
	 */
	public void setPingedOn(String pingedOn) {
		this.pingedOn = pingedOn;
	}
	/**
	 * @return the version
	 */
	public String getVersion() {
		return version;
	}
	/**
	 * @param version the version to set
	 */
	public void setVersion(String version) {
		this.version = version;
	}
}
