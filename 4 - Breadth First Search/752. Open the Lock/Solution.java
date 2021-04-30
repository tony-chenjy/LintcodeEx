class Solution {
    public int openLock(String[] deadends, String target) {
        // initial deadend set
        Set<String> deadendSet = new HashSet<>();
        for (String deadend : deadends) {
            deadendSet.add(deadend);
        }

        String start = "0000";
        if (deadendSet.contains(start)) {
            return -1;
        }

        int step = 0;
        Queue<String> queue = new LinkedList<>();
        Set<String> existed = new HashSet<>();
        queue.offer(start);
        existed.add(start);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String str = queue.poll();
                if (target.equals(str)) {
                    return step;
                }

                // get next states
                for (int j = 0; j < str.length(); j++) {
                    String nextUp = moveUp(str, j);
                    if (!deadendSet.contains(nextUp) && !existed.contains(nextUp)) {
                        queue.offer(nextUp);
                        existed.add(nextUp);
                    }
                    String nextDown = moveDown(str, j);
                    if (!deadendSet.contains(nextDown) && !existed.contains(nextDown)) {
                        queue.offer(nextDown);
                        existed.add(nextDown);
                    }
                }
            }
            step++;
        }
        return -1;
    }
    
    private String moveUp(String str, int pos) {
        char[] chars = str.toCharArray();
        if (chars[pos] == '9') {
            chars[pos] = '0';
        } else {
            chars[pos] += 1;
        }
        return new String(chars);
    }
    
    private String moveDown(String str, int pos) {
        char[] chars = str.toCharArray();
        if (chars[pos] == '0') {
            chars[pos] = '9';
        } else {
            chars[pos] -= 1;
        }
        return new String(chars);
    }
}