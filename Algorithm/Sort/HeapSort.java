import java.awt.*;

/*
堆排序就是把最大堆堆顶的最大数取出，将剩余的堆继续调整为最大堆，再次将堆顶的最大数取出，这个过程持续到剩余数只有一个时结束
*/

class HeapSort {
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

  
		sort(list);
		

		
	
		
	}
	
	public static  void sort(int a[]){
		
		buildMaxHeap(a, 12);
	
	
		for(int i = 11;i > 0;i--){
			
			swap(a, 0, i);
			maxHeap(a, 0, i);
			
		}
		
		for (int m = 0;m < 12;m++) {
			System.out.println(a[m]);
		}

		
	}
	
	public static  void buildMaxHeap(int a[],int heapSize){
		
		int parent = (int)Math.floor((heapSize-1)/2) - 1;
	
		for (int i = parent;i >=0;i--) {
			
			maxHeap(a, i, heapSize);
			
		}
		
	}
	
	public  static void swap(int a[],int m,int n){
		int temp = a[m];
		a[m] = a[n];
		a[n] = temp;
	}
	
	//把堆从index后边为最大堆
	public  static  void maxHeap(int[] a,int index,int heapSize){
		
		int imax  = index;
		
	
		//获取左节点index
		int left  = 2*index+1;
		//获取右节点index
		int right = 2*(index + 1);
		
		//若果左节点的值大于其父节点的值，则把imax赋值为left
		if (left < heapSize && a[imax] < a[left]) {
			imax = left;
		}
		
		//若果右节点的值大于其父节点的值，则把imax赋值为right
		if(right < heapSize && a[imax] < a[right]){
			imax = right;
		}
		
	//	boolean isSwap = false;
		
		if(imax != index){
			swap(a, imax, index);
			
//			String strr = isSwap?"yes":"no";
			maxHeap(a, imax, heapSize);//递归调整
//			isSwap = true;
		}
		
	
		
	}
	

	
}