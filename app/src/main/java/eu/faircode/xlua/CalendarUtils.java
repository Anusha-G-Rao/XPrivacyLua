package eu.faircode.xlua;

/*import java.text.DateFormat;
import java.util.Date;*/

import java.text.SimpleDateFormat;
import java.util.Calendar;



public class CalendarUtils {
    //public static String dateFormat = "dd-MM-yyyy hh:mm";
   public static String dateFormat = "dd-MM-yyyy HH:mm:ss";
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat(dateFormat);

    public static String convertMilliSecondsToFormattedDate(long milliSeconds){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return simpleDateFormat.format(calendar.getTime());
    }
 /*
    static String formatDate(long dateInMillis) {

         Date date = new Date(dateInMillis);
        return DateFormat.getDateInstance().format(date);
    }*/

}
