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
#   def pair(f):
#      return f(a, b)
#   return pair
#
# Implement car and cdr
#

# Cons takes two values (a, b), and returns reference to a function f(g(x)) which
# when called will execute g on (a, b): E.g. calling f(a, b) will return the result of g(a, b)
def cons(a, b):
  def pair(f):
    return f(a, b)
  return pair

def car(pair):
  def getFirstValue(a, b):
    return a
    
  return pair(getFirstValue)
  
  
def cdr(pair):
  def getLastValue(a, b):
    return b

  return pair(getLastValue)

print(car(cons(3, 4)))
print(cdr(cons(3, 4)))