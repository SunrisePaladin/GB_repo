data = [1,2,3,4,5,6,7,8,9,1012, 45, 38]
res = map(int, data)
res = filter(lambda x: x%2==0, res)
res = list(map(lambda x: (x, x**2), res))
print(res)