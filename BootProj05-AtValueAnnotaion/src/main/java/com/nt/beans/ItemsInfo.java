package com.nt.beans;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Component("info")
@PropertySource({"com/nt/commons/inputs.properties",""})
public class ItemsInfo {

	@Value("${idly.price}")
	public double idlyPrice;
	@Value("${dosa.price}")
	public float dosaPrice;
	@Value("${poha.price}")
	public float pohaPric;

	@Override
	public String toString() {
		return "ItemsInfo [idlyPrice=" + idlyPrice + ", dosaPrice=" + dosaPrice + ", pohaPrice=" + pohaPric + "]";
	}
	
	
}
