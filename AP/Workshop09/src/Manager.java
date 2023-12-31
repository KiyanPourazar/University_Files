import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    static ArrayList<Thread> threads = new ArrayList<>();
    static ArrayList<String> longestWord;
    static ArrayList<String> shortestWord;
    static ArrayList<Integer> averageOfEachFilesWords;
    static ArrayList<String> wordsWithMostE;
    static ArrayList<HashMap<String, Integer>> top5RepeatedWordsInEachFile;
    static Long numberOfWords;
    static long averageOfWordsLength;
    static String wordWithMostE;
    private HashMap<String, Integer> mostRepeatedWords;

    public Manager(long numberOfWords, long averageOfWordsLength, String wordWithMostE) {
        this.numberOfWords = numberOfWords;
        this.averageOfWordsLength = averageOfWordsLength;
        this.wordWithMostE = wordWithMostE;

        mostRepeatedWords = new HashMap<>();
        longestWord = new ArrayList<>();
        shortestWord = new ArrayList<>();
        averageOfEachFilesWords = new ArrayList<>();
        wordsWithMostE = new ArrayList<>();
        top5RepeatedWordsInEachFile = new ArrayList<>();
    }

    public void startProcess() {

        // adding threads
        for (int i = 1; i <= 20; i++) {
            threads.add(new Thread(new MyThread(i)));
        }

        // starting threads
        for (Thread elementThread : threads) {
            elementThread.start();
        }

        for (Thread elementThread : threads) {
            try {
                elementThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public static synchronized void addNum(int num) {
        numberOfWords = numberOfWords + num;
    }

    public String getShortestWord() {
        String result = shortestWord.get(0);

        for (String elementString : shortestWord) {
            if (elementString.length() < result.length()) {
                result = elementString;
            }
        }

        return result;
    }

    public synchronized long getAverageOfWordsLength() {
        for (Integer elementInt : averageOfEachFilesWords) {
            averageOfWordsLength += elementInt;
        }

        return averageOfWordsLength / 20;
    }

    public String getWordWithMostE() {

        int Counter = 0;
        for (String elementString : wordsWithMostE) {
            char ch;
            int eCounter2 = 0;
            for (int i = 0; i < elementString.length(); i++) {
                ch = elementString.charAt(i);
                if (ch == 'e') {
                    eCounter2++;
                }
            }

            if (Counter < eCounter2) {
                wordWithMostE = elementString;
                Counter = eCounter2;
            }
        }

        return wordWithMostE;
    }

    public String getMostRepeatedWords() {
        ArrayList<String> result = new ArrayList<>();

        for (HashMap<String, Integer> elementHash : top5RepeatedWordsInEachFile) {
            for (String elementString : elementHash.keySet()) {
                for(HashMap<String, Integer> elementHash2 : top5RepeatedWordsInEachFile) {
                    for (String elementString2 : elementHash2.keySet()) {
                        if(elementString.equals(elementString2)) {
                            elementHash.put(elementString, elementHash.get(elementString) + 1);
                        }
                    }
                }
            }
        }

        HashMap<String, Integer> allWordsInOneHash = new HashMap<>();
        for (HashMap<String, Integer> elementHash : top5RepeatedWordsInEachFile) {
            for (String elementString : elementHash.keySet()) {
                allWordsInOneHash.put(elementString, elementHash.get(elementString));
            }
        }

        while (result.size() < 5) {

            String word = "";
            int counter = 0;
            for(String elementString : allWordsInOneHash.keySet()) {
                if(allWordsInOneHash.get(elementString) > counter) {
                    counter = allWordsInOneHash.get(elementString);
                    word = elementString;
                }
            }

            result.add(word);
            allWordsInOneHash.remove(word);
        }

        return (result.get(0) + " | " + result.get(1) + " | " + result.get(2) + " | " + result.get(3) + " | " + result.get(4));
    }

    public String longestWordInFiles() {
        String result = "";

        for(String elementString : longestWord) {
            if(elementString.length() > result.length()) {
                result = elementString;
            }
        }

        return result;
    }
}
