
/*
希尔排序的思想是使数组中任意间隔为 h 的元素都是有序的。这样的数组被称为 h 有序数组。换 句话说，一个 h 有序数组就是 h 个互相独立的有序数组编织在一起组成的一个数组(见图 2.1.2)。 在进行排序时，如果 h 很大，我们就能将元素移动到很远的地方，为实现更小的 h 有序创造方便。用 这种方式，对于任意以 1 结尾的 h 序列，我们都能够将数组排序
*/

class ShellSort {
	
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
			sort(list,12);
			
	}
	
	public  static void sort(int[] a,int num){
		
		int h = 1;
		
		while (h < num/3) {
			h = 3*h+1;
		}
		
		while (h >= 1) {
			
			for (int i = h; i < num;i++) {
				
				for (int j = i;j >= h;j = j - h) {
					int temp = a[j];
					if (a[j] < a[j-h]) {
						a[j] = a[j-h];
						a[j-h] = temp;
					}else {
						break;
					}
					
				}
				
			}
			h = h/3;
		}
		
		
		for (int i = 0;i < num;i++) {
			System.out.println(a[i]);
		}
		
	}
	
}