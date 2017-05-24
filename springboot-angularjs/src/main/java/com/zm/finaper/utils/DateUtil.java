package com.zm.finaper.utils;


import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Class with static date related helper methods.
 * Methods can be added to this class on an as-needed basic
 */

public class DateUtil {

    // date display format dd/MM/yyyy, eg. 10/11/2007
    public static final String DD_MM_YYYY = "dd/MM/yyyy";
    // eg. 10 December 2007
    public static final String DD_MMMM_YYYY = "dd MMMM yyyy";
    //eg. 13-Dec-1963
    public static final String DD_MMM_YYYY = "dd-MMM-yyyy";
    public static final String HYPHEN_FORMAT = "dd-MM-yyyy";

    public static final String CC_EXPIRY_DATE_FORMAT = "MMyy";

    public static final String MANUFACTURER_DATE_FORMAT = "MM/yyyy";

    public static final String DatePattern = DD_MM_YYYY;
    private static final SimpleDateFormat displayWithTimeFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

    private static final SimpleDateFormat DISPLAY_WITH_FULL_DATE_TIME_FORMAT =
            new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

    private static final SimpleDateFormat FULL_DATE_TIME_WITH_TIMEZONE_FORMAT =
            new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy");

    private static final SimpleDateFormat LONG_DATE_WITH_TIME_FORMAT = new SimpleDateFormat("d MMMM yyyy h:mm a");

    private static final SimpleDateFormat displayDayFormat = new SimpleDateFormat("EEEEEEEEE");

    public static final DateFormat EXPIRY_DATE_FORMAT = new SimpleDateFormat("MM/yy");

    public static final String ControllerDateFormat = "ddMMyyyy";
    public static final String ControllerTimeFormat = "HHmmss";
    public static final String ControllerDateTimeFormat = ControllerDateFormat + ControllerTimeFormat;

    public static final String GUIDateTimeReadOnlyFormat = "dd/MM/yyyy HH:mm:ss";

    // The empty string
    private static final String EMPTY_STRING = StringUtil.EMPTY_STRING;

    // The format of the date field in the GUI
    public static final String GUI_DATE_FORMAT = "ddMMyyyy";

    // Format used in some mmyyyy input fields
    public final static String MM_YYYY_FORMAT = "MMyyyy";

    // Not the same as the DD_MMMM_YYYY format - for cards only
    public final static String CARD_DATE_LICENCE = "dd MMM yyyy";
    public final static String CARD_DATE_LICENCE_WITHOUT_SPACES = "ddMMMyyyy";

    // for licence cards
    public final static String CARD_FORMAT_NON_LICENCE = "dd MMM yy";
    public final static String CARD_FORMAT_WITHOUT_SPACES = "ddMMMyy";

    public static final String YEAR_ONLY_DATE_FORMAT = "yyyy";

    public static final String HH_MM = "HH:mm";

    public static final String BOOKING_SCHEDULE_DATE_FORMAT =  GUI_DATE_FORMAT + HH_MM;

    public static final String YYYY_MM_DD = "yyyyMMdd";
    public static final String YYMMDD = "yyMMdd";
    public static final String DDMMYYYY = "ddMMyyyy";
    public static final String YYYMMDDHHMMSSSSS = "yyyyMMddhhmmssSSS";

    public static final String DEFAULT_HHMMSS = "00:00:00";

    public static final String TIME_FORMAT_HHMMSSA = "hh:mm:ssa";
    public static final String TIME_FORMAT_HHMMA = "hh:mma";
    public static final String TIME_FORMAT_HHA = "hha";
    public static final String TIME_FORMAT_HHMMSS_A = "hh:mm:ss a";
    public static final String TIME_FORMAT_HHMM_A = "hh:mm a";
    public static final String TIME_FORMAT_HH_A = "hh a";
    public static final String TIME_FORMAT_HHMMSS = "HH:mm:ss";
    public static final String TIME_FORMAT_HHMM = "HH:mm";
    public static final String TIME_FORMAT_HH = "HH";

    public static final int MONTHS_IN_YEAR = 12;
    public static final int FORTNIGHTS_IN_YEAR = 26;

    //--------------------------------------------------------------------------

    /**
     * the regular expression for finding hh:mm in a String
     */
    private static final String TIME_REG_EXP = "\\s*([0-9]{1,2}):([0-9]{2})";

    private static final int DAY = 0;
    private static final int WEEK = 1;
    private static final int MONTH = 2;
    private static final int QUARTER = 3;
    private static final int YEAR = 4;
    private static final int INFRINGEMENT_STATS = 5;
    private static final int YEAR_ENDING_YESTERDAY = 6;
    private static final int BI_ANNUAL = 7;
    private static final int DEFAULT_COMMON_START = 1;

    /**
     * Number of milliseconds in a minute
     */
    private static final long MS_PER_MINUTE = 1000 * 60;

    public static Date parseDate(String dateString)
            throws ParseException {
        SimpleDateFormat displayFormat =
                new SimpleDateFormat(DatePattern);
        return displayFormat.parse(dateString);
    }

    public static Date parseDateQuietly(String dateString) {
        if (dateString == null) {
            return null;
        }
        try {
            SimpleDateFormat displayFormat =
                    new SimpleDateFormat(DatePattern);
            return displayFormat.parse(dateString);
        } catch (ParseException ex) {
            return null;
        }
    }

    public static Date parse(String dateString)
            throws ParseException {

        return parseDate(dateString);
    }

    /**
     * Check if the String appears blank.
     *
     * @param s the String
     * @return true if s is null, empty, or contains only spaces
     */
    private static boolean isBlank(String s) {
        return s == null || "".equals(s.trim());
    }

    /**
     * Convert a String in format ddMMyyyy into a Date.  A blank String will
     * result in a null Date.  ParseException will be thrown as RuntimeException.
     *
     * @param date the String to be converted
     * @param name the name of the date field for error messages
     * @return a Date.  Will be null if date is blank.
     * @since 12 Mar 2003
     */
    public static Date parse(String date, String name) {

        Date result = null;

        if (!isBlank(date)) {
            try {
                result = DateUtil.parseDate(date, "ddMMyyyy");

            } catch (ParseException e) {
                throw new RuntimeException(
                        "Invalid date format for " + name + ": " +
                                date);
            }
        }

        return result;
    }

    public static Date parseQuietly(String dateString) {
        return parseDateQuietly(dateString);
    }

