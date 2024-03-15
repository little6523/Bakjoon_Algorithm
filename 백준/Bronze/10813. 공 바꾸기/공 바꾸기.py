import sys
input = sys.stdin.readline

n, m = map(int, input().split())
bascket = []
for i in range(1, n+1):
    bascket.append(i)

for _ in range(m):
    i, j = map(int, input().split())
    bascket[i-1], bascket[j-1] = bascket[j-1], bascket[i-1]
    
for b in bascket:
    print(b, end=' ')