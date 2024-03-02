def d(n):
    num = n
    num_list = []
    while(num>0):
        num_list.insert(0, num % 10)
        num //= 10
    return n + sum(num_list)

n = 0
dn_list = []
answer = []

# n이 셀프 넘버인지 아닌지 검사
for n in range(10001):
    dn_list.append(d(n))
    
for i in range(10000):
    if i not in dn_list:
        answer.append(i)
        
for i in range(len(answer)):
    print(answer[i])