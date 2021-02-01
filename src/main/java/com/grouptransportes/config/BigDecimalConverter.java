package com.grouptransportes.config;

import java.math.BigDecimal;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.ParseException;

import org.springframework.boot.context.properties.ConfigurationPropertiesBinding;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@ConfigurationPropertiesBinding
public class BigDecimalConverter implements Converter<String, BigDecimal> {
    
	@Override
    public BigDecimal convert(String source) {
    	try {
    		if (source != null && !"".equals(source)) {
    			DecimalFormatSymbols symbols = new DecimalFormatSymbols();
    			symbols.setGroupingSeparator('.');
    			symbols.setDecimalSeparator(',');
    			String pattern = "#,##0.##";
    			DecimalFormat decimalFormat = new DecimalFormat(pattern, symbols);
    			decimalFormat.setParseBigDecimal(true);
    			
    			BigDecimal bigDecimal = (BigDecimal) decimalFormat.parse(source);
    			return bigDecimal;
    		}else {
    			return BigDecimal.ZERO;
    		}
		} catch (ParseException e) {
			return null;
		}
    }
}
