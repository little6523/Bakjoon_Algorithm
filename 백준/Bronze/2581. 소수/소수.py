import math

m = int(input())
n = int(input())

answer = []
for i in range(m, n+1):
    if i == 1: continue
    
    isPrime = 1
    for j in range(2, int(math.sqrt(i))+1):
        if i % j == 0:
            isPrime = 0
            break

    if isPrime == 1: answer.append(i)
        
if answer:
    print(sum(answer))
    print(answer[0])
else: print(-1)