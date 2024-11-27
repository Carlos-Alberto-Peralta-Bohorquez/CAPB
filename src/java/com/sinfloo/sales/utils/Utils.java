
package com.sinfloo.sales.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.*;

public class Utils {
    
    private static final Logger LOGGER=Logger.getLogger(Utils.class.getName());
    
    public static String isNullOrEmty(String key, String value){
        if(value==null){
            value="";
        }
        boolean r=value.isBlank();
        
        if (r) {
            throw new NullPointerException("El campo "+key+" es obligario");
        }
        return value;
    }
    
    public static double convertStringtoDecimal(String value){
        double r=0.00;
        try {
            r=Double.parseDouble(value);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.INFO, "ERROR:{0}",e.getLocalizedMessage());
        }
        return r;
    }
    
    public static  long convertStringToNumeric(String value){
        long r=0;
        try {
            r=Long.parseLong(value);
        } catch (NumberFormatException e) {
            LOGGER.log(Level.INFO, "ERROR:{0}",e.getLocalizedMessage());
        }
        
        return r;
    }
    
    public static String generateCodeWithDate(){
        SimpleDateFormat format=new SimpleDateFormat("YYYYMMDDhhmmss");
        return format.format(new Date());
    }
}
