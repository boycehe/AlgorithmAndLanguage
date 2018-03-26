#include <iostream>
#include <math.h>

using namespace std;


#define  PI 3.1415926 
int main(int argc, char *argv[]) {

	double ang = 0.0 ;  
		double  angle = 0.0 ;  
	  
		angle = atan2(2.0,1.0);              //63  
		ang = angle*180/PI ;  
		cout << ang <<endl ;  
	  
		angle = atan2(-2.0,1.0) ;     // -63 ， 4象限  
		ang = angle*180/PI ;  
		cout << ang <<endl ;  
	  
		angle = atan2(2.0,-1.0) ;            // 116  ，2象限  
		ang = angle*180/PI ;  
		cout << ang <<endl ;  
	  
		angle = atan2(-2.0,-1.0) ;            // -116   3象限  
		ang = angle*180/PI ;  
		cout << ang <<endl ;   
		cin.get();  
		return 0;  
	
}