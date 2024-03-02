#include <stdio.h>

int main(void) {

	int a;
	int b;
	int c;
	int mid;
	scanf("%d", &a);
	scanf("%d", &b);
	scanf("%d", &c);

	if(a>=b)
	{
		if(a>c)
		{
			if(b>c)
			{
				mid = b;
			}
			else
			{
				mid = c;
			}
		}
		else
		{
			mid = a;
		}
	}
	else if(a<=b)
	{
		if(b>c)
		{
			if(a>c)
			{
				mid = a;
			}
			else
			{
				mid = c;
			}
		}
		else
		{
			mid = b;
		}
	}
	printf("%d", mid);

	return 0;
}