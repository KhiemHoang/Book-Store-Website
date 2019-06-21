package model;
import java.util.*;
import java.util.UUID;

public class PasswordChanger {
	
	public String Changer()
	{
		String candidateChars = "ABCDEFGHIJKLMNOPQRSTUVWXYZ1234567890";
		StringBuilder sb = new StringBuilder();
	    Random random = new Random();
	    for (int i = 0; i < 8; i++) {
	        sb.append(candidateChars.charAt(random.nextInt(candidateChars
	                .length())));
	    }
	    System.out.println(sb.toString());
	    return sb.toString();
		
	}
}
