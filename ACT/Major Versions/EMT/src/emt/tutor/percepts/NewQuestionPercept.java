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
import java.util.ArrayList;
import javax.swing.Timer;

/**
 *
 * @author David
 */
public class NewQuestionPercept extends Percept {
    private ArrayList<String> myLoadedQuestions;
    
    public NewQuestionPercept() {
        myLoadedQuestions=new ArrayList<String>();
        myLoadedQuestions.add(null);
    }
    public NewQuestionPercept(Tutor myTutor) {
        super(myTutor);
        myLoadedQuestions=new ArrayList<String>();
        myLoadedQuestions.add(null);
        QUESTIONCHECKER.startChecking();
    }
    public void setTutor(Tutor tutor) {
        super.setTutor(tutor);
        QUESTIONCHECKER.startChecking();
    }
    public boolean isTrue() {
        System.out.println("Checking new question percept...");
        if(!myLoadedQuestions.contains(QUESTIONCHECKER.CURRENTQUESTION)) {
            System.out.println("New question found!");
            myLoadedQuestions.add(QUESTIONCHECKER.CURRENTQUESTION);
            return true;
        }
        return false;
    }
    
    public static class QUESTIONCHECKER implements ActionListener {
        public static String CURRENTQUESTION=null;
        public static Timer questionTimer=new Timer(30000,new QUESTIONCHECKER());
        public static void updateCurrentQuestion() {
            try {
                URL url=new URL("http://www.dilab.gatech.edu/MILA/php/question.txt");
                BufferedReader in=new BufferedReader(new InputStreamReader(url.openStream()));

                String str=in.readLine();
                CURRENTQUESTION=str;
                in.close();
                System.out.println("Question: " + str);
            } catch(Exception ex) {}
        }
        
        public static void startChecking() {
            updateCurrentQuestion();
            questionTimer.start();
        }
        public void actionPerformed(ActionEvent e) {
            updateCurrentQuestion();
        }
    }
}
