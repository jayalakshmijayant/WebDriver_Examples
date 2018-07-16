import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class DateFuctions {

	public static void main(String[] args) throws ParseException {
		String date="19/10/1989";
		SimpleDateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		Date d=df.parse(date);
		
		String month=new SimpleDateFormat("MMMM").format(d);
		String year=new SimpleDateFormat("yy").format(d);
		
		System.out.println(month);
		System.out.println(year);
		
		System.out.println(new Date());
		d=new Date();
		
		System.out.println(new SimpleDateFormat("MMMM").format(d));
		System.out.println(new SimpleDateFormat("YYYY").format(d));
		System.out.println(new SimpleDateFormat("dd").format(d));
	}

}
