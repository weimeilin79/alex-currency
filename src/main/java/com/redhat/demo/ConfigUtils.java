package com.redhat.demo;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigUtils {

	private static Properties properties = new Properties();
    private static final String PROPERTIES_FILE = "currencyexchangeAlexa.properties";
    private static final String BASE_URL = "base.url";
    private static final String CURRENCY_EXCHANGE_TOKEN = "currency.exchange";
    
    private static final String API_MANAGEMENT_TOKEN= "threescale.api.token";
   
    private static final String ALEXA_APP_ID = "alexa.app.id";

    static {
    	try(InputStream is = ConfigUtils.class.getClassLoader().getResourceAsStream(PROPERTIES_FILE)) {   		
    		properties.load(is);
    	} catch (IOException e) {
			e.printStackTrace();
		}
    }
    
    public static String getCurrencyExchangeEndpoint() {
    	return resolveProperty(BASE_URL) +"/"+ resolveProperty(CURRENCY_EXCHANGE_TOKEN);
    }
    
    public static String getAPIToken() {
    	return resolveProperty(API_MANAGEMENT_TOKEN);
    }
    
    public static String getAlexaAppId() {
    	return resolveProperty(ALEXA_APP_ID);
    }
    
    
    private static String resolveProperty(final String property) throws IllegalArgumentException {
        
    	String envVarProp = property.replaceAll("\\.", "_").toUpperCase();
    	
    	String value = System.getenv(envVarProp);
    	
    	if(value != null && !value.isEmpty()) {
    		return value;
    	}
    	
    	value = System.getProperty(property);
    	if(value != null && !value.isEmpty()) {
    		return value;
    	}
    	
    	value = properties.getProperty(property);
    	if(value != null && !value.isEmpty()) {
    		return value;
    	}
                
        throw new IllegalArgumentException("Could Not Locate Property  " + property);
        
    }
	
}
