/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.knnmedium;

import java.io.*;
import java.util.*;


/**
 *
 * @author owner
 */
public class KNNMedium {
    

    public static void main(String[] args) {
        
        String filePath = "";
        // CHANGE THE ABOVE DEPENDING ON PATH
        
        
        List<DataPoint> dataPoints = loadCSV(filePath);

        if (dataPoints == null) {
            System.out.println("Failed to load data.");
            return;
        }

        double[] testPoint = {4.9, 3.0, 1.4}; // Change this to be any test point.
        int k = 3;
        
        String predictedLabel = classify(dataPoints, testPoint, k);
        System.out.println("Predicted label: " + predictedLabel);
    }

    public static List<DataPoint> loadCSV(String filePath) {
        List<DataPoint> dataPoints = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine(); // Skip header line

            while ((line = reader.readLine()) != null) {
                
                String[] parts = line.split(",");
                double[] features = new double[parts.length - 1];
                for (int i = 0; i < features.length; i++) {
                    features[i] = Double.parseDouble(parts[i]);
                }
                String label = parts[parts.length - 1];
                dataPoints.add(new DataPoint(features, label));
            }
        } catch (IOException e) {
            System.out.println("Error reading CSV file: " + e.getMessage());
            return null;
        }

        return dataPoints;
    }

    public static String classify(List<DataPoint> dataPoints, double[] testPoint, int k) {
        List<DataPoint> neighbors = new ArrayList<>();
        List<Double> distances = new ArrayList<>();

        for (DataPoint dp : dataPoints) {
            double distance = calculateDistance(dp.getFeatures(), testPoint);
            distances.add(distance);
            neighbors.add(dp);
        }

        // Sort by distance
        for (int i = 0; i < distances.size() - 1; i++) {
            for (int j = i + 1; j < distances.size(); j++) {
                
                if (distances.get(i) > distances.get(j)) {
                    
                    double tempDistance = distances.get(i);
                    
                    distances.set(i, distances.get(j));
                    distances.set(j, tempDistance);

                    DataPoint tempPoint = neighbors.get(i);
                    neighbors.set(i, neighbors.get(j));
                    neighbors.set(j, tempPoint);
                }
            }
        }

        // Get top k neighbors
        Map<String, Integer> labelCounts = new HashMap<>();
        
        for (int i = 0; i < k; i++) {
            
            String label = neighbors.get(i).getLabel();
            labelCounts.put(label, labelCounts.getOrDefault(label, 0) + 1);
        }

        // Find the most common label
        String predictedLabel = null;
        
        int maxCount = 0;
        
        for (Map.Entry<String, Integer> entry : labelCounts.entrySet()) {
            
            if (entry.getValue() > maxCount) {
                
                maxCount = entry.getValue();
                predictedLabel = entry.getKey();
            }
        }

        return predictedLabel;
    }

    public static double calculateDistance(double[] point1, double[] point2) {
        
        double sum = 0.0;
        
        for (int i = 0; i < point1.length; i++) {
            
            sum += Math.pow(point1[i] - point2[i], 2);
        }
        
        return Math.sqrt(sum);
    }
    
}
