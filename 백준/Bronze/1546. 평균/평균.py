import sys
input = sys.stdin.readline

n = int(input())
data = list(map(int, input().split()))
max_data = max(data)
total_sum = 0

for i in range(n):
    total_sum += data[i] / max_data * 100
    
print(total_sum / n)