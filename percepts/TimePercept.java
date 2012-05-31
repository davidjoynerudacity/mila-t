/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.percepts;

import emt.tutor.*;
import java.util.GregorianCalendar;

/**
 *
 * @author David
 */
public class TimePercept extends Percept {
    private GregorianCalendar startTime;
    private GregorianCalendar endTime;
    private boolean dateMatters;
    
    public TimePercept(Tutor myTutor) {
        super(myTutor);
    }
    
    public boolean isTrue() {
        GregorianCalendar now=new GregorianCalendar();
        if(dateMatters) {
            if(startTime.before(now) && endTime.after(now)) {
                return true;
            } else {
                return false;
            }
        } else {
            GregorianCalendar todayStartTime=new GregorianCalendar();
            todayStartTime.set(now.get(GregorianCalendar.YEAR),now.get(GregorianCalendar.MONTH),now.get(GregorianCalendar.DATE),startTime.get(GregorianCalendar.HOUR_OF_DAY),startTime.get(GregorianCalendar.MINUTE),startTime.get(GregorianCalendar.SECOND));
            GregorianCalendar todayEndTime=new GregorianCalendar();
            todayEndTime.set(now.get(GregorianCalendar.YEAR),now.get(GregorianCalendar.MONTH),now.get(GregorianCalendar.DATE),endTime.get(GregorianCalendar.HOUR_OF_DAY),endTime.get(GregorianCalendar.MINUTE),endTime.get(GregorianCalendar.SECOND));
            
            if(todayStartTime.before(now) && todayEndTime.after(now)) {
                return true;
            } else {
                return false;
            }
        }
    }
    
    public GregorianCalendar getStartTime() {
        return startTime;
    }
    public GregorianCalendar getEndTime() {
        return endTime;
    }
    public boolean getDateMatters() {
        return dateMatters;
    }
    public void setStartTime(int year,int month,int day,int hour,int minute,int second) {
        startTime=new GregorianCalendar(year,month-1,day,hour,minute,second);
    }
    public void setEndTime(int year,int month,int day,int hour,int minute,int second) {
        endTime=new GregorianCalendar(year,month-1,day,hour,minute,second);
    }
    public void setDateMatters(boolean m) {
        dateMatters=m;
    }
}
