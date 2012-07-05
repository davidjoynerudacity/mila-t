/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor;

/**
 *
 * @author David
 */
public class QuestionItem {
    private String myQuestion;
    private Action myAction;
    
    public QuestionItem() {
        myQuestion="";
        myAction=null;
    }
    public QuestionItem(String question) {
        this();
        myQuestion=question;
        myAction=null;
    }
    public QuestionItem(String question,Action action) {
        this(question);
        myAction=action;
    }
    
    public void setQuestion(String question) {
        myQuestion=question;
    }
    public void setAction(Action action) {
        myAction=action;
    }
    public String getQuestion() {
        return myQuestion;
    }
    public Action getAction() {
        return myAction;
    }
}
