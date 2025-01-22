/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.knnmedium;

/**
 *
 * @author owner
 */
public class DataPoint {
    
    double[] features;
    String label;
    
    public DataPoint(double[] features, String label) {
        
        this.features = features;
        this.label = label;
        
    }
    
    public double[] getFeatures() {
        
        return features;
    }
    
    public String getLabel() {
        
        return label;
    }
    
}
