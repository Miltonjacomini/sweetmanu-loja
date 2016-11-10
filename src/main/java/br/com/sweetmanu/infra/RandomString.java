package br.com.sweetmanu.infra;

import java.util.Random;

public class RandomString {

	public static String generateString(){
		Random random = new Random();
		return random.ints(48, 122).filter(i-> (i < 57 || i > 65) && (i <90 || i > 97))
				.mapToObj(i -> (char) i)
				.limit(6)
				.collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
				.toString();
	}
	
}
