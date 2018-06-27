import java.time.temporal.*;
import java.util.*;
import java.awt.*;

/*
桶排序(Bucket sort)或所谓的箱排序，是一个排序算法，工作的原理是将数组分到有限数量的桶子里。 每个桶子再个别排序（有可能再使用别的排序算法或是以递归方式继续使用桶排序进行排序
其中计数排序为桶排序的一种
*/

class Bucket {
	
	ArrayList<Integer> list = new ArrayList<Integer>(); 
	
	public void push(int a){
		
		list.add(a);
		
	}
	
	public int pop(){
		
		if (list.size() == 0) {
			return - 1;
		}
		
		int a = list.get(list.size() -1);
		list.remove(list.size() -1);
		return a;
	}
	
	public  void sort(){
	
		
		
		for (int i = 1;i< list.size();i++) {
			
			int m = list.get(i);
			
			for (int j = i-1;j>=0;j--) {
				
				if (m < list.get(j)) {
					
					list.set(j+1, list.get(j));
					list.set(j,m);
					
					
					
				}else {
					break;
				}
				
				
			}
		

		}
		
	
	}
	
}

class BucketSort {
	
	
	
	
	public static void main(String[] args) {
		
			int[] list = new int[12];
			list[0]  = 2;
			list[1]  = 1;
			list[2]  = 4;
			list[3]  = 11;
			list[4]  = 22;
			list[5]  = 5;
			list[6]  = 9;
			list[7]  = 7;
			list[8]  = 10;
			list[9]  = 6;
			list[10] = 8;
			list[11] = 21;
			
			sort(list, 12, 5);
			
		
	}
	
	
	public static  void sort(int[] a,int len,int num){

		Bucket[] temp = new Bucket[num];
		for (int i = 0;i < num;i++) {
			temp[i] = new Bucket();
		}
		
		for (int i = 0;i < len;i ++) {
			
			Bucket buk = temp[(int)(a[i]/num)];
			buk.push(a[i]);
			
		}
		
		for (int i = 0;i < num;i++) {
			
			Bucket buk = temp[i];
			buk.sort();
			
			
		}
		
			int index = len-1;
		
			for (int j = num - 1;j >= 0;j--) {
				
				Bucket buk = temp[j];
				
				while (true) {
					int m = buk.pop();
					
					if (m == -1) {
						break;
					}
					
					a[index] = m;
					index--;
				} 
				
				
			}
			
			
			for (int k = 0;k < len;k++) {
				System.out.println(a[k]);
			}
			
	
	
	

	}
	
}