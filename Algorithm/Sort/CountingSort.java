/*
计数排序(Counting sort)是一种稳定的线性时间排序算法。计数排序使用一个额外的数组C，其中第i个元素是待排序数组A中值等于i的元素的个数。然后根据数组C来将A中的元素排到正确的位置
计数排序 适合那些数据较多，但是最大值和最小值相差不大的数组
如果数据较少，而最大值却很大，则是非常消耗空间的，如1，83923497 是不是很绝望？
*/

class CountingSort {
	
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
		
		int[] list2 = sort(list, 12, 22);
		
		
		
		
	}
	
	
	public  static  int[] sort(int[] a,int n,int k){
		

		int[] c = new int[k+1];
		int i,value,pos;
		int[] b = new int[n];
		for(i = 0; i <= k; i++)  //初始化
			c[i] = 0;
			
		for(i = 0; i < n; i++)
			c[a[i]]++; 
		
		/*
		某个数在数组中多少位开始	
		0  	1  	2  	3  	4  	5
	   [2] [0] [1] [3] [1] [2]	
	  执行以下代码后变为
			0  	1  	2  	3  	4  	5
		   [2] [2] [3] [6] [7] [9]
		5中的9代表 5在数组中最高位置为9
		4的最高位置为7		
		*/
		for(i = 1; i <= k; i++)
			c[i] = c[i] + c[i - 1];
		
		
		
		for(i = n - 1; i >= 0; i--) {
			
			value = a[i];
			pos = c[value];
			b[pos - 1] = value;
			c[value]--;
			
		}
		
		return b;
		
		
	}
	
}