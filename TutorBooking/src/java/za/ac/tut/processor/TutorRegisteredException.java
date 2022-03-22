/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.processor;

/**
 *
 * @author Thato Keith Kujwane
 */
public class TutorRegisteredException extends Exception {

    public TutorRegisteredException() {
    }

    public TutorRegisteredException(String message) {
        super(message);
    }

    public TutorRegisteredException(String message, Throwable cause) {
        super(message, cause);
    }

    public TutorRegisteredException(Throwable cause) {
        super(cause);
    }

    public TutorRegisteredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
    
}
