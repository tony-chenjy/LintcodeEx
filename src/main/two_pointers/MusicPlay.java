package two_pointers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Given int array of song list
return a pair of song which total songs time will end exactly 30 minute before
given ride duration. if 2 pairs with same duration get the longest song

For example:
Ride Duration:90
Songs: (1,10,25,35,60,20,40)

Output:
[20,40] as 40 has longer song
*/

/**
 * @author tony.chenjy
 * @date 2019-08-11
 */
public class MusicPlay {

    // time: O(n)
    public List<Integer> getSongs(int[] songs, int ride) {
        List<Integer> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int songOne = -1;
        int songTwo = -1;
        int longSong = -1;
        for (int i = 0; i < songs.length; i++) {
            if (map.containsKey(ride - 30 - songs[i])) {
                if (longSong < Math.max(songs[i], ride - 30 - songs[i])) {
                    songOne = i;
                    songTwo = map.get(ride - 30 - songs[i]);
                    longSong = Math.max(songs[i], ride - 30 - songs[i]);
                }
            }
            map.put(songs[i], i);
        }
        res.add(songOne);
        res.add(songTwo);
        return res;
    }

    public static void main(String[] args) {
        MusicPlay sol = new MusicPlay();
        int ride = 90;
        int[] songs = new int[] {1, 10, 25, 35, 60, 20, 40};
        List<Integer> res = new ArrayList<>();
        res = sol.getSongs(songs, ride);
        for (Integer k : res) {
            System.out.println(k);
        }
    }
}
