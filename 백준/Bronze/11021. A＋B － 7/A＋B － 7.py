count = int(input())
case_X = []

for i in range (count) :
    case_numbers = input().split(' ')
    case_numbers[0] = int(case_numbers[0])
    case_numbers[1] = int(case_numbers[1])
    case_X.append(sum(case_numbers))

for i in range (count) :
    print("Case #%d: %d" %(i+1, case_X[i]))