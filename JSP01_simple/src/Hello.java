import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class Hello {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("111");
		
		int[] arr = {10, 20, 30};
		
		//ERROR
		//arr =  {450, 50, 60};
		
		arr = new int[] {450, 50, 60};
        System.out.println(Arrays.toString(arr));
        
        print("22", "eee");
        
        
        Integer[] arrInt = {1, 2, 3};
        ArrayList<Integer> arr5 = new ArrayList<Integer>();
        Collections.addAll(arr5, arrInt); // Добавляем массив
        Collections.addAll(arr5, 4, 5, 6); // Добавляем элементы
        
        ArrayList<Number> arr6 = new ArrayList<Number>();
        Collections.addAll(arr6, new Integer(12));
        Collections.addAll(arr6, new Double(12));
        
	}
	
	public static <T, U> void print(T obj1, U obj2) {
		System.out.println(obj1.toString());
		System.out.println(obj2.toString());
		//System.out.println(this.obj.toString());
	}

}
