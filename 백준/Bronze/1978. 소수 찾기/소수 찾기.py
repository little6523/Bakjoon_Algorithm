import math

n = int(input())
data = list(map(int, input().split()))
answer = 0

for i in range(n):
    if data[i] == 1: continue
    
    isPrime = 1
    for j in range(2, int(math.sqrt(data[i]) + 1)):
        if data[i] % j == 0:
            isPrime = 0
            break
        else:
            isPrime = 1
    
    if isPrime == 1:
        answer += 1
        
print(answer)