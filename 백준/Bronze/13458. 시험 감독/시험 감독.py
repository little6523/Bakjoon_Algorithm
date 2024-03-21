n = int(input())
arr = list(map(int, input().split()))
b, c = map(int, input().split())

answer = 0
for i in range(len(arr)):
    if arr[i] <= b:
        answer += 1
        continue
        
    if arr[i] - b <= c:
        answer += 2
        continue
    
    answer += ((arr[i] - b) // c) + 1
    if (arr[i] - b) % c != 0:
        answer += 1
    
print(answer)