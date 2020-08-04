package other;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeStamp {

	public static void main(String[] args) 
	{
		Date date = new Date();
		System.out.println(date);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy_hh:mm:ss");
		String timeStamp = sdf.format(date);
		System.out.println(timeStamp);

	}

}
