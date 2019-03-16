/* Definition of BaseGFSClient
 * class BaseGFSClient {
 *     private Map<String, String> chunk_list;
 *     public BaseGFSClient() {}
 *     public String readChunk(String filename, int chunkIndex) {
 *         // Read a chunk from GFS
 *     }
 *     public void writeChunk(String filename, int chunkIndex,
 *                            String content) {
 *         // Write a chunk to GFS
 *     }
 * }
 */

public class GFSClient extends BaseGFSClient {
    private int chunkSize = 0;
    private Map<String, Integer> chunkNums = new HashMap<>();

    /*
    * @param chunkSize: An integer
    */
    public GFSClient(int chunkSize) {
        // do intialization if necessary
        this.chunkSize = chunkSize;
    }

    /*
     * @param filename: a file name
     * @return: conetent of the file given from GFS
     */
    public String read(String filename) {
        // write your code here
        Integer chunkNum = this.chunkNums.get(filename);
        if (chunkNum == null || chunkNum == 0) {
            return null;
        }

        StringBuilder content = new StringBuilder();
        for (int i = 0; i < chunkNum; i++) {
            String chunk = super.readChunk(filename, i);
            content.append(chunk);
        }
        return content.toString();
    }

    /*
     * @param filename: a file name
     * @param content: a string
     * @return: nothing
     */
    public void write(String filename, String content) {
        // write your code here
        for (int start = 0, i = 0; start < content.length(); start += this.chunkSize, i++) {
            int end = start + this.chunkSize;
            if (end > content.length()) {
                end = content.length();
            }
            super.writeChunk(filename, i, content.substring(start, end));
            this.chunkNums.put(filename, i + 1);
        }
    }
}