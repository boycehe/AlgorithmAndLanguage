/*
	归并排序
	利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）策略（分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修补"在一起，即分而治之)。
*/


class MergeSort {
	
	public static void main(String[] args) {
		
		int[] list = {2,1,4,11,22,5,9,7,10,6,8,21};
		
	
		
		start(list);
		
	}
	
	public  static void start(int[] a){
	
		int []temp = new int[a.length];
		sort(a, 0, a.length-1, temp);
		
		for (int i = 0;i < a.length;i++) {
			System.out.println(a[i]);
		}
		
	}
	
	
	public static void sort(int[] arr,int left,int right,int[] temp){
		
		if (left < right) {
			int mid = (left + right)/2;
			sort(arr, left, mid, temp);
			sort(arr, mid+1, right, temp);
			merge(arr, left, mid, right, temp);
		}
	
	}
	
	
	public  static  void merge(int[] arr, int left ,int mid ,int right,int[] temp){
		
		int leftIndex  = left;
		int rightIndex = mid+1;
		int index 	   = 0;
		
		while (leftIndex <= mid && rightIndex <= right) {
			
			if (arr[leftIndex] <= arr[rightIndex]) {
				temp[index++] = arr[leftIndex++];
			}else {
				temp[index++] = arr[rightIndex++];
			}
			
		}
		
		while (leftIndex <= mid) {
			temp[index++] = arr[leftIndex++];
		}
		
		while (rightIndex <= right) {
			temp[index++] = arr[rightIndex++];
		}
		
		index = 0;
		
		while (left <= right) {
			arr[left++] = temp[index++];
		}
		
		
		
		
	}
}