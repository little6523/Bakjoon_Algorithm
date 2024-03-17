n, b = map(int, input().split())

answer = []
while n > 0:
    answer.append(n % b)
    n //= b
    
for i in range(len(answer)-1, -1, -1):
    if answer[i] >= 10:
        answer[i] = chr(answer[i] + 55)

for ans in answer[::-1]:        
    print(ans, end='')