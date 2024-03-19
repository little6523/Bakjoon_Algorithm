n = int(input())

idx = 2
answer = []
while n != 1:
    if n % idx == 0:
        answer.append(idx)
        n //= idx
    else:
        idx += 1
        
for ans in answer:
    print(ans)