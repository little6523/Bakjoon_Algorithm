#include <stdio.h>

int main(void) {

	int a, b, c, i, k;
	int num[10]={0, };
	scanf("%d", &a);
	scanf("%d", &b);
	scanf("%d", &c);
	k = a * b * c;

	while(k>0)
	{
		num[k%10] = num[k%10] + 1;
		k = k / 10;
	}
	
	for(i=0;i<10;i++)
	{
		printf("%d\n", num[i]);
	}

	return 0;

}