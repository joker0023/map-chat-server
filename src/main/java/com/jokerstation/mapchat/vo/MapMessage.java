package com.jokerstation.mapchat.vo;

import lombok.Data;

@Data
public class MapMessage {

	private String sid;
	
	private Double latitude;
	
	private Double longitude;
	
	private String message;
}
