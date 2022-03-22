/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.trading.siyakhisa.service;

import java.io.Serializable;

/**
 *
 * @author Thato Keith Kujwane
 */
public final class Service implements Serializable{
    private int serviceID;
    private String name;
    private double pricePerUnit;
    private int totalUnits;
    private double totalCostOfService;

    public Service(int serviceID, String name, double pricePerUnit, int totalUnits, double totalCostOfService) {
        this.serviceID = serviceID;
        this.name = name;
        this.pricePerUnit = pricePerUnit;
        this.totalUnits = totalUnits;
        this.totalCostOfService = totalCostOfService;
    }

    public Service() {
    }

    public Service(int serviceID) {
        this.serviceID = serviceID;
    }

    public int getServiceID() {
        return serviceID;
    }

    public void setServiceID(int serviceID) {
        this.serviceID = serviceID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPricePerUnit() {
        return pricePerUnit;
    }

    public void setPricePerUnit(double pricePerUnit) {
        this.pricePerUnit = pricePerUnit;
    }

    public int getTotalUnits() {
        return totalUnits;
    }

    public void setTotalUnits(int totalUnits) {
        this.totalUnits = totalUnits;
    }

    public double getTotalCostOfService() {
        calculateTotalServiceCost();
        return totalCostOfService;
    }

    public void setTotalCostOfService(double totalCostOfService) {
        this.totalCostOfService = totalCostOfService;
    }

    @Override
    public String toString() {
        return "Service-" + this.serviceID + "%name-" + this.name + "%ppu-" + this.pricePerUnit + 
                "%unitsServiced-" + this.totalUnits + "%cost-" + getTotalCostOfService();
    }
    
    private void calculateTotalServiceCost(){
        totalCostOfService = pricePerUnit * totalUnits;
    }
}
