croatia = ['c=', 'c-', 'dz=', 'd-', 'lj', 'nj', 's=', 'z=']
data = input()
answer = 0
cnt = 0
space = 0

for cro in croatia:
    answer += data.count(cro)
    while cro in data:
        if len(cro) == 3:
            data = data.replace(cro, '   ', 1)
            space += 3
        else:
            data = data.replace(cro, '  ', 1)
            space += 2
 
answer += len(data) - space
print(answer)