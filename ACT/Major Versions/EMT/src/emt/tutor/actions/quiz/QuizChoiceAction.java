/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.actions.quiz;

import emt.tutor.Action;
import emt.tutor.Tutor;
import java.util.ArrayList;

/**
 *
 * @author David
 */
public class QuizChoiceAction extends AbstractQuizAction {
    private String myPrompt;
    private boolean isRadio;
    private ArrayList<String> myOptions;

    public QuizChoiceAction() {
    }
    
    public QuizChoiceAction(Tutor myTutor) {
        super(myTutor);
        myOptions=new ArrayList<String>();
    }
    public QuizChoiceAction(Tutor myTutor,boolean isRadio,String prompt,String[] options) {
        this(myTutor);
        setIsRadio(isRadio);
        setPrompt(prompt);
        setOptions(options);
    }
    public void doAction() {
        getTutor().giveQuizChoice(this);
    }
    public ArrayList<String> getOptions() {
        return myOptions;
    }
    public void setOptions(ArrayList<String> options) {
        myOptions=options;
    }
    public void setOptions(String[] options) {
        myOptions=new ArrayList<String>();
        for(String o : options) {
            addOption(o);
        }
    }
    public void addOption(String option) {
        myOptions.add(option);
    }
    public String getPrompt() {
        return myPrompt;
    }
    public void setPrompt(String prompt) {
        myPrompt=prompt;
    }
    public boolean getIsRadio() {
        return isRadio;
    }
    public void setIsRadio(boolean isRadio) {
        this.isRadio=isRadio;
    }
}
