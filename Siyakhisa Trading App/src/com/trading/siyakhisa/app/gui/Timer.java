/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.siyakhisa.app.gui;

import java.util.Date;
import javax.swing.JLabel;

/**
 *
 * @author Thato Keith Kujwane
 */
public class Timer implements Runnable{
    private final JLabel timeDisplay;
    private volatile boolean isAlive = true;
    
    public Timer(JLabel timeDisplay) {
        this.timeDisplay = timeDisplay;
    }
    
    public boolean isAlive(){
        return isAlive;
    }
    
    public void stop(){
        isAlive = false;
    }
    
    @Override
    public void run() {
        while(isAlive()){
            timeDisplay.setText("" + new Date());
        }
    }
}
