/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    /**
     * @param n an integer
     * @return the number you guess
     */
    public int guessNumber(int n) {
        // Write your code here
        int start = 1;
        int end = n;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (super.guess(mid) == 0) {
                return mid;
            } else if (super.guess(mid) == 1) {
                start = mid;
            } else if (super.guess(mid) == -1) {
                end = mid;
            }
        }
        if (super.guess(start) == 0) {
            return start;
        }
        if (super.guess(end) == 0) {
            return end;
        }
        return -1;
    }
}