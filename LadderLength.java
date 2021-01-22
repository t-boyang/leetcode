import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        wordSet.remove(beginWord);
        int ans = 0;
        while (!queue.isEmpty()) {
            ans++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                char[] data = queue.poll().toCharArray();
                for (int j = 0; j < data.length; j++) {
                    char temp = data[j];
                    for (char k = 'a'; k <= 'z'; k++) {
                        data[j] = k;
                        String newWord = String.valueOf(data);
                        if (wordSet.contains(newWord)) {
                            if (endWord.equals(newWord)) {
                                return ans + 1;
                            }
                            queue.offer(newWord);
                            wordSet.remove(newWord);
                        }
                    }
                    data[j] = temp;
                }
            }
        }
        return 0;
    }
    public static void main(String[] args) {
    }
}
