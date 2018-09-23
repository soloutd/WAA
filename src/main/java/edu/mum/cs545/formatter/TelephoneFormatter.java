package edu.mum.cs545.formatter;

import org.springframework.format.Formatter;

import java.text.ParseException;
import java.util.Locale;


public class TelephoneFormatter implements Formatter<Telephone> {

    @Override
    public String print(Telephone productionCode, Locale arg1) {
        return productionCode.toString(); 
    }

    @Override
    public Telephone parse(String source, Locale locale) throws ParseException {
        Telephone telephone = null;
        try {
            String areaCode = source.substring(0, 3);
            String start = source.substring(3, 6);
            String last = source.substring(6, 10);
            telephone = new Telephone(areaCode,start, last);
        } catch (Exception e) {
            System.out.println("Error - Bad Telephone Format");
        }
        return telephone;
    }

}
