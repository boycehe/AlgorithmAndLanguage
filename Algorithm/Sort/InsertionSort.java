/*
插入排序
与选择排序一样，当前索引左边的所有元素都是有序的，但它们的最终位置还不确定，为了给 更小的元素腾出空间，它们可能会被移动。但是当索引到达数组的右端时，数组排序就完成了
对于随机排列的长度为 N 且主键不重复的数组，平均情况下插入排序需要~ N2/4 次比 较以及~ N2/4 次交换。最坏情况下需要~ N2/2 次比较和~ N2/2 次交换，最好情况下需要 N-1 次比较和 0 次交换

*/

class InsertionSort {
	
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
		
		int exch = 0;//记录交换次数
		int com  = 0;//记录比较次数
		
		for (int i = 1;i < num ;i++) {
			
			int m = a[i];
			int j;
			for (j = i - 1 ;j >= 0;j--) {
				
				com++;	
				if (a[j] > m ) {
					a[j+1] = a[j];
					exch++;
				}else {
					
					break;
				}
				
			}
			
			a[j+1] = m;
			
		}
		
		
		System.out.println("交换次数:"+exch);
		System.out.println("比较次数:"+com);
		
		for (int k = 0;k < num;k++) {
			System.out.println(a[k]);
		}
		
		
		
	}
	
}