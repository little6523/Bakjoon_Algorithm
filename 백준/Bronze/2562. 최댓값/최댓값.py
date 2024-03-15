import sys
input = sys.stdin.readline

data = [0, 0]
for i in range(1, 10):
    num = int(input())
    if data[0] < num:
        data = [num, i]
        
print(data[0])
print(data[1])