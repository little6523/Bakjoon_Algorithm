#include <stdio.h>

int main(void) {

	int n, sum;
	sum=0;
	scanf("%d", &n);
	while(n>0)
	{
		sum = sum + n;
		n = n-1;
	}
    printf("%d", sum);

	return 0;
}