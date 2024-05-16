package Program;
import java.util.Scanner;

public class Wahhaha {
	public void heapSort(int arr[])
    {
        int temp;
 
        for (int i = arr.length / 2 - 1; i >= 0; i--)              
            heapify(arr, arr.length, i);

        for (int i = arr.length - 1; i > 0; i--) {
            temp = arr[0];                                                  
            arr[0] = arr[i];
            arr[i] = temp;
            heapify(arr, i, 0);                                            
        }
    }
 
    void heapify(int arr[], int n, int i)
    {
        int MAX = i; 
        int left = 2 * i + 1; 
        int right = 2 * i + 2; 
        int temp;

        if (left < n && arr[left] > arr[MAX])            
            MAX = left;
        if (right < n && arr[right] > arr[MAX])            
            MAX = right;
        if (MAX != i) {                                              
            temp = arr[i];
            arr[i] = arr[MAX];
            arr[MAX] = temp;
            heapify(arr, n, MAX);
        }
    }
 
    void display(int arr[]) {  
        for (int i=0; i<arr.length; ++i) 
            System.out.print(arr[i]+" ");
    } 
 
    public static void main(String args[]) {
    	
    	Scanner input = new Scanner(System.in);
    	
    	for (int i=0; i<20; i++) {
    		arr[i] = input.nextInt();
    	}
    	
        int arr[] = { 1, 12, 9 , 3, 10, 15, 18, 23,30,43,40 };
 
        Wahhaha ob = new Wahhaha();
        ob.heapSort(arr);
        ob.display(arr);
    }
}
