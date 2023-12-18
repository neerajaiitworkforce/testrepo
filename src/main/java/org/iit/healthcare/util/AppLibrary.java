package org.iit.healthcare.util;

import java.util.Random;

public class AppLibrary {

		public String generateRandomString()
		{
			Random rand = new Random();
			int i = rand.nextInt(100);
			int j = 65+rand.nextInt(26);
			char upperCaseCh = (char)j;
			int k = 97+rand.nextInt(26);
			char lowerCaseCh = (char)k;
			String randomString=upperCaseCh+""+lowerCaseCh+""+i+"";
			return randomString;
		}
		public String generateRandomYear(int startYear)
		{

			Random rand = new Random();
			int year = startYear+rand.nextInt(10);
			//Integer i = new Integer(year);
			return year+"";
		}
		// LL + rand.nextInt(UL-LL+1)
		public  int generateRandomMonth()
		{
			Random rand = new Random();
			int i = 1 + rand.nextInt(12);//0 to 12// UL - LL+1 = 12-1+1=12

			return i;
		}


}
