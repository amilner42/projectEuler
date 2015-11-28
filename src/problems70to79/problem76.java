package problems70to79;

//Question -----------------------------------------------------------------------------------------------------------------------
//  It is possible to write five as a sum in exactly six different ways:
//
//        4 + 1
//        3 + 2
//        3 + 1 + 1
//        2 + 2 + 1
//        2 + 1 + 1 + 1
//        1 + 1 + 1 + 1 + 1
//
//  How many different ways can one hundred be written as a sum of at least two positive integers?
//---------------------------------------------------------------------------------------------------------------------------------
// Solution correct

public class problem76 {

    public static void main(String[] args) {
        int[][] solutions = new int[100][];                 // stores solutions separated by min value (1+1+2 vs 2+2)

        // Goes through the 100 numbers building them on top of each other. The core idea is that N (lets use 5 for the
        // example) is just:
        //    5 is just 1 + 4, or 2 + 3
        //  So I could say the solution for 5 is just 1 + solution(4), 2 + solution(3). If we do this though, we quickly
        //  run into issues with duplicates: 1 + sol(4) -> 1 + 2 + 2 , 2 + sol(3) --> 2 + 1 + 2. To avoid problems
        //  with duplicates, we organize our solutions by min value and do not allow ourselves to 'go back'. Eg. When
        // doing 2 + sol(3), we do not include the solutions for 3 that have a 1 in them because those solutions will
        // already be included (this fixes the duplicate problem listed above).
        for(int i = 0; i < 100; i++) {
            solutions[i] = new int[(i + 1) / 2];
            for(int j = 0 ; j < solutions[i].length ; j++) {
                solutions[i][j] = 1 + addAllRightOfX(solutions[i - j - 1], j);
            }
        }
        System.out.println(addAllRightOfX(solutions[99], 0));
    }

    // (int[] , int) --> int
    // Given an array of ints and an int X, returns the sum of all the ints in the array that have index >= X. If you
    // pass in 0 for the X, you get the sum of all the ints in the array.
    private static int addAllRightOfX(int[] solution, int x) {
        int total = 0;
        for(int i = x ; i < solution.length; i++) {
            total += solution[i];
        }
        return total;
    }
}

//  Original Solution (~120 sec runtime, way to slow...):
//
//  Although the solution is slow the concept behind the code is quite beautiful, I won't explain it to leave it as
//  a challenge for you to go through and understand!
//
//        int total = 0 , adder = 1 , sum = 0 , N = 100;
//        Stack<Integer> ints = new Stack<>();
//
//        while(true) {
//            sum += adder;
//            if(sum == N) {
//                if(ints.size() == 0) {
//                    break;
//                }
//                total++;
//                sum -= adder;
//                sum -= ints.peek();
//                adder = ints.pop() + 1;
//            } else if(sum > N) {
//                sum -= adder;
//                sum -= ints.peek();
//                adder = ints.pop() + 1;
//            } else {
//                ints.push(adder);
//            }
//        }
//
//        System.out.println(total + " ways");