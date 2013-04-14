/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.actions.quiz;

import emt.tutor.Action;
import emt.tutor.StaticVars;
import emt.tutor.Tutor;
import emt.tutor.actions.TextFeedbackAction;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

/**
 *
 * @author David
 */
public class QuizQuestionSet  {
    private ArrayList<AbstractQuizAction> questions;
    private String quizTitle;
    private int currentQuestion;
    private Tutor myTutor;
    
    public QuizQuestionSet(Tutor tutor) {
        this.myTutor=tutor;
        currentQuestion=-1;
        questions=new ArrayList<AbstractQuizAction>();
    }
    public QuizQuestionSet(Tutor tutor,String title) {
        this(tutor);
        quizTitle=title;
    }
    
    public void addQuestion(AbstractQuizAction question) {
        questions.add(question);
        question.setQuestionSet(this);
    }
    
    public void getNextQuestion() {
        if(currentQuestion<questions.size()-1) {
            currentQuestion++;
            boolean last=currentQuestion==questions.size()-1;
            boolean first=currentQuestion==0;
            AbstractQuizAction nextQuestion=questions.get(currentQuestion);
            nextQuestion.setIsLast(last);
            nextQuestion.setIsFirst(first);
            nextQuestion.doAction();
        } else {
            saveQuizResults();
            clearQuizResults();
            new RepeatQuizAction(myTutor,this).doAction();
        }
    }
    
    public void getPreviousQuestion() {
        if(currentQuestion>0) {
            currentQuestion--;
            boolean first=currentQuestion==0;
            AbstractQuizAction lastQuestion=questions.get(currentQuestion);
            lastQuestion.setIsFirst(first);
            lastQuestion.doAction();
        }
    }
    
    public void restartQuiz() {
        currentQuestion=-1;
        getNextQuestion();
    }
    
    public void saveQuizResults() {
        try {
            new File(StaticVars.PROJECTROOTPATH + File.separator + "QuizData").mkdir();
            Calendar cal = Calendar.getInstance();
            SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss");
            FileWriter fstream = new FileWriter(StaticVars.PROJECTROOTPATH + File.separator + "QuizData" + File.separator + quizTitle + "_" + sdf.format(cal.getTime()) + ".dat",true);
            BufferedWriter out = new BufferedWriter(fstream);
            
            for(AbstractQuizAction question : questions) {
                out.write(question.getPrompt() + "|" + question.getAnswer());
                out.newLine();
            }
            out.close();
            fstream.close();
        } catch(Exception ex) {
            System.out.println(ex);
        }
    }
    public void clearQuizResults() {
        for(AbstractQuizAction question : questions) {
            question.setAnswer("");
        }
    }
    
    public void endQuiz() {
        new TextFeedbackAction(myTutor,"Thanks for completing the survey!").doAction();
    }
}
