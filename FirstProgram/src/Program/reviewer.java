package Program;

import java.util.Scanner;

public class reviewer {
	public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int key = generateKey();

        String encryptedMessage = "䰭䰪䰰䱎䰰䱐䰩䱝䰳䰻䰗䱑䰫䰩䰹䱛䰾䱠䱁䱞䰳䰺䰰䱐䰲䱔䱊䰚䰱䰗䱛䰹䰽䰗䰨䰝䰱䱐䰨䱝䰳䰾䰟䱒䰷䰺䱟䱋䰾䰭䰭䰨䰵䱑䰹䱓䰵䱡䱞䱔䰵䰯䰰䱟䰾䰬䰜䰶䰾䰫䱁䰒䱁䰹䰴䰛䰲䱐䱀䱏䰱䰨䰘䱈䰾䰗䰨䰝䰵䱑䱟䱑䰳䰺䰨䱠䰰䰮䰭䰶䰾䰭䱛䰯䰵䱐䰴䱟䱀䱞䱊䰴䰲䰪䰰䰬䱍䱏䰹䱔䰼䰺䰴䱐䰰䰫䰨䱟䰰䰻䰴䱡䰵䰼䰹䰪䰼䰹䱏䱡䰰䰫䱊䱚䰰䱐䱀䱑䰶䱠䰠䰲䰭䰬䰩䱊䰵䱕䰨䱔䰳䰫䰨䱘䱁䱟䱚䰺䱀䰾䰱䱞䱀䰩䱚䱋䰬䰸䱛䱎䱍䰚䰵䱠䰱䰗䰱䰮䰭䰭䰼䱔䰱䰪䰗䱔䰶䱑䱚䱜䰴䰺䰩䱁䰿䰽䱛䱈䱍䰿䰨䰹䰲䱡䰼䱏䰳䰯䰰䰛䰸䱒䰬䰼䰼䱑䱞䱐䱁䰻䱊䰘䰱䰪䰛䰟䰱䱎䰘䰬䰽䰼䱀䱕䱊䰪䱞䱛䱋䰫䱚䱝䰶䱡䰰䰵䰼䰼䰱䰹䰷䰺䰹䱒";

        // Decrypt the message
        String decryptedMessage = decrypt(encryptedMessage, key);
        System.out.println("Decrypted message: " + decryptedMessage);

        scanner.close();
    }

    private static int generateKey() {
   
    	// Constants for the key generation process
        final int[] constants = {23,26,3,75}; 
  
        int layer1 = (int) (6 % 5); 

        int layer2 = 0;
        for (int x=0; x < constants.length; x++) {
            int currentElementLayer =  constants[x] * layer1; 
            layer2 += currentElementLayer;
        }

        // Apply additional processing to get the preKey
        int preKey = evenOnly(constants, layer2);

        // Combine layers to generate the final key
        int key = (int) (preKey * layer1 * layer2);

        return key;
    }
    
    private static int evenOnly(int[] constants, int layer2) {
        int sum = 0;
        for (int currentConstant : constants) {
            if (currentConstant % 2 == 0) { 
                sum += layer2 + currentConstant; 
            }
        }
        return sum;
    }


    private static String decrypt(String encryptedMessage, int key) {
        StringBuilder decryptedMessage = new StringBuilder();

        for (char c : encryptedMessage.toCharArray()) {
            char decryptedChar = (char) (c - key);
            decryptedMessage.append(decryptedChar);
        }

        return decryptedMessage.toString();
    }
}

