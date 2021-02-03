import java.util.Map;
import java.util.HashMap;
import java.util.LinkedHashSet;

public class LFUCache {
    private Map<Integer, Integer> keyToVal;
    private Map<Integer, Integer> keyToFreq;
    private Map<Integer, LinkedHashSet<Integer>> freqTokeys;
    private int minFreq;
    private int cap;

    public LFUCache(int capacity) {
        this.cap = capacity;
        this.keyToFreq = new HashMap<>();
        this.keyToVal = new HashMap<>();
        this.freqTokeys = new HashMap<>();
        this.minFreq = 0;
    }

    public int get(int key) {
        if (!keyToVal.containsKey(key)) {
            return -1;
        }
        increaseFreq(key);
        return keyToVal.get(key);
    }

    public void put(int key, int value) {
        if (this.cap <= 0) {
            return;
        }
        if (keyToVal.containsKey(key)) {
            keyToVal.put(key, value);
            increaseFreq(key);
        } else {
            if (keyToVal.size() >= this.cap) {
                removeMinFreqKey();
            }
            keyToVal.put(key, value);
            keyToFreq.put(key, 1);
            freqTokeys.putIfAbsent(1, new LinkedHashSet<>());
            freqTokeys.get(1).add(key);
            this.minFreq = 1;
        }
    }

    private void increaseFreq(int key) {
        int freq = keyToFreq.get(key);
        keyToFreq.put(key, freq + 1);
        freqTokeys.get(freq).remove(key);
        freqTokeys.putIfAbsent(freq + 1, new LinkedHashSet<>());
        freqTokeys.get(freq + 1).add(key);
        if (freqTokeys.get(freq).isEmpty()) {
            freqTokeys.remove(freq);
            if (this.minFreq == freq) {
                this.minFreq++;
            }
        }
    }

    private void removeMinFreqKey() {
        LinkedHashSet<Integer> keyList = freqTokeys.get(this.minFreq);
        int deleteKey = keyList.iterator().next();
        keyList.remove(deleteKey);
        keyToFreq.remove(deleteKey);
        keyToVal.remove(deleteKey);
    }

}
