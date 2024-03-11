total = [list(map(str, input().split())) for _ in range(20)]
grade = {'A+': 4.5,
         'A0': 4.0,
         'B+': 3.5,
         'B0': 3.0,
         'C+': 2.5,
         'C0': 2.0,
         'D+': 1.5,
         'D0': 1.0,
         'F' : 0.0}

sums = 0
credit = 0
for i in range(20):
    if total[i][2] == 'P': continue
    total[i][1] = float(total[i][1])
    total[i][2] = grade[total[i][2]]
    credit += total[i][1]
    sums += total[i][1] * total[i][2]
    
print(sums / credit)