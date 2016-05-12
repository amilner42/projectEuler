'''Question 74.

The number 145 is well known for the property that the sum of the factorial of its digits is equal to 145:

1! + 4! + 5! = 1 + 24 + 120 = 145

Perhaps less well known is 169, in that it produces the longest chain of numbers that link back to 169; it turns out that there are only three such loops that exist:

169 -> 363601 -> 1454 -> 169
871 -> 45361 -> 871
872 -> 45362 -> 872

It is not difficult to prove that EVERY starting number will eventually get stuck in a loop. For example,

69 -> 363600 -> 1454 -> 169 -> 363601 (-> 1454)
78 -> 45360 -> 871 -> 45361 (-> 871)
540 -> 145 (-> 145)

Starting with 69 produces a chain of five non-repeating terms, but the longest non-repeating chain with a starting number below one million is sixty terms.

How many chains, with a starting number below one million, contain exactly sixty non-repeating terms?

Solution - correct.
'''
from math import factorial


def add_new_visited_and_return_solution_count(solution_count, chain, collision_chain_length, visited_numbers):
    ''' Add numbers to visited with their respective chainLengths.

    args:
      solution_count: current number of solutions
      chain: chain of numbers that were gone through priar to collision
      collision_chain_length: length of the rest of the sequence
      visited_numbers: current visited numbers

    returns:
      solution_count (may be one higher if a solution was found)

    mutates:
      adds to visited numbers the new numbers with there chain lengths
    '''
    chain_length = collision_chain_length + len(chain)
    solutions = solution_count
    for number in chain:
      if chain_length == 60:
          solutions += 1
      visited_numbers.update({number: chain_length})
      chain_length -= 1

    return solutions


def get_next_number_in_chain(number):
  '''Gets next number in chain.'''
  factorial_sums = map(
      lambda n_as_string: factorial(int(n_as_string)),
      str(number))
  return sum(factorial_sums)


def main():
  '''Start of script.'''
  # Dictionary representing visited numbers:
  #   number: chain_length
  #
  # Initilized with known closed loops.
  visited_numbers = {
      871: 2,
      45361: 2,
      872: 2,
      45362: 2,
      169: 3,
      363601: 3,
      1454: 3
  }

  # Total number of solution_count.
  solution_count = 0

  index = 1
  while(index < 1E6):
    current_number = index
    current_chain = []

    # Go through and build a chain until we hit something already visited.
    while(current_number not in visited_numbers):
      current_chain.append(current_number)
      next_number_in_chain = get_next_number_in_chain(current_number)

      # Check if the next number is the same (eg. 1->1 or 145->145).
      if next_number_in_chain == current_number:
          solution_count = add_new_visited_and_return_solution_count(solution_count, current_chain, 0, visited_numbers)
          current_chain = None  # To prevent adding a collision after loop.
          break

      current_number = next_number_in_chain

    # If a chain was created before collision, add it.
    if current_chain:
      solution_count = add_new_visited_and_return_solution_count(solution_count, current_chain, visited_numbers[current_number], visited_numbers)

    index += 1

  print solution_count


main()