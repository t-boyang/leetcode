import java.util.HashSet;
import java.util.Set;

class TrieNode {
    private TrieNode[] data;
    private boolean isEnd;
    private final int R = 26;

    public TrieNode() {
        data = new TrieNode[R];
    }

    public void put(char s, TrieNode node) {
        data[s - 'a'] = node;
    }

    public TrieNode get(char s) {
        return data[s - 'a'];
    }

    public boolean containsKey(char s) {
        return data[s - 'a'] != null;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean getEnd() {
        return isEnd;
    }
}

public class Trie {
    public Trie() {

    }

    public void insert(String word) {

    }

    private TrieNode searchPrefix(String word) {

    }

    public boolean search(String word) {

    }

    public boolean startsWith(String prefix) {

    }

    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        slow = 0;
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    public boolean containsDuplicate(int[] nums) {
        if (nums.length == 0) {
            return false;
        }
        Set<Integer> set = new HashSet<>();
        for (int data : nums) {
            if (set.contains(data)) {
                return true;
            }
            set.add(data);
        }
        return false;
    }
}

