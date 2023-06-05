
import gui.view.DateValidatorUsingDateFormat;

/**
 * @author Diego Alejandro Rubiano
 */
public class TestDAte {
    public static void main(String[] args) {
        DateValidatorUsingDateFormat dateFormat = new DateValidatorUsingDateFormat("dd-mm-yyyy");
        System.out.println(dateFormat.isValid("12-12-2023"));
    }
}
