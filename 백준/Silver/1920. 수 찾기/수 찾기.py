import sys

n = int(input())
a = list(map(int, sys.stdin.readline().split()))
a.sort()
m = int(input())
find = list(map(int, sys.stdin.readline().split()))
answer = []

for num in find:
    left = 0
    right = len(a) - 1
    flag = 0
    while left <= right:
        mid = (left + right) // 2
        if a[mid] == num:
            flag = 1
            break
        elif a[mid] > num:
            right = mid - 1
        elif a[mid] < num:
            left = mid + 1
            
    if flag == 1:
        answer.append(1)
    else:
        answer.append(0)
    
for i in answer:
    print(i)