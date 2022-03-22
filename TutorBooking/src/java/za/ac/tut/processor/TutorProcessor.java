/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.processor;

import java.util.LinkedList;
import za.ac.tut.tutor.Tutor;

/**
 *
 * @author Thato Keith Kujwane
 */
public class TutorProcessor {
    private final LinkedList<Tutor> tutorsList;

    public TutorProcessor(LinkedList<Tutor> tutorsList) {
        this.tutorsList = tutorsList;
    }

    public LinkedList<Tutor> getTutorsList() {
        return tutorsList;
    }
    
    public void addTutor(Tutor t) throws TutorRegisteredException{
        if (tutorExists(t)){
            throw new TutorRegisteredException("Tutor with email address " + t.getEmailAddress() + " already exists.");
        }
        tutorsList.add(t);
    }
    
    private boolean tutorExists(String emailAddress){
        for (Tutor t : tutorsList){
            if (t.getEmailAddress().equalsIgnoreCase(emailAddress)){
                return true;
            }
        }
        
        return false;
    }
    
    private boolean tutorExists(Tutor t){
        return this.tutorExists(t.getEmailAddress());
    }
    
    public Tutor getLastTutor(){
        return this.tutorsList.getLast();
    }
}
