package helloWorld.java;

import java.util.Random;

class java {
	
	public static int int_random;
	
    public static void main(String args[] ) {

      Random rand = new Random(); 
      int lowerbound = 0;
      int upperbound = 5;
      
      int_random = rand.nextInt(lowerbound, upperbound); 

      System.out.println(int_random);
      
      randomName();
      
      float numl =1000000.00000f; 
      System.out.println(numl);
    }
    
    static void randomName() {
      	String[] name = {"john","paul", "david", "noel", "bisaya"}; 
      	System.out.println(name[int_random]);
      }
    
}
