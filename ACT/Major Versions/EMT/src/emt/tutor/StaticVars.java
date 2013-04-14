/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author David
 */
public class StaticVars {
    public static String PROJECTROOTPATH="";
    public static void Log(String eventType, String ... parameters) {
        try {
            FileWriter fstream = new FileWriter(PROJECTROOTPATH + File.separator + "softwareLog.csv",true);
            BufferedWriter out = new BufferedWriter(fstream);
            
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            
            String outputString=eventType+"	"+sdf.format(cal.getTime())+"	";
            for(String s : parameters) {
                outputString=outputString+s+"	";
            }
            out.write(outputString.substring(0,outputString.length()-1));
            out.newLine();
            out.close();
            fstream.close();
        } catch(Exception ex) {}
    }
}
