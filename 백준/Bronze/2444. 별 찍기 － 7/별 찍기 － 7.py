n = int(input())

for i in range(1, 2*n):
    # 1 ~ n
    if i <= n:
        for j in range(n-i):
            print(' ', end='')
        for j in range(2*i-1):
            print('*', end='')
        print()
    # n+1 ~ 2n-1
    else:
        for j in range(i-n):
            print(' ', end='')
        for j in range(2*n-1-2*(i-n)):
            print('*', end='')
        print()