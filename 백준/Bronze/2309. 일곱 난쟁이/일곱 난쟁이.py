arr = [int(input()) for _ in range(9)]
total_sum = sum(arr)
check = 0

for i in range(8):
    for j in range(i+1, 9):
        if total_sum - (arr[i] + arr[j]) == 100:
            check = 1
            arr.remove(arr[j])
            arr.remove(arr[i])
            break
    
    if check == 1:
        break

arr.sort()
for i in range(7):
    print(arr[i])