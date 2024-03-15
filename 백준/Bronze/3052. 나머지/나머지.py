import sys
input = sys.stdin.readline

data = set()
for _ in range(10):
    n = int(input())
    data.add(n % 42)
    
print(len(data))