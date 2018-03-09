#
#  DAY 5:
# 
#  cons(a, b) constructs a pair, and car(pair) and cdr(pair) returns the 
#  first and last element of that pair. For example, car(cons(3, 4))
#  returns 3, and cdr(cons(3, 4)) returns 4.
#
# Given this implementation of cons:
# 
# def cons(a, b):
#     return lambda f : f(a, b)
# 
# Implement car and cdr.
#

def cons(a, b):
    return lambda f : f(a, b)

def car(pair):
	return pair(lambda a, b : a)

def cdr(pair):
	return pair(lambda a, b : b)

print(car(cons(3,4)))
print(cdr(cons(3,4)))