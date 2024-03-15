a = int(input())
b = int(input())
arr = []
new_b = b

while new_b > 0:
    arr.append(new_b % 10)
    new_b //= 10
    
for i in range(len(arr)):
    print(a * arr[i])
    
print(a * b)