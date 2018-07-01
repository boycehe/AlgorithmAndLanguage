/*
将整数按位数切割成不同的数字，然后按每个位数分别比较,他是桶排序的一种
将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。这样从最低位排序一直到最高位排序完成以后, 数列就变成一个有序序列
*/

class RadixSort {
	
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
		
		sort(list, 12);
		
		for (int i = 0;i < 12;i++) {
			System.out.println(list[i]);
		}
		
	}
	
	public static void sort(int a[],int num){
		
		int exp;    // 指数。当对数组按各位进行排序时，exp=1；按十位进行排序时，exp=10；...
		int max = getMax(a, num);    // 数组a中的最大值

		// 从个位开始，对数组a按"指数"进行排序
		for (exp = 1; max/exp > 0; exp *= 10)
			radix_sort(a, num, exp);
		
	}
	
	/*
	 * 对数组按照"某个位数"进行排序(桶排序)
	 *
	 * 参数说明：
	 *     a -- 数组
	 *     n -- 数组长度
	 *     exp -- 指数。对数组a按照该指数进行排序。
	 *
	 * 例如，对于数组a={50, 3, 542, 745, 2014, 154, 63, 616}；
	 *    (01) 当exp=1表示按照"个位"对数组a进行排序
	 *    (02) 当exp=10表示按照"十位"对数组a进行排序
	 *    (03) 当exp=100表示按照"百位"对数组a进行排序
	 *    ...
	 */
	
	public static void radix_sort(int a[],int n,int exp){
		
				int output[] = new int[n];
				int i;
				int buckets[] = new int[10];
				
				for (i = 0; i < n; i++)
				buckets[ (a[i]/exp)%10 ]++;
				
				for (i = 1; i < 10; i++)
				buckets[i] += buckets[i - 1];
				
				// 将数据存储到临时数组output[]中
				for (i = n - 1; i >= 0; i--)
				{
					output[buckets[ (a[i]/exp)%10 ] - 1] = a[i];
					buckets[ (a[i]/exp)%10 ]--;
				}
				
				// 将排序好的数据赋值给a[]
				    for (i = 0; i < n; i++)
					a[i] = output[i];

				
				
		
		
	}
	
	public static int getMax(int a[],int n){
		
		int i, max;

		max = a[0];
		for (i = 1; i < n; i++)
			if (a[i] > max)
				max = a[i];
		return max;
		
	}
}