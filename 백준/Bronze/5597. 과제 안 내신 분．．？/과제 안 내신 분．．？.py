import sys
input = sys.stdin.readline

data = [0] * 31
for _ in range(28):
    n = int(input())
    data[n] = 1
    
for i in range(1, 31):
    if data[i] == 0:
        print(i)