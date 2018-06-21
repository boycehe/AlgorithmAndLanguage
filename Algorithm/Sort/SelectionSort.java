
/*
	选择排序，先找到数组中最小的那个元素，其次，将它和数组的第 一个元素交换位置(如果第一个元素就是最小元素那么它就和自己交换)。再次，在剩下的元素中 找到最小的元素，将它与数组的第二个元素交换位置。如此往复，直到将整个数组排序。这种方法 叫做选择排序，因为它在不断地选择剩余元素之中的最小者，因此他具有以下特点：
	1.运行时间和输入无关,无论是有序的还是无序所需运行时间是一样的
	2.数据移动是最少的
	 时间复杂度为N^2/2 
*/
class SelectionSort {
	
	public static void main(String[] args) {
	
	int[] list = new int[12];
	
	list[0] = 2;
	list[1] = 1;
	list[2] = 4;
	list[3] = 11;
	list[4] = 22;
	list[5] = 5;
	list[6] = 9;
	list[7] = 7;
	list[8] = 10;
	list[9] = 6;
	list[10] = 8;
	list[11] = 21;
	
	sort(list,12);
		
	}
	
	public  static void sort(int[] a,int num){
	
	for (int i = 0; i < num;i++) {
		
	
		int minIndex = i;
		
		for (int j = i+1;j < num;j++) {
			
			if (a[j] < a[minIndex]) {
				minIndex = j;
			}
			
		}
		int temp = a[minIndex];
		a[minIndex] = a[i];
		a[i] = temp;

	}	
	
	for (int i = 0;i < num;i++) {
		System.out.println(a[i]);
	}
	
	}
	
}