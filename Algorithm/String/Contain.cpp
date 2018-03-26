#include <iostream>

using namespace std;


/*
给定两个分别由字母组成的字符串A和字符串B，字符串B的长度比字符串A短。请问，如何最快地判断字符串B中所有字母是否都在字符串A里？
比如，如果是下面两个字符串：

String 1：ABCD

String 2：BAD

答案是true，即String2里的字母在String1里也都有，或者说String2是String1的真子集。
如果是下面两个字符串：
String 1：ABCD
String 2：BCE
答案是false，因为字符串String2里的E字母不在字符串String1里。
*/

bool StringContain(string &a,string &b)
{
	const int p[26] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59,61, 67, 71, 73, 79, 83, 89, 97, 101};
	int f = 1;
	for (int i = 0; i < a.length(); ++i)
	{
		int x = p[a[i] - 'A'];
		if (f % x)
		{
			f *= x;
		}
	}
	for (int i = 0; i < b.length(); ++i)
	{
		int x = p[b[i] - 'A'];
		if (f % x)
		{
			return false;
		}
	}
	return true;
}


int main(int argc, char *argv[]) {
	
}