/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.actions;

import emt.tutor.TutorPanel;
import emt.tutor.Action;
import emt.tutor.Mapping;
import emt.tutor.Tutor;
import emt.tutor.percepts.NewQuestionPercept.QUESTIONCHECKER;
import emt.tutor.percepts.UnansweredFeedbackPercept;

/**
 *
 * @author David
 */
public class CreateNewQuestionAction extends Action {
    public CreateNewQuestionAction() {
        
    }
    public CreateNewQuestionAction(Tutor myTutor) {
        super(myTutor);
    }
    
    public void doAction() {
        System.out.println("Creating new question mapping...");
        FeedbackPromptAction fpa1=new FeedbackPromptAction(getTutor());
        fpa1.setPrompt(QUESTIONCHECKER.CURRENTQUESTION);
        UnansweredFeedbackPercept ufp=new UnansweredFeedbackPercept(getTutor());
        ufp.setFeedbackActionPrompt(fpa1);
        FocusTutorAction fta1=new FocusTutorAction(getTutor());
        ChangePictureAction cpa1=new ChangePictureAction(getTutor(),"interested-front-bulb");
        MultipleAction ma1=new MultipleAction(getTutor(),new Action[]{fpa1,fta1,cpa1});
        getTutor().addMapping(new Mapping(ufp,ma1),true);
        System.out.println("New mapping added!");
    }
}
