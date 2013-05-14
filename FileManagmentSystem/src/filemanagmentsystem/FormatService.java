package filemanagmentsystem;

import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Class with some formatting and calculation methods.
 *
 * @author Bspor
 */
public abstract class FormatService {

    private final static String MONTH_DAY_FORMAT = "MMdd";
    private final static String TIME_DATE = "h:mm a   dd-MMM-yyyy";
    private final static String SIMPLE_TIME = "hh:mm a";
    private final static String INVALID = "Invalid input.";
    private final static String DECIMAL_FORMAT = "#0.00";
    private final static double MINUTES = 60;
    /**
     * Method for calculating Month/Day based off the current system.
     *
     * @return formated date MMdd as a string.
     */
    public static String todaysMonthAndDay() {
        Date myDate = new Date();
        //yyyy-MM-dd:HH-mm-ss
        SimpleDateFormat sdf = new SimpleDateFormat(MONTH_DAY_FORMAT);
        String myCurrtentDateAndTime = sdf.format(myDate);
        return myCurrtentDateAndTime;
    }

    /**
     * Calculates the time and date based off the system running it.
     *
     * @return formatted time and date as a string.
     */
    public static String todaysDateAndTime() {
        Date myDate = new Date();
        //yyyy-MM-dd:HH-mm-ss
        SimpleDateFormat sdf = new SimpleDateFormat(TIME_DATE);
        String myCurrtentDateAndTime = sdf.format(myDate);
        return myCurrtentDateAndTime;
    }

    /**
     * This method returns the current time based on the system that calls it
     *
     * @return system time formatted as hh:mm a
     */
    public static String currentTime() {
        Date myDate = new Date();
        //yyyy-MM-dd:HH-mm-ss
        SimpleDateFormat sdf = new SimpleDateFormat(SIMPLE_TIME);
        String myCurrtentDateAndTime = sdf.format(myDate);
        return myCurrtentDateAndTime;
    }

    /**
     * A method for rounding a number to 2 decimal places.
     *
     * @param x this a double to be rounded.
     * @return the number rounded to two decimal places.
     */
    public static String roundDoubles(double x) {
        if (x < 0) {
            throw new IllegalArgumentException(INVALID);
        } else {
            String formatedNumber;
            NumberFormat nf = new DecimalFormat(DECIMAL_FORMAT);
            x = (double) Math.round(x * 100) / 100;
            formatedNumber = nf.format(x);
            return formatedNumber;
        }
    }

    /**
     * Creates a unique vehicle ID based on the month/day and its order of entry
     *
     * @param i this represents the order that the vehicle entered the garage.
     * @return a unique id for each vehicle as it enters the garage.
     */
    public static String createVehicleID(int i) {
        String myID;
        //Check for less than 0 values, no max needed
        if (i < 0) {
            throw new IllegalArgumentException(INVALID);
        } else {
            myID = FormatService.todaysMonthAndDay() + i;
            return myID;
        }
    }
    
     /**
     * Allow you to query a a record by key and field
     * @param key This is the name of the record.
     * @param valKey this is the key value to query.
     * @param field this is the value to return.
     * @return
     */
    public static String queryByRecordAndFieldName(Map<String, Map> key, String valKey, String field) {
            Map <String, String> mapOutput = new LinkedHashMap<>(key.get(valKey));
            return mapOutput.get(field);
    }

    /**
     * Because the time out is a random amount of time, I have to add that
     * random number to the time it checked in. This method does that.
     *
     * @param s This is a string at is passed in a hh:mm a format
     * @param d This is the number of hours as a double, so you can pass 8.5 for
     * instance
     * @return the future time from the date passed in after adding the time
     * hours and minutes
     * @throws ParseException parsing the String as a a date might throw this if
     * the string is in the wrong format.
     * @throws Exception This was thrown in to catch anything else.
     */
    public static String getTimeOut(String s, double d) throws ParseException, Exception {
        try {
            Date date = new SimpleDateFormat(SIMPLE_TIME).parse(s);
            int hours, minutes;
            Calendar cal = Calendar.getInstance(); // creates calendar
            cal.setTime(date); // sets calendar time/date
            hours = (int) d; // get my hours
            double tryme = d % hours * MINUTES; // get my minutes
            minutes = (int) tryme;
            cal.add(Calendar.HOUR_OF_DAY, hours);
            cal.add(Calendar.MINUTE, minutes);
            DateFormat df = new SimpleDateFormat(SIMPLE_TIME);
            String hour = df.format(cal.getTime());
            return hour;
        } catch (ParseException ex) {
            throw new Exception(INVALID);
        }
    }
}
