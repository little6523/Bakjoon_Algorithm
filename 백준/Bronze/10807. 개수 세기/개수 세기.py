import sys
input = sys.stdin.readline

n = int(input())
data = list(map(int, input().split()))
v = int(input())
cnt = 0

for i in range(len(data)):
    if data[i] == v:
        cnt += 1
        
print(cnt)