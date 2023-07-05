package com.fox.component;

import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.alibaba.druid.filter.config.ConfigTools;
import com.alibaba.druid.util.DruidPasswordCallback;

/**
* @author F1337248 ShiLeiluo
* @date 2023-06-23 14:43
* @version 1.0
*/
public class DbPasswordCallback extends DruidPasswordCallback{

	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(DbPasswordCallback.class);
	
	@Override
	public void setProperties(Properties properties){
		super.setProperties(properties);
        String password = (String) properties.get("password");
        String publickey = (String) properties.get("publicKey");
        try {
            String dbpassword = ConfigTools.decrypt(publickey, password);
            logger.info("Druid Compont dbpassword: ***");
            setPassword(dbpassword.toCharArray());
        } catch (Exception e) {
        	logger.error("Druid ConfigTools.decrypt", e); 
        }
	}
}