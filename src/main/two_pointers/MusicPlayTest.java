package two_pointers;

import java.util.*;

/**
 * @author tony.chenjy
 * @date 2019-08-11
 */
public class MusicPlayTest {

    // time: O(nlog(n)) for sorting, space: O(1)
    public List<Integer> getSongs(int[] songs, int ride) {
        int target = ride - 30;

        Arrays.sort(songs);

        int left = 0;
        int right = songs.length - 1;
        while (left < right) {
            int sum = songs[left] + songs[right];
            if (target == sum) {
                List<Integer> list = new ArrayList<>();
                list.add(songs[left]);
                list.add(songs[right]);
                return list;
            } else if (target > sum) {
                left++;
            } else {
                right--;
            }
        }

        return new ArrayList<>();
    }

    public static void main(String[] args) {
        MusicPlayTest sol = new MusicPlayTest();
        int ride = 90;
        int[] songs = new int[] {1, 10, 25, 35, 60, 20, 40};
        List<Integer> res = sol.getSongs(songs, ride);

        for (Integer k : res) {
            System.out.println(k);
        }
    }
}
