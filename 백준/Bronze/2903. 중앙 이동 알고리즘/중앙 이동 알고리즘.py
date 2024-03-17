n = int(input())

answer = [4]
point = 3
for i in range(1, n+1):
    answer.append(point ** 2)
    point += point - 1
    
print(answer[n])