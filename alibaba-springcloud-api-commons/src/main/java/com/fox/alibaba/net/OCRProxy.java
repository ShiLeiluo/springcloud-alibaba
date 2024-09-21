package com.fox.alibaba.net;

import java.net.Authenticator;
import java.net.PasswordAuthentication;

/**
* @author F1337248 ShiLeiluo
* @date 2023-08-16 14:39
* @version 1.0
*/
public class OCRProxy {
	public static void main(String[] args) {
		System.setProperty("proxyHost", "10.191.131.15");
		System.setProperty("proxyPort", "3128");
		System.setProperty("jdk.http.auth.tunneling.disabledSchemes", "");
		Authenticator.setDefault(
		    new Authenticator() {
		        @Override
		        public PasswordAuthentication getPasswordAuthentication() {
		              return new PasswordAuthentication("F1329986", "Fox0609.".toCharArray());
		        }
		    }
		);
	}
}
