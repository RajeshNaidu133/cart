
package roseindia.web.common;
import java.text.SimpleDateFormat;
import java.util.*;
import java.text.ParseException;

/*
 *  Utilities methods for general purpose
 */
public class Utilities {
	
	
	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	
	//rounding a double number up to 2 decimal places
	public double RoundDoubleTo2DecimalPlaces(double Rval, int Rpl){
		
		double p = (double)Math.pow(10,Rpl);
		Rval = Rval * p;
		  double tmp = Math.round(Rval);
		  double roundedValue=(double)tmp/p;	
		
		return roundedValue;
	}
	
	
	//change string date to Date  
	public  Date changeStringtoDate(String dob) {
		Date fdob = null;
		try {
			fdob = sdf.parse(dob);
		} catch (ParseException e) {
		}
		return fdob;
	}
	//change  Date  to string date
	public  String changeDatetoString(Date dob) {
		String fdob = null;
		try {
			fdob = sdf.format(dob);
		} catch (Exception e) {
		}
		return fdob;
	}

	
}
