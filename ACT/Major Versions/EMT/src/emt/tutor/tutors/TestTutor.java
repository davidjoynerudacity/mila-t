/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor.tutors;

import emt.ProjectModelPanel;
import emt.tutor.*;
import emt.tutor.actions.*;
import emt.tutor.actions.quiz.*;
import emt.tutor.percepts.*;
import emt.tutor.percepts.modelpercepts.*;

/**
 *
 * @author David
 */
public class TestTutor extends OnDemandTutor {
    public TestTutor() {
        super("Guide");
        
        initializeTutor();
    }

    public TestTutor(ProjectModelPanel modelPanel) {
        super("Guide",modelPanel);
        
        initializeTutor();
    }
    
    public void initializeTutor() {
        addImage("amazed-front", "j-amazed-front.jpg");
        addImage("amazed-side", "j-amazed-side.jpg");
        addImage("concerned-front", "j-concerned-front.jpg");
        addImage("concerned-side", "j-concerned-side.jpg");
        addImage("confused-front", "j-confused-front.jpg");
        addImage("confused-side", "j-confused-side.jpg");
        addImage("excited-front", "j-excited-front.jpg");
        addImage("excited-side", "j-excited-side.jpg");
        addImage("happy-front", "j-happy-front.jpg");
        addImage("happy-side", "j-happy-side.jpg");
        addImage("interested-front", "j-interested-front.jpg");
        addImage("interested-side", "j-interested-side.jpg");
        addImage("neutral-front", "j-neutral-front.jpg");
        addImage("neutral-side", "j-neutral-side.jpg");
        
        ChangePictureAction cpaAmazedFront=new ChangePictureAction(this,"amazed-front");
        ChangePictureAction cpaAmazedSide=new ChangePictureAction(this,"amazed-side");
        ChangePictureAction cpaConcernedFront=new ChangePictureAction(this,"concerned-front");
        ChangePictureAction cpaConcernedSide=new ChangePictureAction(this,"concerned-side");
        ChangePictureAction cpaConfusedFront=new ChangePictureAction(this,"confused-front");
        ChangePictureAction cpaConfusedSide=new ChangePictureAction(this,"confused-side");
        ChangePictureAction cpaExcitedFront=new ChangePictureAction(this,"excited-front");
        ChangePictureAction cpaExcitedSide=new ChangePictureAction(this,"excited-side");
        ChangePictureAction cpaHappyFront=new ChangePictureAction(this,"happy-front");
        ChangePictureAction cpaHappySide=new ChangePictureAction(this,"happy-side");
        ChangePictureAction cpaInterestedFront=new ChangePictureAction(this,"interested-front");
        ChangePictureAction cpaInterestedSide=new ChangePictureAction(this,"interested-side");
        ChangePictureAction cpaNeutralFront=new ChangePictureAction(this,"neutral-front");
        ChangePictureAction cpaNeutralSide=new ChangePictureAction(this,"neutral-side");
        
        TruePercept tp1=new TruePercept(this);
        /*TextFeedbackAction tfa2=new TextFeedbackAction(this,"Test feedback.");
        TextFeedbackAction tfa3=new TextFeedbackAction(this,"More test feedback.");
        tfa2.setNextAction(tfa3);
        addMapping(new Mapping(tp1,tfa2));*/
        
        QuizQuestionSet qqs1=new QuizQuestionSet(this);
        
        qqs1.addQuestion(new QuizTextAction(this,"Please enter your name."));
        qqs1.addQuestion(new QuizTextAction(this,"Please enter your teacher's name."));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"Please select your gender.",new String[]{"Male","Female"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"Please select your ethnicity.",new String[]{"African-American","American Indian/Alaska Native","Asian","Hispanic/Latino","White","Other"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"How important are good grades to you?",new String[]{"Not Important","Not Very Important","Somewhat Important","Very Important","Extremely Important"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"A job as a scientist would be interesting.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"I have a good feeling toward science.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"Working in a science laboratory would be an interesting way to make a living.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"I would like to be a scientist when after I complete my school.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"Science teachers are willing to give us individual help.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"Science is something that I enjoy very much.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"Sometimes I read ahead in our science book.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"I feel tense when someone talks to me about science.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"When I finish school, I would like to work with people who make discoveries in science.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"A career in science would be dull and boring.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"I would dislike being a scientist after I complete my school.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"Science teachers present material in a clear way.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"It makes me nervous to even think about doing science.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"I would dislike a job in a science laboratory after I leave school.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"A job as a scientist would be boring.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"I would dislike becoming a scientist because it needs too much education.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"I like the challenge of science assignments.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"When I hear the word science, I have a feeling of dislike.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"I would like to teach science when I leave school.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"It scares me to have to take a science class.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"Science is one of my favorite subjects.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"Science teachers make science interesting.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"I have a real desire to learn science.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"I would like to do some extra or un-assigned reading in science.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"It is important to me to understand the work that I do in science class.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"I would prefer to find out why something happens by doing an experiment than by being told.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"Doing experiments is not as good as finding out information from teachers.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"I would prefer to do experiments than to read about them.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"I would rather agree with other people than do an experiment to find out for myself.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"I would prefer to do my own experiments than to find out information from a teacher.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"I would rather find out about things by asking an expert than by doing an experiment.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"I would rather solve a problem by doing an experiment than be told the answer.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"It is better to ask the teacher the answer than to find it out by doing experiments.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"I would prefer to do an experiment on a topic than to read about it in science magazines.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"It is better to be told scientific facts than to find them out from experiments.",new String[]{"I strongly agree","I agree","I am not sure","I disagree","I strongly disagree"}));
        qqs1.addQuestion(new QuizChoiceAction(this,false,"Which of these courses would you be interested in taking? Check all that apply.",new String[]{"Astronomy","Biology","Chemistry","Earth Science","Environmental Science","Physics"}));
        qqs1.addQuestion(new QuizChoiceAction(this,false,"Which of these courses would you be interested in taking? Check all that apply.",new String[]{"Geobiology","Algebra","Geometry","Trigonometry","Calculus","Astrotrigology"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"How interested are you in a career in Agriculture and Natural Resources (like park rangers, farmers, gardeners)?",new String[]{"Not interested at all","Not very interested","Unsure","Interested","Very interested"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"How interested are you in a career in Architecture and Construction (like builders, planners, architects)?",new String[]{"Not interested at all","Not very interested","Unsure","Interested","Very interested"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"How interested are you in a career in Arts, Entertainment, Sports, Communications, and Tourism (like chefs, athletes, artists, singers, fashion designers, travel agents)?",new String[]{"Not interested at all","Not very interested","Unsure","Interested","Very interested"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"How interested are you in a career in Business and Marketing (like accountants, file clerks, office managers, and receptionists)?",new String[]{"Not interested at all","Not very interested","Unsure","Interested","Very interested"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"How interested are you in a career in Education and Counseling (like coaches, teachers, librarians, psychologists)?",new String[]{"Not interested at all","Not very interested","Unsure","Interested","Very interested"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"How interested are you in a career in Finance (like bank tellers, economists, financial managers, insurance agents)?",new String[]{"Not interested at all","Not very interested","Unsure","Interested","Very interested"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"How interested are you in a career in Government, Law, Security (like lawyers, police, inspectors, politicians, postal clerks)?",new String[]{"Not interested at all","Not very interested","Unsure","Interested","Very interested"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"How interested are you in a career in Medicine (like nurses, doctors, physical therapists, dentists)?",new String[]{"Not interested at all","Not very interested","Unsure","Interested","Very interested"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"How interested are you in a career in Manufacturing and Repair (like forklift operators, tailors, welders)?",new String[]{"Not interested at all","Not very interested","Unsure","Interested","Very interested"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"How interested are you in a career in Science and Engineering (like scientists, engineers, computer programmers)?",new String[]{"Not interested at all","Not very interested","Unsure","Interested","Very interested"}));
        qqs1.addQuestion(new QuizChoiceAction(this,true,"How interested are you in a career in Transportation (like pilot, truck driver, auto mechanic)?",new String[]{"Not interested at all","Not very interested","Unsure","Interested","Very interested"}));
        qqs1.addQuestion(new QuizTextAction(this,"Are there any careers you are particularly interested in that were not listed? If so, put them here:"));
        qqs1.addQuestion(new QuizTextAction(this,"Which experiment/activity did you enjoy the most?  Why?"));
        qqs1.addQuestion(new QuizTextAction(this,"Which experiment/activity was the most difficult?  Why?"));
        qqs1.addQuestion(new QuizTextAction(this,"If you could change ONE thing about this activity, what would it be?"));
        qqs1.addQuestion(new QuizTextAction(this,"What changes would you make to the software we have been using?"));
        GiveQuizAction gqa1=new GiveQuizAction(this);
        gqa1.setQuizQuestionSet(qqs1);
        
        QuizQuestionSet qqs2=new QuizQuestionSet(this);
        qqs2.addQuestion(new QuizChoiceAction(this,true,"A valid hypothesis in any scientific experiment must be:",new String[]{"believable","put in the form of a question","testable","based on past valid experimentation"}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"A hypothesis is:",new String[]{"a possible, tentative answer to a question","a theory","an accepted belief that has been tested","a false belief that must be tested"}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"A theory is:",new String[]{"a re-creation of an event","an explanation for a phenomena","a plausible, scientifically accepted generalization","a questionable explanation for a natural phenomenon"}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"An example of an abiotic factor in an environment is:",new String[]{"soil/water chemistry","bacteria","plants","other animals"}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"An example of a biotic factor in an environment is:",new String[]{"sunlight","plants","oxygen","temperature"}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"What is the definition of an ecosystem?",new String[]{"an un-natural unit consisting of plants, animals, and micro-organisms in an area functioning together with the non-living physical factors of the environment.","A natural unit consisting on plants, animals, and micro-organisms in an area functioning together with the non-living physical factors of the environment.","A natural unit consisting of plants, animals, and micro-organisms in an area functioning separately from the non-living physical factors of the environment."}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"Which of the following is a part of an ecosystem that can be removed without affecting the ecosystems functionality?",new String[]{"plants","water","sunlight","none of the above"}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"Bacteria play a vital role in Earth’s ecosystems by",new String[]{"using oxygen","producing acetone","decomposing dead organisms","concentrating valuable minerals"}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"Bacteria are essential to life because they _________________ nutrients for living things.",new String[]{"recycle","deposit","digest","engulf"}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"True or false: a scientific phenomenon is any event that is observed.",new String[]{"True","False"}));
        qqs2.addQuestion(new QuizChoiceAction(this,false,"What makes a good explanation for a phenomenon? You may select more than one.",new String[]{"It provides a causal mechanism that results in the observed phenomenon.","It is better than all other competing explanations.","It is supported by evidence."}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"What phenomena are worth modeling?",new String[]{"All phenomena are worth modeling.","Only serious phenomena are worth modeling.","Any unexpected and unexplained phenomenon is worth modeling."}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"True or false: a system has a large number of interacting parts.",new String[]{"True","False"}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"True or false: a model specifies a mechanism that explains a phenomenon.",new String[]{"True","False"}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"What is a mechanism?",new String[]{"A causal process that results in an outcome.","A state of a system.","An invisible part of a system."}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"What is a component?",new String[]{"A part of a system.","A visible part of a system."}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"True or false: a variable is a property of a system or a property of a component of a system.",new String[]{"True","False"}));
        qqs2.addQuestion(new QuizChoiceAction(this,false,"How might a model lead to collection of additional data?",new String[]{"A model may be incomplete and completion of the model may require data.","A part of a model may require data as supporting evidence."}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"What is the advantage of abstractions in a model?",new String[]{"Abstractions allow zooming-in and zooming out.","Abstractions hide details so that you can focus on the important things."}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"True or false: a model can be accepted if it explains the phenomenon and there is evidence in support of it.",new String[]{"True","False"}));
        qqs2.addQuestion(new QuizChoiceAction(this,true,"What is the exit point for model construction?",new String[]{"When all hypotheses have been enumerated.","When all hypotheses have been examined.","When an explanation for the phenomenon has been found."}));
        GiveQuizAction gqa2=new GiveQuizAction(this);
        gqa2.setQuizQuestionSet(qqs2);
        
        QuestionListAction qla1=new QuestionListAction(this);
        qla1.addQuestion(new QuestionItem("I'd like to take the attitudinal survey.",gqa1));
        qla1.addQuestion(new QuestionItem("I'd like to take the content test.",gqa2));
        
        addMapping(new Mapping(tp1,qla1));
        
        //        QuizChoiceAction qca1=new QuizChoiceAction(this);
//        qca1.setPrompt("Sample radio question.");
//        qca1.addOption("1");
//        qca1.addOption("2");
//        qca1.addOption("3");
//        qca1.addOption("4");
//        qca1.addOption("5");
//        qca1.addOption("6");
//        qca1.setIsRadio(true);
//        
//        QuizChoiceAction qca2=new QuizChoiceAction(this);
//        qca2.setPrompt("Sample checkbox question.");
//        qca2.addOption("1");
//        qca2.addOption("2");
//        qca2.addOption("3");
//        qca2.setIsRadio(false);
//        
//        QuizTextAction qta1=new QuizTextAction(this);
//        qta1.setPrompt("Sample text question.");
//        
//        QuizTextAction qta2=new QuizTextAction(this);
//        qta2.setPrompt("Another sample text question.");
//        
//        qqs.addQuestion(qca1);
//        qqs.addQuestion(qca2);
//        qqs.addQuestion(qta1);
//        qqs.addQuestion(qta2);
        
//        GiveQuizAction gqa=new GiveQuizAction(this);
//        gqa.setQuizQuestionSet(qqs1);
        
//        Mapping m2=new Mapping(tp1,gqa);
//        addMapping(m2);
        
        /* END LESSON-SPECIFIC CONTENT ****************************************/
        
        TextFeedbackAction tfa1=new TextFeedbackAction(this,"I don't really have anything to say right now.");
        Mapping m1=new Mapping(tp1,new MultipleAction(this,new Action[]{cpaNeutralSide,tfa1}));
        addMapping(m1);
        

        
    }
}
