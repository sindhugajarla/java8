package java8features;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

public class MyClass {

	public static void main(String[] args) throws ParseException {

		String filePath = "C:\\Users\\arunk\\OneDrive\\Desktop\\JulianDates.txt";

		try (Stream<String> stream = Files.lines(Paths.get(filePath))) {

			stream.forEach(MyClass::validateAndConvertJulianDate);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void validateAndConvertJulianDate(String julianDate) {

		try {
			if (!validate(julianDate)) {
				throw new Exception("Not a valid Julian Date : " + julianDate);
			}
			DateFormat fmt1 = new SimpleDateFormat("yyyyddd");
			Date date = fmt1.parse(julianDate);
			DateFormat fmt2 = new SimpleDateFormat("EEE, d MMM yyyy");
			String output = fmt2.format(date);
			System.out.println(output);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static boolean validate(String julianDate) throws Exception {

		boolean isValid = true;

		if (julianDate.length() > 7) {
			throw new Exception("Not a valid Julian Date : " + julianDate);
		}

		int x = Integer.parseInt(julianDate);

		
		String str=Integer.toString(x);
		String day_of_the_year = str.substring(str.length()-3);
		System.out.println(Integer.parseInt(day_of_the_year));
		int day=Integer.parseInt(day_of_the_year);
		int first_day_of_year = 1;
		int last_day_of_year= 365;	
		if (day >= first_day_of_year && day <= last_day_of_year) {
			isValid = true;
		} else {
			throw new Exception(day + " : Day is not in the valid  range of the year");
		}
		
		
		
		

		int firstFour = Integer.parseInt(Integer.toString(x).substring(0, 4));
		//System.out.println(firstFour);
		int minyear = 1900;
		int maxyear = 2100;
		int j = firstFour;
		if (j >= minyear && j <= maxyear) {
			isValid = true;
		} else {
			throw new Exception(j + " : Year is not in the valid range ");
		}
		return isValid;
	}

}
