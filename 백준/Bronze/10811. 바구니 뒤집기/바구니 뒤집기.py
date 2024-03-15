import sys
input = sys.stdin.readline

n, m = map(int, input().split())
bascket = [0] * (n+1)
for i in range(1, n+1):
    bascket[i] = i
    
for _ in range(m):
    i, j = map(int, input().split())
    for idx in range(i, (i+j)//2 +1):
        bascket[idx], bascket[i + j - idx] = bascket[i + j - idx], bascket[idx]
        
for i in range(1, n+1):
    print(bascket[i], end=' ')