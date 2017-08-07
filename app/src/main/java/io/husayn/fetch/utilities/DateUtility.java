package io.husayn.fetch.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by husaynhakeem on 8/7/17.
 */

public class DateUtility {

    private static final String UNFORMATTED_DATE_REGEX = "^\\d{4}-\\d{2}-\\d{2}.+$";
    private static final String FORMATTED_DATE_FORMAT = "yyyy-MM-dd";
    private static final int FROM_INDEX = 0;
    private static final int TO_INDEX = FORMATTED_DATE_FORMAT.length();


    public static String formatDate(String unformattedDate) {

        if (!unformattedDate.matches(UNFORMATTED_DATE_REGEX))
            return unformattedDate;

        try {
            SimpleDateFormat dateFormat = new SimpleDateFormat(FORMATTED_DATE_FORMAT);
            Date date = dateFormat.parse(unformattedDate.substring(FROM_INDEX, TO_INDEX));
            return dateFormat.format(date);
        } catch (Exception e) {
            return unformattedDate;
        }
    }
}
