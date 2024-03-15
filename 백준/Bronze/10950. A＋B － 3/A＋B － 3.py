T = int(input())

answer = []

for i in range(T):
    a, b = map(int, input().split())
    answer.append(a+b)
    
for i in range(T):
    print(answer[i])