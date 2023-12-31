

public class Main {
    public static void main(String[] args) {
        Manager manager = new Manager(0, 0, null);
        manager.startProcess();

        for(Thread elementThread : Manager.threads) {
            try {
                elementThread.join();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println("Words count: " + Manager.numberOfWords);
        System.out.println("Longest word and its length: " + manager.longestWordInFiles() + " | " + manager.longestWordInFiles().length());
        System.out.println("Shortest word and its length: " + manager.getShortestWord() + " | " + manager.getShortestWord().length());
        System.out.println("All words length average: " + manager.getAverageOfWordsLength());
        System.out.println("Word which has most repeated char 'e': " + manager.getWordWithMostE());
        System.out.println("Top 5 most repeated words: " + manager.getMostRepeatedWords());
    }
}