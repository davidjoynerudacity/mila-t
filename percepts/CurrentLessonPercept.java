/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.percepts;

import emt.tutor.Percept;
import emt.tutor.Tutor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.Timer;

/**
 *
 * @author David
 */
public class CurrentLessonPercept extends Percept {
    private String myLesson;
    
    public CurrentLessonPercept(Tutor myTutor) {
        super(myTutor);
        LESSONCHECKER.startChecking();
    }
    public CurrentLessonPercept(Tutor myTutor,String lesson) {
        this(myTutor);
        this.myLesson=lesson;
    }
    public void setLesson(String lesson) {
        myLesson=lesson;
    }
    public String getLesson() {
        return myLesson;
    }
    
    public boolean isTrue() {
        if(myLesson.equalsIgnoreCase(LESSONCHECKER.CURRENTLESSON)) {
            return true;
        }
        return false;
    }
    
    public static class LESSONCHECKER implements ActionListener {
        public static String CURRENTLESSON="";
        public static Timer lessonTimer=new Timer(60000,new LESSONCHECKER());
        public static void updateCurrentLesson() {
            try {
                URL url=new URL("http://www.dilab.gatech.edu/MILA/php/lesson.txt");
                BufferedReader in=new BufferedReader(new InputStreamReader(url.openStream()));

                String str=in.readLine();
                CURRENTLESSON=str;
                in.close();
                System.out.println(str);
            } catch(Exception ex) {}
        }
        
        public static void startChecking() {
            if(CURRENTLESSON=="") {
                updateCurrentLesson();
            }
            lessonTimer.start();
        }
        public void actionPerformed(ActionEvent e) {
            updateCurrentLesson();
        }
    }
}
