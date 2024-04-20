package TextFileSplitter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TextAnalyzer implements Runnable {

    private ArrayList<String> lines;

    public static int countCharacters;
    public static HashMap<Character, Integer> countByCharacter = new HashMap<Character, Integer>();
    private static Lock lock = new ReentrantLock();

    public TextAnalyzer(ArrayList<String> lines) {
        this.lines = lines;
    }

    @Override
    public void run() {

        int counter = 0;
        for (String str : lines){
            counter+= str.length();

            for (Character c : str.toCharArray()) {

                lock.lock();
                    if (countByCharacter.containsKey(c)) {
                        int cnt = countByCharacter.get(c);
                        cnt++;
                        countByCharacter.put(c, cnt);
                    }
                    else {
                        countByCharacter.put(c, 1);
                    }
                lock.unlock();
            }

        }

        lock.lock();
        countCharacters += counter;
        lock.unlock();
    }
}
