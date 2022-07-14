package com.prueba.demo.utility;

import java.nio.ByteBuffer;
import java.security.SecureRandom;

import org.springframework.stereotype.Component;

@Component
public class UniqIdUtility {





	
	
//private Random random = new Random(); 
//Generador de claves unicas en formato Long 
public Long getUniqId() 
{ 
long time = System.currentTimeMillis(); 
String generator = ""; 
SecureRandom sec = new SecureRandom(); 
byte[] sbuf = sec.generateSeed(8); 
ByteBuffer bb = ByteBuffer.wrap(sbuf); 
generator = String.format("%d%.3s", time, Math.abs(bb.getLong())); 
Long Uniqid=Long.parseLong(generator); 
return Uniqid; 
}
}