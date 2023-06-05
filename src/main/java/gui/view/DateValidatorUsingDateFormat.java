package gui.view;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * @author Diego Alejandro Rubiano
 */
public class DateValidatorUsingDateFormat  {
    private String dateFormat;
    public DateValidatorUsingDateFormat(String dateFormat) {
        this.dateFormat = dateFormat;
    }

    public boolean isValid(String dateStr) {
        DateFormat asdas= new SimpleDateFormat(this.dateFormat);
        asdas.setLenient(false);
        try {
            asdas.parse(dateStr);
        } catch (ParseException e) {
            return false;
        }
        return true;
    }
}
