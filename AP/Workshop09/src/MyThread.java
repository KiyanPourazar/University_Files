import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;

public class MyThread implements Runnable{
    private int index;

    public MyThread(int index) {
        this.index = index;
    }

    @Override
    public void run() {
        try {
            String text = Files.readString(Path.of("Multi_threading_workshop_9/file_" + index + ".txt"));

            // calculating number of words
            Manager.addNum(text.split("\n").length);

            // finding the longest word
            String[] eachWord = text.split("\n");
            // navigating on words
            String help = eachWord[0];
            for (String elementString : eachWord) {
                if(elementString.length() > help.length()) {
                    help = elementString;
                }
            }

            synchronized (Manager.longestWord) {
                Manager.longestWord.add(help);
            }

            // navigating of words
            String help2 = eachWord[0];
            for (String elementString : eachWord) {
                if(elementString.length() < help2.length()) {
                    help2 = elementString;
                }
            }

            synchronized (Manager.shortestWord) {
                Manager.shortestWord.add(help2);
            }

            int average = 0;
            for(String elementString : eachWord) {
                average += elementString.length();
            }
            average /= text.split("\n").length;

            synchronized ( Manager.averageOfEachFilesWords) {
                Manager.averageOfEachFilesWords.add(average);
            }

            String word = "";
            int eCounter = 0;
            for(String elementString : eachWord) {
                char ch;
                int eCounter2 = 0;
                for(int i = 0; i < elementString.length(); i++) {
                    ch = elementString.charAt(i);
                    if(ch == 'e') {
                        eCounter2++;
                    }
                }

                if(eCounter < eCounter2) {
                    word = elementString;
                    eCounter = eCounter2;
                }
            }

            synchronized ( Manager.averageOfEachFilesWords) {
                Manager.wordsWithMostE.add(word);
            }

            HashMap<String, Integer> eachWordsRepetition = new HashMap<>();
            for(String elementStringWords : eachWord) {
                int checker = 0;
                for (String elementString : eachWordsRepetition.keySet()) {
                    if(elementString.equals(elementStringWords)) {
                        checker = 1;
                        eachWordsRepetition.put(elementStringWords, eachWordsRepetition.get(elementStringWords) + 1);
                    }
                }

                if(checker == 0) {
                    eachWordsRepetition.put(elementStringWords, 1);
                }
            }

            HashMap<String, Integer> result = new HashMap<>();
            for(int i = 1; i <= 5; i++) {
                int mostRepeated = 0;
                String element = "";
                for(String elementString : eachWordsRepetition.keySet()) {
                    if(eachWordsRepetition.get(elementString) > mostRepeated) {
                        mostRepeated = eachWordsRepetition.get(elementString);
                        element = elementString;
                    }
                }

                result.put(element, mostRepeated);
                eachWordsRepetition.remove(element);
            }

            synchronized (Manager.top5RepeatedWordsInEachFile) {
                Manager.top5RepeatedWordsInEachFile.add(result);
            }
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}