/*
快速排序
通过一趟扫描将要排序的数据分割成独立的两部分,其中一部分的所有数据都比另外一部分的所有数据都要小,然后再按此方法对这两部分数据分别进行快速排序,整个排序过程可以递归进行,以此达到整个数据变成有序序列
*/

class QuickSort {
	
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
		
		sort(list, 0, 11);
		
		for (int i = 0;i < 12;i++) {
			System.out.println(list[i]);
		}
		
	}
	
	
	public  static void sort(int[] a,int left,int right){
		
		if (left >= right) {
			return;
		}
		
		int i = left,j = right,x = a[left];
		
		while (i < j) {
			
			while (i < j && a[j]>= x) {
				j--;
			}
			
			if (i < j) {
				a[i++] = a[j];
			}
			
			
			while (i < j && a[i] < x) {
				i++;
			}
			
			if (i < j) {
				a[j--] = a[i];
			}
			
	
		}
		
		a[i] = x;
		
		sort(a, left, i-1);
		sort(a, i+1, right);
	
		
	}
	
}