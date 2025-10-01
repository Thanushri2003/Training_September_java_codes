
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Datetimeapi {

	public static void main(String[] args)
	{
		Date date=new Date();
		System.out.println(date);
		
		LocalDate today=LocalDate.now();
		System.out.println(today);
		
		LocalDate dob=LocalDate.of(2024,10,16);
		System.out.println(dob);
		
		LocalDateTime dtime=LocalDateTime.now();
		System.out.println(dtime);
		
		DateTimeFormatter format=DateTimeFormatter.ofPattern("dd/MM/YYYY");
		String frmat=today.format(format);
		System.out.println(frmat);

		
		LocalDate nexttw=today.plusDays(3);
		System.out.println(nexttw);
		
		today.minusDays(4);
		
		Month mth=dtime.getMonth();
		System.out.println(mth);
		
		int d=dtime.getDayOfMonth();
		System.out.println(d);
		
		LocalDateTime dtz=LocalDateTime.now();
		ZonedDateTime ztime=ZonedDateTime.now();
		System.out.println(ztime);
		
		ZoneId zid=ZoneId.of("Asia/Kolkata");
		System.out.println(zid);
		
		ZonedDateTime zrgndt=ztime.withZoneSameInstant(zid);
		System.out.println(zrgndt);
		
	}
}
