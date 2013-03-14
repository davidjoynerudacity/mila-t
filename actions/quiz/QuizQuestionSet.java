/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.actions.quiz;

import emt.tutor.Action;
import emt.tutor.Tutor;
import emt.tutor.actions.TextFeedbackAction;
import java.util.ArrayList;

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
        currentQuestion=0;
        questions=new ArrayList<AbstractQuizAction>();
    }
    
    public void addQuestion(AbstractQuizAction question) {
        questions.add(question);
        question.setQuestionSet(this);
    }
    
    public void getNextQuestion() {
        if(currentQuestion<questions.size()) {
            AbstractQuizAction nextQuestion=questions.get(currentQuestion);
            currentQuestion++;
            nextQuestion.doAction();
        } else {
            new RepeatQuizAction(myTutor,this).doAction();
        }
    }
    
    public void restartQuiz() {
        currentQuestion=0;
        getNextQuestion();
    }
    
    public void endQuiz() {
        new TextFeedbackAction(myTutor,"Thanks for completing the survey!").doAction();
    }
}
