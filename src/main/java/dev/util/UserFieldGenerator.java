package dev.util;

import java.security.InvalidParameterException;

import net.bytebuddy.implementation.bytecode.Throw;

public class UserFieldGenerator {

	private Exception InvalidParameterException;

	public UserFieldGenerator() {
		
	}
	
	public String createPseudonym(String firstName, String name) throws Exception{
		if (!("".equals(firstName)) || !("".equals(name))) {
			firstName = firstName.toUpperCase();
			firstName = firstName; //prévoir les tirets
			
			name = name.toUpperCase();
			if (name.length()>4) {
				
			name = name.substring(0, 5);
			}
					
			return	(firstName+name).toLowerCase();
			
		}else {
			throw InvalidParameterException;
			
		}	 
	}
	
	public String createPassword() {
		int max= 1000;
		int min= 0;
		String password= String.valueOf(((Math.random() * ((max - min) + 1)) + min));
		return password;
	}
	
	
	

}
