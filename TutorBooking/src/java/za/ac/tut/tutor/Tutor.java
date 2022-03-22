/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package za.ac.tut.tutor;

/**
 *
 * @author Thato Keith Kujwane
 */
public class Tutor {
    private final String name, surname, emailAddress, identityNumber, cellphoneNumber;

    public Tutor(String name, String surname, String emailAddress, String identityNumber, String cellphoneNumber) {
        this.name = name;
        this.surname = surname;
        this.emailAddress = emailAddress;
        this.identityNumber = identityNumber;
        this.cellphoneNumber = cellphoneNumber;
    }

    public String getName() {
        return name;
    }


    public String getSurname() {
        return surname;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    

    public String getIdentityNumber() {
        return identityNumber;
    }   
        
    public String getCellphoneNumber() {
        return cellphoneNumber;
    }

    @Override
    public String toString() {
        return "Tutor{" + "name=" + name + ", surname=" + surname + ", emailAddress=" + emailAddress + ", identityNumber=" + identityNumber + ", cellphoneNumber=" + cellphoneNumber + '}';
    }
}