    /**
     * Allows a Date Format to be specified when attempting to parse a date
     * string.  This means that a date of any allowed format can be parsed
     * using this method (see Javadoc for SimpleDateFormat for allowed format
     * strings).
     * <p/>
     * <p>author James Liddall
     *
     * @param dateString  the string which represents the date to be parsed
     * @param aDateFormat the string that is the format to be parsed. Must be
     *                    a allowable format as specified in SimpleDateFormat Javadoc)
     * @return Date the Date representation of the successfully parsed dateString
     * @throws ParseException thrown if the dateString could not be parsed
     *                        using the dateFormat.
     * @see SimpleDateFormat;
     */
    public static Date parseDate(String dateString, String aDateFormat)
            throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat(aDateFormat);
        return sdf.parse(dateString);
    }

    /**
     * Allows a Date Format to be specified when attempting to parse a date
     * string.  This means that a date of any allowed format can be parsed
     * using this method (see Javadoc for SimpleDateFormat for allowed format
     * strings).
     * <p/>
     * <p>author James Liddall
     *
     * @param dateString  the string which represents the date to be parsed
     * @param aDateFormat the string that is the format to be parsed. Must be
     *                    a allowable format as specified in SimpleDateFormat Javadoc)
     * @return Date the Date representation of the successfully parsed
     *         dateString or null if the string could not be parsed with the dateFormat
     * @see SimpleDateFormat;
     */
    public static Date parseDateQuietly(String dateString, String aDateFormat) {
        if (dateString == null) {
            return null;
        }
        try {
            return parseDate(dateString, aDateFormat);
        } catch (ParseException ex) {
            return null;
        }
    }

    /**
     */
    /**
     * Literally add the given number of years to the date.
     *
     * @param date  to add years to
     * @param years number of years to add
     * @return date with years added
     */
    public static Date addYears(Date date, int years) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.YEAR, years);
        return cal.getTime();
    }

    public static Date addDays(Date date, int days) {
        return addDays(date, days, false);
    }

    /**
     * Add the number of days to the date provided.  An option to skip weekends is allowed.
     * @param date the based date
     * @param days the number of days to add to the base date (may be negative)
     * @param skipWeekends parameter allowing weekends to be skipped/ignored
     * @return the new date calculated as requested
     */
    public static Date addDays(Date date, int days, boolean skipWeekends) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.DAY_OF_YEAR, days);

        // If skipping weekends:
        // and the date is increased, we add 2 days for Saturday and 1 day for Sunday,
        // and the date is decreased, we add 1 day for Saturday and 2 days for Sunday.
        if (skipWeekends) {
            int extraDaysSkip = 0;
            if (DateUtil.dayOfWeek(cal.getTime()) == Calendar.SATURDAY) {
                extraDaysSkip = (days > 0) ? 2 : -1;
            } else if (DateUtil.dayOfWeek(cal.getTime()) == Calendar.SUNDAY) {
                extraDaysSkip = (days > 0) ? 1 : -2;
            }
            if (extraDaysSkip != 0) {
                cal.add(Calendar.DAY_OF_YEAR, extraDaysSkip);
            }
        }

        return cal.getTime();
    }


    public static Date addDaysInclusive(Date date, int days) {
        Date inclusive = addDays(date, days - 1);
        //reduce a day so both days are inclusive
        return roundBackMinusEpsilon(inclusive);
    }

    public static Date addMonths(Date date, int months) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.MONTH, months);
        return cal.getTime();
    }

    public static Date addHours(Date date, int aHours) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.HOUR, aHours);
        return cal.getTime();
    }

    public static Date addSeconds(Date date, int aSeconds) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.SECOND, aSeconds);
        return cal.getTime();
    }

    /**
     * Add the number of minutes to the specified date
     * @param date the date
     * @param aMinutes the minutes to add
     * @return the date after adding the specified minutes
     */
    public static Date addMinutes(Date date, int aMinutes) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.MINUTE, aMinutes);
        return cal.getTime();
    }

    /**
     * Adds specified number of weeks and returns the added date.
     * <p>author Senthil Kumar, Sep 26 2002.
     *
     * @param date  date to which the week(s) to be added.
     * @param weeks how many weeks
     * @return date with weeks added
     */
    public static Date addWeeks(Date date, int weeks) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.WEEK_OF_YEAR, weeks);
        return cal.getTime();
    }

    /**
     * This method adds a year and rounds back to the end of
     * previous day. Handy for registration exp.dates
     *
     * @param date
     * @return
     */
    public static Date addRegoYear(Date date) {
        date = addYears(date, 1);
        return roundBackMinusEpsilon(date);
    }

    /**
     * This method adds months and rounds back to the end of
     * previous day. Handy for registration exp.dates
     *
     * @param date
     * @param months
     * @return
     */
    public static Date addRegoMonths(Date date, int months) {
        date = addMonths(date, months);
        return roundBackMinusEpsilon(date);
    }

    public static Date addRegoDays(Date date, int days) {
        date = addDays(date, days);
        return roundBackMinusEpsilon(date);
    }

    /**
     * Add amount units to date, eg add 3 years to date, or add 6 months to date
     *
     * @param date   - the date
     * @param amount - the number of units to add to date
     * @param units  - the unit to be added must be defined in the
     *               GregorianCalendar class, for example:
     *               GregorianCalendar.YEAR
     *               GregorianCalendar.MONTH
     *               GregorianCalendar.DAY_OF_YEAR
     * @return date plus amount units
     */
    public static Date add(Date date, int amount, int units) {
        if (date == null) {
            return null;
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(units, amount);
        return cal.getTime();
    }

    public static Integer get(Date date, int unit) {
        if (date == null) {
            return null;
        }
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return new Integer(cal.get(unit));
    }


    /**
     * Return the number of years (rounded down) between
     * the two dates.
     * <p/>
     * The number of years between two dates, d1 and d2,
     * may be understood to mean the number of whole years in the period from
     * d1 to d2, inclusive of d1 and exclusive of d2.  Fractions of a year are
     * discarded.
     * <p/>
     * The order of the two dates is irrelevant. The "time" component
     * of the two dates is ignored. Only the "date" part of the dates is
     * considered.
     * <p/>
     * <p>author James Gifford
     *
     * @param date1 first date
     * @param date2 second date
     * @return the number of years, rounded down,
     *         between the two dates.
     * @see #daysBetween
     * @see #daysInPeriod
     * @see #monthsBetween
     * @see #monthsInPeriod
     * @see #wholeMonthsInPeriod
     * @see #daysBetween
     * @see #daysInPeriod
     */
    public static int yearsBetween(Date date1, Date date2) {
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();

        cal1.setTime(date1);
        cal2.setTime(date2);

        roundBackCalendar(cal1);
        roundBackCalendar(cal2);

        Calendar first;
        Calendar second;

        if (cal1.before(cal2)) {
            first = cal1;
            second = cal2;
        } else {
            first = cal2;
            second = cal1;
        }

        int years = 0;
        first.add(Calendar.YEAR, 1);
        //roll one day back, <SK> 13 Aug 2002.
        first.add(Calendar.DAY_OF_YEAR, -1);

        while (first.before(second)) {
            years++;
            first.add(Calendar.YEAR, 1);
        }
        return years;
    }

    /**
     * This method is a synonym for yearsInPeriod().
     *
     * @param date1 the start date
     * @param date2 the end date
     *
     * @return the inclusive number of years between date1 and date2
     * @see #yearsInPeriod(Date, Date)
     */
    public static int yearsBetweenInclusive(Date date1, Date date2) {
        return yearsInPeriod(date1, date2);
    }

    /**
     * Calculate the number of years in the period d1 to d2 inclusive of both d1
     * and d2 as if marking them off on a calendar.
     * <p/>
     * Ignore the time components of these dates.
     * The order of d1 and d2 is not relevant.
     * The result will always be positive.
     * <p/>
     * This will be useful in computing the number of years in periods where the
     * start and end dates of the period are known and may contain time
     * components not relevant to the calculation.
     * <p/>
     * This method relies on yearsBetween(d1, d2) and consequently will not
     * work for dates before 2 January 1970.
     * <p/>
     * For example, if d1 = d2, then the result returned is 1.
     * If d2 is the day after d1, the result returned is 2.
     *
     * @param d1 the first date of the period
     * @param d2 the end date of the period
     * @return the number of years in the period, inclusive of d1 and d2 as a
     *         positive number.
     * @see #yearsBetween(Date, Date)
     * @see #yearsBetweenInclusive(Date, Date)
     */
    public static int yearsInPeriod(Date d1, Date d2) {
        return yearsBetween(d1, d2) + 1;
    }



    /**
     * Calculate the number of whole months in the period d1 to d2
     * inclusive of both d1 and d2.
     * <p/>
     * Ignore the time components of these dates.  The order of d1 and d2 is not
     * relevant.
     * <p/>
     * The result will always be positive.
     * <p/>
     * For example, if d1 = d2, then the result returned is 0.
     * If d2 = d1 + 1 month - 2 days, the result will be 0.
     * If d2 = d1 + 1 month - 1 day,  the result will be 1.
     * If d2 = d1 + 1 month, the result will be 1.
     * <p/>
     * <p/>
     * This would be useful in calculating the number of complete months in a
     * period such as a sanction where the start and end dates of the sanction
     * are known.
     *
     * @param d1 the first date of the period
     * @param d2 the end date of the period
     * @return the number of whole months in the period, inclusive of d1 and d2 as a
     *         positive number.
     * @see #monthsBetween
     * @see #monthsInPeriod
     * @see #daysBetween
     * @see #daysInPeriod
     * @see #yearsBetween
     */

    public static int wholeMonthsInPeriod(Date d1, Date d2) {
        if (isBefore(d1, d2)) {
            return monthsBetween(d1, addDays(d2, 1));

        } else {
            return monthsBetween(d2, addDays(d1, 1));
        }
    }


    /**
     * Calculate the number of months or part thereof in the period d1 to d2
     * inclusive of both d1 and d2.
     * <p/>
     * Ignore the time components of these dates.  The order of d1 and d2 is not
     * relevant.
     * <p/>
     * The result will always be positive.
     * <p/>
     * For example, if d1 = d2, then the result returned is 1.
     * If d2 = d1 + 1 month - 1 day,  the result will be 1.
     * If d2 = d1 + 1 month, the result will be 2.
     * <p/>
     * <p/>
     * This will be usefull in situations like the calculation of licence fees
     * where a monthly fee is charged for each month or part month in the
     * licence period, and the start date and end date of the period are known.
     *
     * @param d1 the first date of the period
     * @param d2 the end date of the period
     * @return the number of months or part thereof in the period, inclusive of
     *         d1 and d2 as a positive number.
     * @see #monthsBetween
     * @see #wholeMonthsInPeriod
     * @see #daysBetween
     * @see #daysInPeriod
     * @see #yearsBetween
     */

    public static int monthsInPeriod(Date d1, Date d2) {
        return monthsBetween(d1, d2) + 1;
    }


    /**
     * Return the number of months (rounded down) between
     * the two dates.
     * <p/>
     * The number of months between two dates, d1 and d2,
     * may be understood to mean the number of whole months in the period from
     * d1 to d2, inclusive of d1 and exclusive of d2.  Fractions of a month are
     * discarded.
     * <p/>
     * <p/>
     * The order of the two dates is irrelevant. The "time" component
     * of the two dates is ignored. Only the "date" part of the dates is
     * considered.  The result is always positive.
     * <p/>
     * <p/>
     * For example, if d1 = d2, then the result returned is 0.
     * If d2 = d1 + 1 month - 1 day,  the result will be 0.
     * If d2 = d1 + 1 month, the result will be 1.
     * <p/>
     * <p/>
     * This is useful for calculating an age in months.  So the age of a client
     * would be returned by monthsBetween(birthDate, today).
     * <p/>
     * <p>author James Gifford
     *
     * @param date1 first date
     * @param date2 second date
     * @return the number of calendar months, rounded down,
     *         between the two dates.
     * @see #monthsInPeriod
     * @see #wholeMonthsInPeriod
     * @see #daysBetween
     * @see #daysInPeriod
     * @see #yearsBetween
     */
    public static int monthsBetween(Date date1, Date date2) {
        Calendar cal1 = new GregorianCalendar();
        Calendar cal2 = new GregorianCalendar();

        cal1.setTime(date1);
        cal2.setTime(date2);

        roundBackCalendar(cal1);
        roundBackCalendar(cal2);

        Calendar first;
        Calendar second;

        if (cal1.before(cal2)) {
            first = cal1;
            second = cal2;
        } else {
            first = cal2;
            second = cal1;
        }

        int years = yearsBetween(date1, date2);
        int months = 12 * years;

        first.add(Calendar.YEAR, years);

        // Now capture the year, month and day of "first",
        // to use as baseline for our calculations
        int year = first.get(Calendar.YEAR);
        int month = first.get(Calendar.MONTH);
        int day = first.get(Calendar.DAY_OF_MONTH);
        int delta = 0;

        second.add(Calendar.DAY_OF_YEAR, 1);
        months--;

        while (first.before(second)) {

            months++;
            delta++;

            // Reset to baseline, then advance by delta
            first.set(Calendar.YEAR, year);
            first.set(Calendar.MONTH, month);
            first.set(Calendar.DAY_OF_MONTH, day);
            first.add(Calendar.MONTH, delta);
        }
        return months;
    }

    /**
     * @param date the date to use as the basis.
     * @param monthsToAdvance the number of months to advance.
     * @param dayOfMonth this specifies the day of month to set the date to.
     * @param roundBack whether to round back or not.
     * @return the calculated date based on the parameters.  It adds months and can return a specific day in the month.
     */
    public static Date calculateMonth(Date date, int monthsToAdvance, int dayOfMonth, boolean roundBack) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        cal.add(Calendar.MONTH, monthsToAdvance);
        cal.set(Calendar.DAY_OF_MONTH, dayOfMonth);
        return roundBack ? roundBack(cal.getTime()) : cal.getTime();
    }

    /**
     * Calculate the number of days in the period d1 to d2 inclusive of both d1
     * and d2 as if marking them off on a calendar.
     * <p/>
     * Ignore the time components of these dates.
     * The order of d1 and d2 is not relevant.
     * The result will always be positive.
     * <p/>
     * This will be useful in computing the number of days in periods where the
     * start and end dates of the period are known and may contain time
     * components not relevant to the calculation.
     * <p/>
     * This method relies on daysBetween(d1, d2) and consequently will not
     * work for dates before 2 January 1970.
     * <p/>
     * For example, if d1 = d2, then the result returned is 1.
     * If d2 is the day after d1, the result returned is 2.
     *
     * @param d1 the first date of the period
     * @param d2 the end date of the period
     * @return the number of days in the period, inclusive of d1 and d2 as a
     *         positive number.
     * @see #daysBetween
     * @see #monthsBetween
     * @see #monthsInPeriod
     * @see #wholeMonthsInPeriod
     * @see #yearsBetween
     * @since 15 Nov 2002
     */
    public static int daysInPeriod(Date d1, Date d2) {
        return daysBetween(d1, d2) + 1;
    }

    /**
     * Calculate the number of days between d1 and d2 as if marking them off on
     * a calendar, excluding the first date and including the second date.
     * <p/>
     * Ignore the time components of these dates.
     * The order of d1 and d2 is not relevant.
     * The result will always be positive.
     * <p/>
     * Will not work for dates before 2 January 1970 since this method relies
     * on Date.getTime() which uses 1 January 1970 GMT as a reference date.
     * <p/>
     * For example, if d1 = d2, then the result returned is 0.
     * If d2 is the day after d1, the result returned is 1.
     *
     * @param d1 one of the dates
     * @param d2 the other date
     * @return the number of days between d1 and d2.
     * @see #daysInPeriod
     * @see #monthsBetween
     * @see #monthsInPeriod
     * @see #wholeMonthsInPeriod
     * @see #yearsBetween
     * @since 15 Nov 2002
     */
    public static int daysBetween(Date d1, Date d2) {

        // Convert to milliseconds - this won't work for
        // dates before 1970 but we don't need such dates
        // in rego.act
        // Round back to midnight as we as only comparing the dates on a
        // calendar, not the times on a clock.  Then convert to milliseconds.
        long m1 = roundBack(d1).getTime();
        long m2 = roundBack(d2).getTime();

        // Convert to days instead of millis

        int dayNumber1 = (int) (m1 / (3600 * 1000 * 24));
        int dayNumber2 = (int) (m2 / (3600 * 1000 * 24));

        // subtract the day numbers
        int diff = dayNumber1 - dayNumber2;

        //make sure diff is positive
        if (diff < 0) {
            diff *= -1;
        }

        // diff = difference in days between d1 and d2
        return diff;
    }


    /**
     * @param d1 one of the dates
     * @param d2 the other date
     * @return the seconds between two dates (always a positive value).  A -1
     *         would be returned if any of the dates are null.
     */
    public static long secondsBetween(Date d1, Date d2) {

        if (d1 == null || d2 == null) {
            return -1;
        }

        //getTime returs miliseconds, so we divide with 1000 to get them back
        //to seconds
        long sec1 = d1.getTime() / 1000;
        long sec2 = d2.getTime() / 1000;

        return Math.abs(sec2 - sec1);
    }

    /**
     * Returns the maximum of the two dates. Note that time is included in the
     * comparison.
     * Dates can be null (in which case they are not greater
     * than non-null Dates)
     *
     * @param d1 first date
     * @param d2 second date
     * @return the argument most in the future
     */
    public static Date max(Date d1, Date d2) {

        if (d1 == null) {
            return d2;
        }
        if (d2 == null) {
            return d1;
        }

        if (d1.after(d2)) {
            return d1;
        }
        return d2;
    }


    /**
     * Compare three dates to determine if the first date is between the second
     * and third dates inclusive, ignoring the time of day components of the dates.
     * That is, determine if the given date is after or equal to the given start
     * date and before or less than the given end date.
     * <p/>
     * The time of day will be ignored in these comparisons.  If time of day is
     * important use the method isBetweenTime.
     *
     * @param date  a Date
     * @param start a Date
     * @param end   a Date
     * @return true if and only if date is between start and end inclusive.  Will
     *         be false if any of the Dates is null.  The time components of the dates
     *         will be ignored in the comparisons.
     * @see #isBetweenTime
     *      <p/>
     *      It is assumed that start is on or before end.
     *      <p/>
     *      If any date is null the result will be false.
     */
    public static boolean isBetween(Date date, Date start, Date end) {
        boolean result = false;

        if (date != null && start != null && end != null) {
            result = isAfterOrEqual(date, start) &&
                    isBeforeOrEqual(date, end);
        }


        return result;
    }

    /**
     * Is the given date in the current financial year, ie after the previous 30th of June
     * and before the next 1st of July.
     *
     * @param date  the Date to be tested
     * @param today the Date today
     * @return true if date is in the same financial year as today.
     */
    public static boolean isInCurrentFinancialYear(Date date, Date today) {

        Calendar dateCal = new GregorianCalendar();
        dateCal.setTime(date);
        roundBackCalendar(dateCal);

        Calendar todayCal = new GregorianCalendar();
        todayCal.setTime(today);
        roundBackCalendar(today);
        int month = todayCal.get(Calendar.MONTH);
        int year = todayCal.get(Calendar.YEAR);

        if (month < Calendar.JULY) {
            year--;
        }

        Calendar endOfPreviousYear = new GregorianCalendar();
        endOfPreviousYear.set(year, Calendar.JUNE, 30);
        roundBackCalendar(endOfPreviousYear);

        Calendar startOfNextYear = new GregorianCalendar();
        startOfNextYear.set(year + 1, Calendar.JULY, 1);
        roundBackCalendar(startOfNextYear);

        return dateCal.after(endOfPreviousYear) && startOfNextYear.after(dateCal);
    }

    /**
     * Compare three dates to determine if the first date is between the second
     * and third dates inclusive, including the time of day components of the dates.
     * That is, determine if the given date is after or equal to the given start
     * date and before or less than the given end date.
     * <p/>
     * The time of day will be included in these comparisons.  If time of day is
     * not relevant use the method isBetween.
     *
     * @param date  a Date
     * @param start a Date
     * @param end   a Date
     * @return true if and only if date is between start and end inclusive.  Will
     *         be false if any of the Dates is null.  The time components of the dates
     *         will be ignored in the comparisons.
     * @see #isBetween
     *      <p/>
     *      It is assumed that start is on or before end.
     *      <p/>
     *      If any date is null the result will be false.
     */
    public static boolean isBetweenTime(Date date, Date start, Date end) {
        boolean result = false;

        if (date != null && start != null && end != null) {
            result = isAfterOrEqualTime(date, start) &&
                    isBeforeOrEqualTime(date, end);
        }


        return result;
    }

    /**
     * Returns the minimum of the two dates. Note that time is included in the
     * comparison.
     * Dates can be null (in which case they are not less
     * than non-null Dates)
     *
     * @param d1 the first date
     * @param d2 the second date
     * @return the argument most in the past
     */
    public static Date min(Date d1, Date d2) {

        if (d1 == null) {
            return d2;
        }
        if (d2 == null) {
            return d1;
        }

        if (d1.before(d2)) {
            return d1;
        }
        return d2;
    }


    /**
     * Rounds the given date backwards to midnight.
     * Ie the returned date will be the stroke of midnight
     * at the beginning of the date represented by the Date object.
     *
     * @param date to round back
     * @return a Date set to date with the time fields set to zero.  Will be null
     *         if date is null.
     * @since 10 Oct 2002
     */
    public static Date roundBack(Date date) {
        Date result = null;

        if (date != null) {
            result = roundBackCalendar(date).getTime();
        }

        return result;
    }


    /**
     * Rounds the given date backwards to midnight.
     * Ie the returned date will be the stroke of midnight
     * at the beginning of the date represented by the Date object.
     * <p/>
     * Will return null if rawDate is null.
     *
     * @param rawDate the date as a String with the pattern "ddMMyyy"
     * @return a Date set to date with the time fields set to zero.
     *         <p/>
     *         throws RuntimeException
     * @throws RuntimeException if rawDate cannot be parsed
     * @since 10 Oct 2002
     */
    public static Date roundBack(String rawDate) throws RuntimeException {

        if (rawDate == null) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat("ddMMyyy");
        Date date;

        try {
            date = format.parse(rawDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return roundBack(date);
    }

    /**
     * @param date to be rounded back
     * @return a GregorianCalendar set to date with the time fields set to zero.
     *         If date is null a new GregorianCalendar with the time fields set to zero
     *         will be returned.
     * @since 10 Oct 2002
     */
    public static Calendar roundBackCalendar(Date date) {
        Calendar cal = new GregorianCalendar();

        if (date != null) {
            cal.setTime(date);
            roundBackCalendar(cal);
        }

        return cal;
    }

    /**
     * Rounds a calendar back to midnight by setting the hour, minute,
     * second and millisecond fields to zero.
     *
     * @param cal to round back
     */
    public static void roundBackCalendar(Calendar cal) {
        cal.set(Calendar.HOUR_OF_DAY, 0);
        cal.set(Calendar.MINUTE, 0);
        cal.set(Calendar.SECOND, 0);
        cal.set(Calendar.MILLISECOND, 0);
    }

    /**
     * Adds a second,
     * rounds back to midnight, then subtracts one second. This
     * is useful for generating expiry dates for things that should
     * expire at the "end" of the expiry day (eg licences).
     * <p/>
     * The algorithm is such that calling roundBackMinusEpsilon twice
     * yields the same result as calling it once (ie, it is an idempotent
     * operation).
     *
     * @param date is the date to apply the algorithm above to.
     * @return a Date which is 1 second before the midnight (i.e. 23:59:59)
     *         before the given date.
     * @since 04/12/2003 (Werner Koster) Changed from 1 millisecond to 1 second,
     *        because Oracle doesn't support/store milliseconds.
     */
    public static Date roundBackMinusEpsilon(Date date) {
        Date result = null;

        if (date != null) {
            Calendar cal = new GregorianCalendar();
            cal.setTime(date);
            cal.add(Calendar.SECOND, 1);
            roundBackCalendar(cal);
            cal.add(Calendar.SECOND, -1);
            result = cal.getTime();
        }

        return result;
    }


    /**
     * Adjust the Calendar to 23:59:59.0, ie 1 second
     * before midnight.  This will be useful when a date is to become the end
     * of a range that may be used in comparisons where time is relevant.
     * <p/>
     * We are not using milliseconds, because the date in the database doesn't
     * support milliseconds (only seconds).
     *
     * @param cal a Calendar
     * @return the same Calendar with its time set to 23:59:59,
     *         ie 1 second before midnight.
     * @since 24 Oct 2002
     */
    public static Calendar roundUp(Calendar cal) {

        if (cal != null) {
            cal.set(Calendar.HOUR_OF_DAY, 23);
            cal.set(Calendar.MINUTE, 59);
            cal.set(Calendar.SECOND, 59);
            cal.set(Calendar.MILLISECOND, 0);
        }

        return cal;
    }

    /**
     * Adjust the time of the date to 23:59:59, ie 1 second
     * before midnight.  This will be useful when a date is to become the end
     * of a range that may be used in comparisons where time is relevant.
     *
     * @param date a Date
     * @return the same date with its time set to 23:59:59,
     *         ie 1 second before midnight.     Will return null if date is null.
     * @since 24 Oct 2002
     */
    public static Date roundUp(Date date) {

        Date result = null;

        if (date != null) {
            Calendar cal = new GregorianCalendar();
            cal.setTime(date);
            result = roundUp(cal).getTime();
        }

        return result;
    }

    /**
     * Adjust the time of the date to 23:59:59, ie 1 second
     * before midnight.  This will be useful when a date is to become the end
     * of a range that may be used in comparisons where time is relevant.
     * <p/>
     * Will return null if rawDate is null.
     *
     * @param rawDate the date as a String with the pattern "ddMMyyy"
     * @return the same date with its time set to 23:59:59,
     *         ie 1 second before midnight.
     * @throws RuntimeException if rawDate cannot be parsed
     * @since 24 Oct 2002
     */
    public static Date roundUp(String rawDate) throws RuntimeException {

        if (rawDate == null) {
            return null;
        }

        SimpleDateFormat format = new SimpleDateFormat("ddMMyyy");
        Date date;

        try {
            date = format.parse(rawDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        return roundUp(date);
    }

    /**
     * @param day the day used to derive next available business day
     * @return the earliest day at or after the given day
     *         which is not a weekend. Eg thursday -> thursday but sunday -> monday.
     */
    public static Date skipWeekend(Date day) {
        return skipWeekend(day, 1);
    }

    /**
     * @param day  is the date to start the search from
     * @param seek = 1 means look at later dates, seek = -1
     *             means look at earlier dates.
     * @return a non-weekend day, by looking at either later
     *         or earlier dates.
     */
    public static Date skipWeekend(Date day, int seek) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(day);

        while (isWeekend(cal)) {
            cal.add(Calendar.DAY_OF_YEAR, seek);
        }

        return cal.getTime();
    }

    /**
     * @param cal date to be tested
     * @return true if the calendar points to a weekend day.
     */
    public static boolean isWeekend(Calendar cal) {
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return (day == Calendar.SATURDAY || day == Calendar.SUNDAY);
    }

    /**
     * @param date date to be tested
     * @return true if the calendar points to a weekend day.
     */
    public static boolean isWeekend(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        int day = cal.get(Calendar.DAY_OF_WEEK);
        return (day == Calendar.SATURDAY || day == Calendar.SUNDAY);
    }

    /**
     * @param aDate the date to use in the calculation.
     * @return the calendar's day of week which is a value between 1 and 7.
     *         Sunday is 1 and Saturday is 7.  The other days inbetween.
     */
    public static int dayOfWeek(Date aDate) {
        int dayOfWeek = -1;

        if (aDate != null) {

            Calendar calendar = new GregorianCalendar();
            calendar.setTime(aDate);
            dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        }
        return dayOfWeek;
    }


    /**
     * @param aDate the date to use in the calculation.
     * @param aDayOfWeek the day of the week (a value between 1 and 7, Sunday is 1 and Saturday is 7)
     * @return true if the specified day of week matches the day of the specified date, false otherwise.
     */
    public static boolean isDayOfWeek(Date aDate, int aDayOfWeek) {
        boolean dayOfWeekMatched = false;

        if (aDate != null) {
            Calendar calendar = new GregorianCalendar();
            calendar.setTime(aDate);
            dayOfWeekMatched = (aDayOfWeek == calendar.get(Calendar.DAY_OF_WEEK));
        }
        return dayOfWeekMatched;
    }



    /**
     * @param aDate      the Date to use in the calculation
     * @param aDayOfWeek the Day of week
     * @param aSkipToday indicate whether to return the same date as the
     *                   date parameter (aDate).  If set to false and the calculated date falls
     *                   on the same date as the date parameter then the date returned will be
     *                   the same as parameter aDate, else the aDate - 7 days will be returned.
     * @return the Date in the previous week with the same day.
     *         For instance if the date parameter (aDate) is 10-Sep and it falls on a
     *         Friday and the day of week parameter (aDayOfWeek) is 4 (value for
     *         Wednesday) then the date 8-Sep will be returned.  May return null.
     */
    public static Date findPreviousDayOfWeek(Date aDate, int aDayOfWeek,
                                             boolean aSkipToday) {
        Date previousDayOfWeek = null;

        if (aDate != null &&
                aDayOfWeek >= Calendar.SUNDAY &&
                aDayOfWeek <= Calendar.SATURDAY) {

            Date tDay = aDate;
            if (aSkipToday) {
                tDay = DateUtil.addDays(tDay, -1);
            }

            for (int i = Calendar.SUNDAY; i <= Calendar.SATURDAY &&
                    previousDayOfWeek == null; i++) {

                if (dayOfWeek(tDay) == aDayOfWeek) {
                    previousDayOfWeek = tDay;
                }
                tDay = DateUtil.addDays(tDay, -1);
            }
        }
        return previousDayOfWeek;
    }


    /**
     * Finds the Date in the next week with the same day as passed as parameter.
     * @param aDate the Date to use in the calculation
     * @param aDayOfWeek the Day of week
     * @param aSkipToday indicate whether to return the same date as the date parameter (aDate).
     * If set to false and the calculated date falls on the same date as the date parameter then the
     * date returned will be the same as parameter aDate, else the aDate + 7 days will be returned.
     * @return the Date in the next week with the same day. For instance if the date parameter (aDate) is 10-Sep
     * and it falls on a Friday and the day of week parameter (aDayOfWeek) is 4 (value for Wednesday)
     * then the date 15-Sep will be returned.  May return null.
     */
    public static Date findNextDayOfWeek(Date aDate, int aDayOfWeek, boolean aSkipToday) {
        Date nextDayOfWeek = null;

        if (aDate != null && aDayOfWeek >= Calendar.SUNDAY && aDayOfWeek <= Calendar.SATURDAY) {

            Date tDay = aDate;
            if (aSkipToday) {
                tDay = DateUtil.addDays(tDay, 1);
            }

            for (int i = Calendar.SUNDAY; i <= Calendar.SATURDAY && nextDayOfWeek == null; i++) {

                if (dayOfWeek(tDay) == aDayOfWeek) {
                    nextDayOfWeek = tDay;
                }
                tDay = DateUtil.addDays(tDay, 1);
            }
        }
        return nextDayOfWeek;
    }

    /**
     * @param date the date to be formatted
     * @return the date formatted for display, or the empty string
     *         if the date is null.
     */
    public static String format(Date date) {
        if (date == null) {
            return "";
        }
        SimpleDateFormat displayFormat =
                new SimpleDateFormat(DatePattern);
        return displayFormat.format(date);
    }

    /**
     * Format the date including the time component, in a manner suitable
     * for display.  Ignores seconds.
     *
     * @param date to be formatted
     * @return A String containng the formatted Date with time component
     *         (hours and minutes only)
     */
    public static String formatWithTime(Date date) {
        if (date == null) {
            return "";
        }
        return displayWithTimeFormat.format(date);
    }

    /**
     * Format the date including the time component to a long date.  e.g. 22 September 2012.  Ignores seconds.
     *
     * @param date to be formatted
     * @return A String containing the long-formatted Date with time component (hours and minutes only)
     */
    public static String formatLongDateWithTime(Date date) {
        if (date == null) {
            return StringUtil.EMPTY_STRING;
        }
        return LONG_DATE_WITH_TIME_FORMAT.format(date);
    }

    /**
     * Format the date including the time component, in a manner suitable
     * for display.
     *
     * @param date the date to be formatted
     * @return A String with date formatted including hours, minutes and seconds.
     */
    public static String formatWithFullTime(Date date) {
        if (date == null) {
            return "";
        }
        return DISPLAY_WITH_FULL_DATE_TIME_FORMAT.format(date);
    }

    /**
     * @param aDateTime the String to parse
     * @return a Date created by parsing the "date-time" string
     * @throws ParseException if aDateTime cannot be parsed
     */
    public static Date parseWithTime(String aDateTime) throws ParseException {
        if (StringUtil.isBlank(aDateTime)) {
            return null;
        }
        return displayWithTimeFormat.parse(aDateTime);
    }

    /**
     * @param aDateTime the String to parse
     * @return a Date created by parsing the "date-time" string.  Will return
     *         null if it cannot be parsed.
     */
    public static Date parseWithTimeQuietly(String aDateTime) {
        if (StringUtil.isBlank(aDateTime)) {
            return null;
        }
        try {
            return displayWithTimeFormat.parse(aDateTime);
        } catch (ParseException ex) {
            return null;
        }
    }

    /**
     * @param aDate the Date
     * @return the full Day of the week.  For instance "Wednesday" (not "Wed")
     *         will be returned if the Date parameter falls on a Wednesday.
     */
    public static String getDayOfWeek(Date aDate) {
        if (aDate == null) {
            return "";
        }
        return displayDayFormat.format(aDate);
    }

    /**
     * @param aDate the Date
     * @return the Day of the month.  Normally will be between 1 and 31.  Note: will return 1 when date is null.
     */
    public static int getDayOfMonth(Date aDate) {
        int day = 1;
        if (aDate != null) {
            Calendar cal = new GregorianCalendar();
            cal.setTime(aDate);
            day = cal.get(Calendar.DAY_OF_MONTH);
        }
        return day;
    }

    /**
     * For a given date extract the year component and return it as an integer
     * @param aDate the Date
     * @return the year component of the date.  Note: will return 1 when date is null.
     */
    public static int getYearComponent(Date aDate) {
        int year = 1;
        if (aDate != null) {
            Calendar cal = new GregorianCalendar();
            cal.setTime(aDate);
            year = cal.get(Calendar.YEAR);
        }
        return year;
    }

    /**
     * @param aDate       the base date
     * @param aDayOfMonth the days to set in the date
     * @return a specified date with the days set to the specified day.
     */
    public static Date setDay(Date aDate, int aDayOfMonth) {
        Date daySetInDate = aDate;
        if (aDate != null && aDayOfMonth > 0) {
            Calendar cal = new GregorianCalendar();
            cal.setTime(aDate);
            cal.set(Calendar.DAY_OF_MONTH, aDayOfMonth);
            daySetInDate = cal.getTime();
        }
        return daySetInDate;
    }

    /**
     * @param date    the date to be formatted
     * @param pattern the required date format pattern
     * @return the date formatted according to the given pattern.
     */
    public static String format(Date date, String pattern) {
        SimpleDateFormat givenFormat = new SimpleDateFormat(pattern);
        if (date == null) {
            return EMPTY_STRING;
        } else {
            return givenFormat.format(date);
        }
    }

    /**
     * @param date    the date to be formatted (in displayFormat format)
     * @param pattern the required date format pattern
     * @return the date formatted according to the given pattern.
     */
    public static String format(String date, String pattern) {
        SimpleDateFormat givenFormat = new SimpleDateFormat(pattern);
        if (date == null || date.trim().length() == 0) {
            return EMPTY_STRING;
        } else {
            try {
                SimpleDateFormat displayFormat =
                        new SimpleDateFormat(DatePattern);
                return givenFormat.format(displayFormat.parse(date));
            } catch (ParseException ex) {
                return date;
            }
        }
    }


    /**
     * @param aStringDate the date to be formatted.
     * @return the date formatted for display.  If the date cannot be formatted,
     *         it will be returned unformatted.
     */
    public static String formatDateTime(String aStringDate) {

        Date date = parseDateQuietly(aStringDate, ControllerDateTimeFormat);

        if (date == null) {
            return aStringDate;
        }

        return format(date, GUIDateTimeReadOnlyFormat);

    }

    /**
     * return time of a Date object
     * <p>author Rita Chen
     *
     * @param aDate from whcih to extract the time
     * @return String
     */
    public static String getTimeOfDate(Date aDate) {
        return getTimeOfDate(aDate, null);
    }

    /**
     * Return the time of a Date object given a date and time format
     * <p/>
     * <p>author Neil Klee 08/11/2002    *
     *
     * @param aDate       from which time portion will be extracted
     * @param aTimeFormat to define the output format of the time.  If null
     *                    the time format will default to "h:mm a".
     * @return String
     */
    public static String getTimeOfDate(Date aDate, String aTimeFormat) {
        String timeFormat = aTimeFormat;

        if (timeFormat == null) {
            timeFormat = "h:mm a";
        }

        SimpleDateFormat dateFormat = new SimpleDateFormat(timeFormat);

        return dateFormat.format(aDate);

    }

    /**
     * Compare two dates to determine if the first date is before the second
     * date, ignoring the time of day components of the dates.
     * <p/>
     * The time of day will be ignored in this comparison.  If time of day is
     * important use the method isBeforeTime(date1,date2).
     * <p/>
     * If either date is null the result will be false.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return true if date1 is before date2 (ignoring the time fields).
     *         Will be false if either date is null.
     * @since 10 Oct 2002
     */
    public static boolean isBefore(Date date1, Date date2) {
        boolean result = false;

        if (date1 != null && date2 != null) {
            Calendar cal1 = roundBackCalendar(date1);
            Calendar cal2 = roundBackCalendar(date2);
            result = cal1.before(cal2);
        }

        return result;
    }

    /**
     * Compare two dates to determine if the first date is before the second
     * date, including the time of day components in the comparison.
     * <p/>
     * The time of day is important to this comparison.  If time of day is
     * not relevant use the method isBefore(date1,date2).
     * <p/>
     * If either date is null the result will be false.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return true if date1 is before date2 (including the time fields).
     *         Will be false if either date is null.
     * @since 10 Oct 2002
     */
    public static boolean isBeforeTime(Date date1, Date date2) {
        boolean result = false;

        if (date1 != null && date2 != null) {
            Calendar cal1 = new GregorianCalendar();
            Calendar cal2 = new GregorianCalendar();
            cal1.setTime(date1);
            cal2.setTime(date2);
            result = cal1.before(cal2);
        }

        return result;
    }

    /**
     * Compare two dates to determine if the first date is before or eaual to
     * the second date, ignoring the time of day components of the dates.
     * .
     * <p/>
     * The time of day will be ignored in this comparison.  If time of day is
     * important use the method isBeforeOrEqualTime(date1,date2).
     * <p/>
     * If either date is null the result will be false.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return true if date1 is before or equal to date2 (ignoring the time fields).
     *         Will be false if either date is null.
     * @since 21 Oct 2002
     */
    public static boolean isBeforeOrEqual(Date date1, Date date2) {
        boolean result = false;

        if (date1 != null && date2 != null) {
            result = !isAfter(date1, date2);
        }
        return result;
    }

    /**
     * Compare two dates to determine if the first date is before or equal to
     * the second date, including the time of day components in the comparison..
     * <p/>
     * The time of day is important to this comparison.  If time of day is
     * not relevant use the method isBeforeOrEqual(date1,date2).
     * <p/>
     * If either date is null the result will be false.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return true if date1 is before or equal to date2 (including the time fields).
     *         Will be false if either date is null.
     * @since 21 Oct 2002
     */
    public static boolean isBeforeOrEqualTime(Date date1, Date date2) {
        boolean result = false;

        if (date1 != null && date2 != null) {
            result = !isAfterTime(date1, date2);
        }
        return result;
    }

    /**
     * Compares two dates and returns an integer depending on the results of the comparison. Initially built for use
     * within Comparator code.
     * If using in Comparator code,
     *     - Descending order achieved by passing object 1s date as the first param and object 2s date as the second param
     *     - Ascending order achieved by passing object 2s date as the first param and object 1s date as the second param
     * @param date1 Date - The first date to compare
     * @param date2 Date - Second Date to compare
     * @return int, 1 if date1 is earlier than date2,
     *              0 if they are the same date,
     *             -1 if date1 is later than date2
     */
    public static int dateComparison(Date date1, Date date2) {
        if (date1 == null && date2 != null) {
            return -1;
        }
        if (date1 != null && date2 == null) {
            return 1;
        }
        if (date1 == null && date2 == null) {
            return 0;
        }
        if (DateUtil.isAfterTime(date1, date2)) {
                return -1;
            } else if (DateUtil.isBeforeTime(date1, date2)){
                return 1;
            } else {
                return 0;
            }
    }

    /**
     * @param targetDate the "target" date to use in the comparison
     * @param fromDate   the "from" date to use in the comparison
     * @param toDate     the "to" date to use in the comparison
     * @param inclusive  boolean indicates whether the comparison should be done
     *                   inclusive of the "target" date (from <= target <= to) or exclusive of
     *                   the "target" date (from < target < to)
     * @return true if the "target" date is after the "from" date and before
     *         the "to" date, false otherwise.  False would be returned if any of these
     *         dates are null.
     */
    public static boolean inTimeRange(Date targetDate, Date fromDate,
                                      Date toDate, boolean inclusive) {
        boolean result;

        if (inclusive) {
            result = isBeforeOrEqualTime(fromDate, targetDate) &&
                    isAfterOrEqualTime(toDate, targetDate);
        } else {
            result = isBeforeTime(fromDate, targetDate) &&
                    isAfterTime(toDate, targetDate);
        }

        return result;
    }

    /**
     * Returns whether or not the date passed in represents an even year
     * e.g 1998, 2000, 2002 etc
     * <p/>
     * <p>author James Liddall
     *
     * @param date the date on which to check if the year is even
     * @return boolean false if date is an odd year or is null
     */
    public static boolean isEvenYear(Date date) {
        if (date != null) {
            Calendar c = new GregorianCalendar();
            c.setTime(date);

            int year = c.get(Calendar.YEAR);

            return (year % 2) == 0;

        } else {
            return false;
        }
    }


    /**
     * Compare two dates to determine if the first date is after the second
     * date, ignoring the time of day components of the dates.
     * .
     * <p/>
     * The time of day will be ignored in this comparison.  If time of day is
     * important use the method isAfterTime(date1,date2).
     * <p/>
     * If either date is null the result will be false.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return true if date1 is after date2 (ignoring the time fields).
     *         Will be false if either date is null.
     * @since 10 Oct 2002
     */
    public static boolean isAfter(Date date1, Date date2) {
        boolean result = false;

        if (date1 != null && date2 != null) {
            Calendar cal1 = roundBackCalendar(date1);
            Calendar cal2 = roundBackCalendar(date2);
            result = cal1.after(cal2);
        }

        return result;
    }


    /**
     * Compare two dates to determine if the first date is after the second
     * date, including the time of day components in the comparison.
     * <p/>
     * The time of day is important to this comparison.  If time of day is
     * not relevant use the method isAfter(date1,date2).
     * <p/>
     * If either date is null the result will be false.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return true if date1 is after date2 (including the time fields).
     *         Will be false if either date is null.
     * @since 10 Oct 2002
     */
    public static boolean isAfterTime(Date date1, Date date2) {
        boolean result = false;

        if (date1 != null && date2 != null) {
            Calendar cal1 = new GregorianCalendar();
            Calendar cal2 = new GregorianCalendar();
            cal1.setTime(date1);
            cal2.setTime(date2);
            result = cal1.after(cal2);
        }

        return result;
    }

    /**
     * Compare two dates to determine if the first date is after or equal to
     * the second date, ignoring the time of day components of the dates.
     * .
     * <p/>
     * The time of day will be ignored in this comparison.  If time of day is
     * important use the method isAfterOrEqualTime(date1,date2).
     * <p/>
     * If either date is null the result will be false.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return true if date1 is after or equal to date2 (ignoring the time fields).
     *         Will be false if either date is null.
     * @since 21 Oct 2002
     */
    public static boolean isAfterOrEqual(Date date1, Date date2) {
        boolean result = false;

        if (date1 != null && date2 != null) {
            result = !isBefore(date1, date2);
        }
        return result;
    }

    /**
     * Compare two dates to determine if the first date is after or equal to
     * the second date, including the time of day components in the comparison..
     * <p/>
     * The time of day is important to this comparison.  If time of day is
     * not relevant use the method isAfterOrEqual(date1,date2).
     * <p/>
     * If either date is null the result will be false.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return true if date1 is before or equal to date2 (including the time fields).
     *         Will be false if either date is null.
     * @since 21 Oct 2002
     */
    public static boolean isAfterOrEqualTime(Date date1, Date date2) {
        boolean result = false;

        if (date1 != null && date2 != null) {
            result = !isBeforeTime(date1, date2);
        }
        return result;
    }


    /**
     * Compare two dates to determine if the first date is equal to the second
     * date, ignoring the time of day components of the dates.
     * <p/>
     * If time of day is important use the method isEqualTime(date1,date2).
     * <p/>
     * If either date is null the result will be false.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return true if date1 is equal to date2 (ignoring the time fields).
     *         Will be false if either date is null.
     * @since 10 Oct 2002
     */
    public static boolean isEqual(Date date1, Date date2) {
        boolean result = false;

        if (date1 != null && date2 != null) {
            Calendar cal1 = roundBackCalendar(date1);
            Calendar cal2 = roundBackCalendar(date2);
            result = cal1.equals(cal2);
        }

        return result;
    }

    /**
     * Compare two dates to determine if the first date is equal to the second
     * date, ignoring the time of day components of the dates.
     * <p/>
     * If time of day is important use the method isEqualTimeOBothNull(date1,date2).
     * <p/>
     * If both dates are null the result will be true.  If only one date is null the result will be false.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return true if date1 is equal to date2 (ignoring the time fields).
     *         Will be true if both dates are null, and false if only one date is null.
     * @since 22 May 2007
     */
    public static boolean isEqualOrBothNull(Date date1, Date date2) {
        boolean result = false;

        if (date1 != null && date2 != null) {
            Calendar cal1 = roundBackCalendar(date1);
            Calendar cal2 = roundBackCalendar(date2);
            result = cal1.equals(cal2);

        } else if (date1 == null && date2 == null) {
            result = true;
        }

        return result;
    }


    /**
     * Compare two dates to determine if the first date is equal to the second
     * date, including the time of day components in the comparison.
     * <p/>
     * The time of day is important to this comparison.  If time of day is
     * not relevant use the method isEqual(date1,date2).
     * <p/>
     * If either date is null the result will be false.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return true if date1 is after date2 (including the time fields).
     *         Will be false if either date is null.
     * @since 10 Oct 2002
     */
    public static boolean isEqualTime(Date date1, Date date2) {
        boolean result = false;

        if (date1 != null && date2 != null) {
            Calendar cal1 = new GregorianCalendar();
            Calendar cal2 = new GregorianCalendar();
            cal1.setTime(date1);
            cal2.setTime(date2);
            result = cal1.equals(cal2);
        }

        return result;
    }


    /**
     * Compare two dates to determine if the first date is equal to the second
     * date, including the time of day components in the comparison.
     * <p/>
     * The time of day is important to this comparison.  If time of day is
     * not relevant use the method isEqualOrBothNull(date1,date2).
     * <p/>
     * If both dates are null the result will be true.  If only one date is null the result will be false.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return true if date1 is after date2 (including the time fields).
     *         Will be true if both dates are null, and false if only one date is null.
     * @since 22 May 2007
     */
    public static boolean isEqualTimeOrBothNull(Date date1, Date date2) {
        boolean result = false;

        if (date1 != null && date2 != null) {
            Calendar cal1 = new GregorianCalendar();
            Calendar cal2 = new GregorianCalendar();
            cal1.setTime(date1);
            cal2.setTime(date2);
            result = cal1.equals(cal2);

        } else if (date1 == null && date2 == null) {
            result = true;
        }

        return result;
    }

    /**
     * Compare two dates to determine if the first date is the same as to the
     * second date, ignoring the time of day components of the dates.
     * <p/>
     * If time of day is important use the method isTheSameTime(date1,date2).
     * <p/>
     * If both dates are null, they are considered to be the same and the result
     * will be true.
     * <p/>
     * If only one date is null the result will be false.
     *
     * @param d1 the first date
     * @param d2 the second date
     * @return true if date1 is equal to date2 (ignoring the time fields).
     *         Will be true if both dates are null, and false if only one date is null.
     * @see #isTheSameTime
     * @since 19 Mar 2003
     */
    public static boolean isTheSame(Date d1, Date d2) {
        boolean equal;

        equal = (d1 == null) && (d2 == null) || DateUtil.isEqual(d1, d2);

        return equal;
    }

    /**
     * Compare two dates to determine if the first date is the same as to the
     * second date including the time of day components in the comparison.
     * <p/>
     * The time of day is important to this comparison.  If time of day is
     * not relevant use the method isTheSame(date1,date2).
     * <p/>
     * If both dates are null, they are considered to be the same and the result
     * will be true.
     * <p/>
     * If only one date is null the result will be false.
     *
     * @param d1 the first date
     * @param d2 the second date
     * @return true if date1 is equal to date2 (ignoring the time fields).
     *         Will be true if both dates are null, and false if only one date is null.
     * @see #isTheSame
     * @since 19 Mar 2003
     */
    public static boolean isTheSameTime(Date d1, Date d2) {
        boolean equal;

        equal = (d1 == null) && (d2 == null) || DateUtil.isEqualTime(d1, d2);

        return equal;
    }

    public static Calendar asCalendar(Date date) {
        Calendar cal = new GregorianCalendar();

        if (date != null) {
            cal.setTime(date);
        }

        return cal;
    }

    /**
     * @param cal            the Calendar representation of the date
     * @param firstDayOfWeek is the day of the week which is to be numbered 0.
     *                       So to find the day of the week where the week begins on Monday,
     *                       pass Calendar.MONDAY as firstDayOfWeek.
     * @return an integer representing the day of the week such that
     *         firstDayOfWeek is numbered 0.
     * @since 11 June 2002
     */
    private static int getDayOfWeek(Calendar cal, int firstDayOfWeek) {
        return (cal.get(Calendar.DAY_OF_WEEK) + 7 - firstDayOfWeek) % 7;
    }

    /**
     * @param cal        the Calendar representation of the date
     * @param firstMonth defines when quarters begin.
     *                   This will be JANUARY to make quarters begin in JANUARY, APRIL, JULY, and
     *                   OCTOBER.  The constants are defined in Calendar.
     * @return an integer representing the month of the quarter such that
     *         first month of the quarter is numbered 0.
     * @since 11 June 2002
     */
    private static int getMonthOfQuarter(Calendar cal, int firstMonth) {
        return (cal.get(Calendar.MONTH) + 12 - firstMonth) % 3;
    }

    /**
     * @param cal        the Calendar representation of the date
     * @param firstMonth defines when the year begins.
     * @return an integer representing the month of the year such that
     *         first month of the year is numbered 0.
     * @since 11 June 2002
     */
    private static int getMonthOfYear(Calendar cal, int firstMonth) {
        return (cal.get(Calendar.MONTH) + 12 - firstMonth) % 12;
    }

    /**
     * @param date any date
     * @return the time of day as hour*100 + minute, where hour is a 24 hour clock.
     */
    public static int getTimeOfDay(Date date) {
        Calendar cal = new GregorianCalendar();
        cal.setTime(date);
        return cal.get(Calendar.HOUR_OF_DAY) * 100 + cal.get(Calendar.MINUTE);
    }



    /**
     * Format the date as required by the search engine.
     *
     * @param rawDate the date as a String with the pattern "ddMMyyy"
     * @return rawDate as a java.sql.Date
     * @throws RuntimeException if rawDate cannot be parsed
     * @since 21/10/2002
     */
    public static java.sql.Date getJavaSqlDate(String rawDate)
            throws RuntimeException {

        SimpleDateFormat format = new SimpleDateFormat("ddMMyyy");
        Date date;

        try {
            date = format.parse(rawDate);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

    /**
     * Format the date as required by the search engine.
     *
     * @param date the Date
     * @return date as a java.sql.Date
     * @since 28/10/2002
     */
    public static java.sql.Date getJavaSqlDate(Date date) {

        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        return sqlDate;
    }

    /**
     * This method is a synonym for daysInPeriod().
     *
     * @param startDate a start date
     * @param endDate   the end date
     *                  Senthil Kumar. Mar 11, 2003.
     * @return the inclusive number of days between startDate and endDate
     * @see #daysInPeriod(Date, Date)
     */
    public static int daysBetweenInclusive(Date startDate, Date endDate) {
        return daysInPeriod(startDate, endDate);
    }

    /**
     * This method is intended to be used by subsystems that
     * have end dates set to the last moment of a day. E.g.,
     * in registration the expiry date is set at 23:59:59. Calculations
     * concerning the days between a start date and an end date typically
     * require an inclusive number of days. Unlike {@link #monthsBetween}, the order
     * of these arguments is important; the second argument MUST be later
     * than or equal to the second.
     *
     * @param startDate a start date
     * @param endDate   the end date
     * @return the inclusive number of months between startDate and endDate
     */
    public static int monthsBetweenInclusive(Date startDate, Date endDate) {
        return monthsBetween(startDate, DateUtil.addDays(endDate, 1));
    }

    /**
     * @param aDay        represents the day of the month (1 to 31).
     * @param aMonth      represents the month of the year (1 to 12).
     * @param aYear       represents the year
     * @param aDateFormat the Format to display the date.
     * @return the date formatted for display.  The day, month and year will be
     *         used to construct the date.  If the format was unsuccessful, an empty
     *         string "" will be returned.
     */
    public static String formatQuietly(String aDay, String aMonth, String aYear,
                                       String aDateFormat) {
        String stringDate = "";
        try {
            if (aDay != null && aDay.trim().length() > 0 &&
                    aMonth != null && aMonth.trim().length() > 0 &&
                    aYear != null && aYear.trim().length() > 0) {

                Date date = parseDateQuietly(aDay + aMonth + aYear, "ddMMyyyy");

                stringDate = format(date, aDateFormat);
            }
        } catch (Exception e) {
            //ignore
        }
        return stringDate;
    }

    /**
     * Compare dates in a manner abiding to the {@link java.util.Comparator} contract. The time component
     * of the dates is ignored.
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return -1 if date1 < date2, 1 if date1 > date2, 0 if date1 == date2
     */
    public static int compare(Date date1, Date date2) {
        if (isBefore(date1, date2)) {
            return -1;
        } else if (isAfter(date1, date2)) {
            return 1;
        } else {
            return 0;
        }
    }

    /**
     * Compare dates in a manner abiding to the {@link java.util.Comparator} contract. The time component
     * of the dates is observed
     *
     * @param date1 the first date
     * @param date2 the second date
     * @return -1 if date1 < date2, 1 if date1 > date2, 0 if date1 == date2
     */
    public static int compareTime(Date date1, Date date2) {
        if (isBeforeTime(date1, date2)) {
            return -1;
        } else if (isAfterTime(date1, date2)) {
            return 1;
        } else {
            return 0;
        }
    }

    public static long minutesBetween(Date date1, Date date2) {

        final long diffMs = Math.abs(date1.getTime() - date2.getTime());
        return diffMs / MS_PER_MINUTE;

    }

    /**
     * @param date the date to evaluate.
     * @return true if the date falls on the 29th of February, false otherwise.
     */
    public static boolean isLeapDay(Date date) {
        boolean leapDay = false;
        if (date != null) {
            Calendar cal = new GregorianCalendar();
            cal.setTime(date);

            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);
            leapDay = (month == Calendar.FEBRUARY) && (day == 29);
        }
        return leapDay;
    }

    /**
     * @param aTime              the time to be formatted
     * @param aTimeInputPattern  the time format pattern for the time passed.
     * @param aTimeOutputPattern the required time format pattern to be used for output
     * @return the time formatted according to the pattern.  If it cannot perform
     *         the formatting, then the time passed will be returned.
     */
    public static String formatTime(String aTime, String aTimeInputPattern,
                                    String aTimeOutputPattern) {
        String formattedTime = aTime;
        if (!StringUtil.isBlank(aTime)) {
            SimpleDateFormat inputFormat = new SimpleDateFormat(aTimeInputPattern);
            SimpleDateFormat returnFormat = new SimpleDateFormat(aTimeOutputPattern);
            try {
                formattedTime = returnFormat.format(inputFormat.parse(aTime));
            } catch (ParseException ex) {
            }
        }
        return formattedTime;
    }

    /**
     * This method may be called when working with dates that may be null.
     * It saves adding null checks in the programs, by doing the check
     * here and returning a Date as specified by the caller.
     * It still will return null if both dates are null.
     *
     * @param aDate    contains the date (target-date) that will be tested for null.
     * @param aNvLDate contains the date to replace the target-date with (if it is null)
     * @return aNvLDate if aDate is null
     */
    public static Date nvl(Date aDate, Date aNvLDate) {
        return (aDate != null) ? aDate : aNvLDate;
    }

    /**
     * Attempt to parse a "date" in mmyyyy format into a Date. Return null if not
     * parsable
     *
     * @param mmyyyy a date in mmyyyy format
     * @return parsed date or null if not parseable
     */
    public static Date parseMMYYYY(String mmyyyy) {
        return parseDateQuietly(mmyyyy, MM_YYYY_FORMAT);
    }

    /**
     * Returns a string: "n Months and n Days"
     *
     * @param start
     * @param end
     * @return
     */
    public static String getMonthsAndDays(Date start, Date end) {
        int months = DateUtil.monthsBetweenInclusive(start, end);
        start = DateUtil.addMonths(start, months);
        start = DateUtil.roundBackMinusEpsilon(start);
        int days = DateUtil.daysBetween(start, end);
        String periodText = "";
        if (months > 0) {
            periodText += months + " Months";
        }
        if (days > 0) {
            if (months > 0) {
                periodText += " and ";
            }
            periodText += days + " Days";
        }
        return periodText;
    }


    /**
     * @param aBaseDate the date to calculate from
     * @param aTargetDayOfWeek the day of week (Sunday to Monday) to use in the calculation.  Sunday is 1, Monday is 2,
     * ... and Saturday is 7
     * @return the first date after the base date that is on the specified day of the week.  If the specified day
     * of the week is not between 1 and 7 or the base date is null, the base date will be returned.
     */
    public static Date getNextSpecifiedDayOfWeek(Date aBaseDate, int aTargetDayOfWeek) {
        if (aBaseDate == null || aTargetDayOfWeek < Calendar.SUNDAY || aTargetDayOfWeek > Calendar.SATURDAY) {
            return aBaseDate;
        }

        Date targetDay = DateUtil.addDays(aBaseDate, 1);
        while (DateUtil.dayOfWeek(targetDay) != aTargetDayOfWeek) {
            targetDay = DateUtil.addDays(targetDay, 1);
        }

        return targetDay;
    }

    /**
     * Replace the Date in the target date with the Date from the copy date, but leave the time in the target date alone.
     * @param aTargetDate the target date (date to be replaced)
     * @param aCopyDate the copy date (use this date to replace the target date)
     * @return a Date where the Date of the Target Date has been replaced with the Date of the Copy Date.  The time
     * will not be affected. 
     */
    public static Date replaceDate(Date aTargetDate, Date aCopyDate) {

        if (aTargetDate == null || aCopyDate == null) {
            return null;
        }

        Calendar copyCal = new GregorianCalendar();
        copyCal.setTime(aCopyDate);

        Calendar cal = new GregorianCalendar();
        cal.setTime(aTargetDate);
        cal.set(Calendar.HOUR_OF_DAY, copyCal.get(Calendar.HOUR_OF_DAY));
        cal.set(Calendar.MINUTE, copyCal.get(Calendar.MINUTE));
        cal.set(Calendar.SECOND, copyCal.get(Calendar.SECOND));
        cal.set(Calendar.MILLISECOND, copyCal.get(Calendar.MILLISECOND));

        return cal.getTime();
    }

    /**
     * return a simple Time string of HH:mm
     * @param aDate the date to format
     * @return the string representation of that formatted date
     */
    public static String getHoursMinutesFormatString(Date aDate) {
        return DateUtil.format(aDate, HH_MM);
    }

    /**
     * Gets the exact number of years between two dates
     * @param theStartDate the start date
     * @param theEndDate the end date
     * @return the number of years between the two dates (inclusive) or null if there is not an exact number of years
     * between them
     */
    public static Integer exactYearsBetween(Date theStartDate, Date theEndDate) {
        Integer yearsBetween = null;
        int years = yearsInPeriod(theStartDate, theEndDate);
        if (isEqual(roundBackMinusEpsilon(addYears(theStartDate, years)), theEndDate)) {
            yearsBetween = new Integer(years);
        }
        return yearsBetween;
    }

    /**
     * Gets the exact number of months between two dates
     * @param theStartDate the start date
     * @param theEndDate the end date
     * @return the number of months between the two dates (inclusive) or null if there is not an exact number of months
     * between them
     */
    public static Integer exactMonthsBetween(Date theStartDate, Date theEndDate) {
        Integer monthsBetween = null;
        int months = monthsInPeriod(theStartDate, theEndDate);
        if (isEqual(roundBackMinusEpsilon(addMonths(theStartDate, months)), theEndDate)) {
            monthsBetween = new Integer(months);
        }
        return monthsBetween;
    }

    /**
     * Parse date by taking care of all possible time formats including:
     *   1.	hha, e.g. 10PM (no space between mins and am/pm)
     *   2.	hh:mma, e.g. 10:15PM (no space between mins and am/pm)
     *   3.	hh:mm:ssa, e.g. 10:15:30PM (no space between mins and am/pm)
     *   4.	HH, e.g. 10
     *   5.	HH:mm, e.g. 16:15
     *   6.	HH:mm:ss, e.g. 16:15:30
     *   7.	hh a, e.g. 10 PM  (there is a space between mins and am/pm)
     *   8.	hh:mm a, e.g. 10:15 PM (there is a space between mins and am/pm)
     *   9.	hh:mm:ss a, e.g. 10:15:30 PM (there is a space between mins and am/pm)
     * @param date the Date to compose the result date, only day, month, and year value will be used.
     * @param timeString the time string which could be in various formats
     * @return the date contain the day, month, year from the Date and hour, minute, second from timeString.
     */
    public static Date parseDateWithFlexibleTimeFormat(Date date, String timeString) {
        if (StringUtil.isBlank(timeString)) {
            timeString = DEFAULT_HHMMSS;
        }
        String dateStr = format(date, DD_MM_YYYY);
        String dateTimeStr = dateStr + " " + timeString;
        Date resultDate = null;
        try {
            resultDate = DateUtil.parseDate(dateTimeStr, DD_MM_YYYY +
                    StringUtil.SPACE_STRING + TIME_FORMAT_HHMMSS_A);
        } catch (ParseException pe1) {
            try {
                resultDate = DateUtil.parseDate(dateTimeStr, DD_MM_YYYY +
                        StringUtil.SPACE_STRING + TIME_FORMAT_HHMM_A);
            } catch (ParseException pe2) {
                try {
                    resultDate = DateUtil.parseDate(dateTimeStr, DD_MM_YYYY +
                            StringUtil.SPACE_STRING + TIME_FORMAT_HH_A);
                } catch (ParseException pe3) {
                    try {
                        resultDate = DateUtil.parseDate(dateTimeStr, DD_MM_YYYY +
                                StringUtil.SPACE_STRING + TIME_FORMAT_HHMMSSA);
                    } catch (ParseException pe7) {
                        try {
                            resultDate = DateUtil.parseDate(dateTimeStr, DD_MM_YYYY +
                                    StringUtil.SPACE_STRING + TIME_FORMAT_HHMMA);
                        } catch (ParseException pe8) {
                            try {
                                resultDate = DateUtil.parseDate(dateTimeStr, DD_MM_YYYY +
                                        StringUtil.SPACE_STRING + TIME_FORMAT_HHA);
                            } catch (ParseException pe9) {
                                try {
                                    resultDate = DateUtil.parseDate(dateTimeStr, DD_MM_YYYY +
                                            StringUtil.SPACE_STRING + TIME_FORMAT_HHMMSS);
                                } catch (ParseException pe4) {
                                    try {
                                        resultDate = DateUtil.parseDate(dateTimeStr, DD_MM_YYYY +
                                                StringUtil.SPACE_STRING +TIME_FORMAT_HHMM);
                                    } catch (ParseException pe5) {
                                        try {
                                            resultDate = DateUtil.parseDate(dateTimeStr, DD_MM_YYYY +
                                                    StringUtil.SPACE_STRING + TIME_FORMAT_HH);
                                        } catch (ParseException pe6) {
                                            throw new RuntimeException(
                                                    "Invalid time format for " + timeString);
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        return resultDate;
    }

    /**
     * This method could be used to find the Left Over days.
     * For example , this could be used in the event of having to calculate refund of the
     * monies based on the days left over.
     * 'from' date is what the actual purchased item is valid until.
     * 'to' date is the date when the refund is been processed.
     *
     * @param from - the start date
     * @param to   - the end date
     * @return '0' if the 'to' date is after 'from' date or the 'actual days' if otherwise.
     */

    public static int daysLeftOver(Date from, Date to) {
        return isAfterOrEqual(to, from) ? 0 : daysBetween(from, to);
    }


    /**
     * TODO Sreekanth finish and test
     * Calculates the number of times a specific day occurs between two dates.
     * @param dayOfWeek
     * @param aFromDate
     * @param aToDate
     * @return the number of times a specific day occurs between two dates. May return 0 or -1..
     */
    public static long DayOfWeekBetween(int dayOfWeek, Date aFromDate, Date aToDate) {
        long weeks = -1;
        if (DateUtil.isBeforeOrEqual(aFromDate, aToDate) &&
            dayOfWeek >= Calendar.SUNDAY && dayOfWeek <= Calendar.SATURDAY) {

            Date firstDayOfWeekDate = DateUtil.findNextDayOfWeek(aFromDate, dayOfWeek, false);
            Date lastDayOfWeekDate = DateUtil.findPreviousDayOfWeek(aToDate, dayOfWeek, false);
            int days = DateUtil.daysBetweenInclusive(firstDayOfWeekDate, lastDayOfWeekDate);
            Double d = Math.ceil(days / 7.0);
            weeks = d.longValue();

            //TODO WK delete
            //weeks = Math.ceil(new Double(days) / 7.0);

//            Date dayOfWeekDate = DateUtil.findNextDayOfWeek(aFromDate, dayOfWeek, false);
//            int days = DateUtil.daysBetween(dayOfWeekDate, aToDate);
//            weeks = days / 7;
//            while (DateUtil.isBeforeOrEqual(dayOfWeekDate, aToDate) && weeks <= 1000) {
//                weeks++;
//                dayOfWeekDate = DateUtil.addDays(dayOfWeekDate, 7);
//            }
//
//            if (weeks >= 1000) {
//                weeks = -1;
//            }
        }

        return weeks;
    }


    /**
     * TODO Sreekanth finish and test
     * Calculates the number of times the fortnight occurs between two dates after the specified fortnight.
     * @param dayOfWeek
     * @param aToDate
     * @return the number of times a specific day occurs between two dates. May return 0 or -1..
     */
    public static long FortnightBetween(int dayOfWeek, Date aLastFortnightDate, Date aToDate) {
        long fortnights = -1;
        if (DateUtil.isBeforeOrEqual(aLastFortnightDate, aToDate) &&
            dayOfWeek >= Calendar.SUNDAY && dayOfWeek <= Calendar.SATURDAY) {
        }

        return fortnights;
    }

    /**
     * Returns the beginning of the current financial year
     *
     * @param date  the Date
     * @return the beginning of the current financial year.
     */
    public static Date getStartOfFinancialYear(Date date) {

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        if (calendar.get(Calendar.MONTH) < Calendar.JULY) {
            calendar.set(Calendar.YEAR, calendar.get(Calendar.YEAR) - 1);
        }

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        calendar.set(Calendar.MONTH, Calendar.JULY);

        roundBackCalendar(calendar);

        return calendar.getTime();
    }

    /**
     * Returns the beginning of the month
     *
     * @param date  the Date
     * @return the beginning of the month.
     */
    public static Date getStartOfMonth(Date date) {

        Calendar calendar = new GregorianCalendar();
        calendar.setTime(date);

        calendar.set(Calendar.DAY_OF_MONTH, 1);
        
        roundBackCalendar(calendar);

        return calendar.getTime();
    }


}
