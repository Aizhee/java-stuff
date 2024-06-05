package cher;

import java.lang.Math;

//Trigonometric calculator class extending DialogManager to display messages
public class TrigonometryFunction extends DialogManager {
 // Method to calculate sum of angles for sine
 public static double sineSum(double angle1, double angle2) {
     return round(Math.sin(angle1 + angle2));
 }

 // Method to calculate difference of angles for sine
 public static double sineDifference(double angle1, double angle2) {
     return round(Math.sin(angle1 - angle2));
 }

 // Method to calculate product of angles for sine
 public static double sineProduct(double angle1, double angle2) {
     return round(0.5 * (Math.cos(angle1 - angle2) - Math.cos(angle1 + angle2)));
 }

 // Method to calculate sum of angles for cosine
 public static double cosineSum(double angle1, double angle2) {
     return round(Math.cos(angle1) * Math.cos(angle2) - Math.sin(angle1) * Math.sin(angle2));
 }

 // Method to calculate difference of angles for cosine
 public static double cosineDifference(double angle1, double angle2) {
     return round(Math.cos(angle1) * Math.cos(angle2) + Math.sin(angle1) * Math.sin(angle2));
 }

 // Method to calculate product of different trigonometric functions
 public static double trigProduct(String function1, String function2, double angle1, double angle2) {
     if (function1.equals("Sine") && function2.equals("Sine")) {
         return round(Math.sin(angle1) * Math.sin(angle2));
     } else if (function1.equals("Sine") && function2.equals("Cosine")) {
         return round(Math.sin(angle1) * Math.cos(angle2));
     } else if (function1.equals("Cosine") && function2.equals("Sine")) {
         return round(Math.cos(angle1) * Math.sin(angle2));
     } else { // Cosine & Cosine
         return round(Math.cos(angle1) * Math.cos(angle2));
     }
 }

 // method to round off the result to the nearest 11th decimal
 static double round(double value) {
     double scale = Math.pow(10, 11);
     return Math.round(value * scale) / scale;
 }
}