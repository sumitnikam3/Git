import java.util.*;
public class Heap{
	public void heapyfi(int arr[],int n,int i){//arr,9 , 3
		int largest = i; //3//1//4
		//99,89,34,11,55,33,88,44,22
		int left = 2*i+1;//7(index)//3 9
		int right = 2*i+2;//8(index)//4 10
		//   7<9(t)     88>44(true)/    1
		//  9 < 5
		if(left<n && arr[left] > arr[largest])
			//largest = 7
			largest = left;
			//8<9(t)       44>88          1 
		if(right<n && arr[right] > arr[largest])
			//largest = 8
		//    4
			largest = right;
			//4 != 1
			//4 == 4
		if(largest != i){ //8 != 3
             //temp  =       11			
			int temp = arr[i];
			//arr[i] = 88
			arr[i] = arr[largest];
			//arr[largest] = 11
			arr[largest] = temp;
			heapyfi(arr,n,largest);//arr,9,8
		}
	}
	public void heapSort(int arr[]){ //array parameter
		//   5  
		int n = arr.length; //Store length of array
		//           5/2 = 2-1 = 1
		for (int i = n/2-1;i>=0;i--){ //i = n/2-1 (we divide two sub parts of heap)
			heapyfi(arr,n,i); // arr , n(9) , i (9/2-1 = 3),
		}
		for(int i=n-1;i>=0;i--){
			int temp = arr[0];
			arr[0] = arr[i];
			arr[i] = temp;
			heapyfi(arr,i,0);
		}
	}
	
	public void display(int[] arr){
		for (int i = 0 ; i<arr.length;i++)
			System.out.print(arr[i]+" ");
	}
	public static void main(String args[]){
		Heap h1 = new Heap();
		//            0,1   2  3  4
		Scanner sc = new Scanner(System.in);
		int arr[] = new int[sc.nextInt()];
		for(int i=0;i<arr.length;i++){
			arr[i]=sc.nextInt();
		}
		h1.display(arr);
		h1.heapSort(arr);
		System.out.println();
		h1.display(arr);
	}
}