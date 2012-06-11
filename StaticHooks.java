/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package emt.tutor;

import java.util.Hashtable;

/**
 *
 * @author David
 */
public class StaticHooks {
    private static Hashtable TUTORS=new Hashtable();
    
    public static void addTutor(Tutor tutor) {
        TUTORS.put(tutor.getName(), tutor);
    }
    public static void alertTutor(String tutorName) {
        if(TUTORS.containsKey(tutorName)) {
            ((Tutor)TUTORS.get(tutorName)).checkMappings();
        }
    }
}
