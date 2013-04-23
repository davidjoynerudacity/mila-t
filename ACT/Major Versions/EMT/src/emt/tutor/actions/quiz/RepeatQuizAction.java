/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.actions.quiz;

import emt.tutor.Action;
import emt.tutor.Tutor;

/**
 *
 * @author David
 */
public class RepeatQuizAction extends Action {
    private QuizQuestionSet myQSS;

    public RepeatQuizAction() {
    }
    
    public RepeatQuizAction(Tutor myTutor,QuizQuestionSet qss) {
        super(myTutor);
        myQSS=qss;
    }
    public void doAction() {
        getTutor().giveRepeatQuizAction(this);
    }
    public QuizQuestionSet getQSS() {
        return myQSS;
    }
    public void setPrompt(QuizQuestionSet qss) {
        myQSS=qss;
    }
    public void repeatQuiz() {
        myQSS.restartQuiz();
    }
    public void endQuiz() {
        myQSS.endQuiz();
    }
    
}
