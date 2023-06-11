package com.ssmstudy.jdk;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class DateUtil {

    // XMLGregorianCalendar => java.util.Date
    public static Date convertToDate(XMLGregorianCalendar xmlGregorianCalendar) {
        GregorianCalendar gregorianCalendar = xmlGregorianCalendar.toGregorianCalendar();
        return gregorianCalendar.getTime();
    }

    // java.util.Date => XMLGregorianCalendar
    public static XMLGregorianCalendar convertToXmlDate(Date date) {
        GregorianCalendar gregorianCalendar = new GregorianCalendar();
        gregorianCalendar.setTime(date);
        XMLGregorianCalendar xmlGregorianCalendar = null;
        try {
            xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gregorianCalendar);
        } catch (DatatypeConfigurationException e) {
            e.printStackTrace();
        }

        return xmlGregorianCalendar;
    }
}
