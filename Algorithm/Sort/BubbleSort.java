/*
冒泡排序
通过与相邻元素的比较和交换来把小的数交换到最前面
*/

class BubbleSort {
	
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
		
		for (int i = num - 1;i > 0;i--) {
			
			for (int j = 0;j < num - 1;j++) {
				
				if (a[j]> a[j+1]) {
					int temp = a[j];
					a[j] = a[j+1];
					a[j+1] = temp;
				}
				
			}
			
		}
		
		for (int i = 0;i < num;i++) {
			System.out.println(a[i]);
		}
		
		
	}
	
}