#include <stdio.h>

int main(void) {

	int n, a, b, c;
	scanf("%d", &n);
	c = n;
	while(n>0)
	{
		for(a=0;a<n-1;a++)
		{
			printf(" ");
		}
		for(b=c;b-a>0;b--)
		{
			printf("*");
		}
		printf("\n");
		n = n - 1;
	}
	return 0;
}