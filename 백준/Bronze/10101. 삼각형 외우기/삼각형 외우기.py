a = int(input())
b = int(input())
c = int(input())

if a == b == c == 60: print('Equilateral')
elif a + b + c == 180 and (a == b != c or a == c != b or a != b == c):
    print('Isosceles')
elif a + b + c == 180 and (a != b and a != c and b != c):
    print('Scalene')
else:
    print('Error')