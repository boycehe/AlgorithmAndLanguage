#include <stdio.h>

/*----------------暴力移位法begin--------------------*/
//字符串 ，字符长度

void leftShiftOne(char* s, int sLen)
{
	char t = s[0];  //保存第一个字符
	for (int i = 1; i < sLen; i++)
	{
		s[i - 1] = s[i];
		printf("%d:%s\n",i,s);
	}
	s[sLen - 1] = t;
	printf("end:%s\n",s);

}
//这里的时间复杂度为O(m*n)
void leftRotateStringA(char* s, int n, int m)
{
	while (m--)
	{
		leftShiftOne(s, n);
	}
}
/*----------------暴力移位法end--------------------*/
/*----------------三步移位法begin------------------*/
/*
时间复杂度为
*/
void reverseString(char *s,int from,int to){
	
	while (from < to) {
		
		char t = s[from];
		s[from++] = s[to];
		s[to--] = t;
		
	}
	printf("%s\n",s);
	
}

void leftRotateStringB(char *s,int n,int m){
	
	m %= n;
	reverseString(s,0,m-1);
	reverseString(s,m,n-1);
	reverseString(s,0,n-1);
}

/*----------------三步移位法end--------------------*/


int main(int argc, char *argv[]) {

	char s[10] = "abcdefg";
	leftRotateStringB(s,7,2);
	
}

