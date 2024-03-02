#include <stdio.h>

int main(void) {

	int n, a=1;
	scanf("%d", &n);
	while(n>0)
	{
		printf("%d\n", a);
		a = a + 1;
		n = n - 1;
	}
	return 0;
}