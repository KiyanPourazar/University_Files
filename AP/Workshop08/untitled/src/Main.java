import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//        try{
//            ObjectOutputStream FOut = new ObjectOutputStream(new FileOutputStream("text.bin"));
//            FOut.writeObject(new ArrayList<Note>());
//            FOut.close();
//        }
//        catch (Exception e) {
//            e.printStackTrace();
//        }
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("1- Add");
            System.out.println("2- Remove");
            System.out.println("3- Notes");
            System.out.println("4- Export");

            try {
                String result = input.nextLine();
                switch(Integer.parseInt(result)) {
                    case 1 :
                        System.out.print("Please choose a title for the note: ");
                        String title = input.nextLine();

                        try{
                            ObjectInputStream FIn = new ObjectInputStream(new FileInputStream("text.bin"));

                            ArrayList<Note> notes = (ArrayList<Note>) FIn.readObject();
                            FIn.close();

                            ObjectOutputStream FOut = new ObjectOutputStream(new FileOutputStream("text.bin"));
                            int checker = 0;

                            if(notes != null) {
                                for (Note element : notes) {
                                    if (element.getTitle().equals(title)) {
                                        checker = 1;
                                        System.out.println("duplicate-title");
                                        FOut.writeObject(notes);
                                        FOut.close();
                                        break;
                                    }
                                }
                            }

                            if(checker == 0) {
                                System.out.println("ok. feel free to write!");
                                System.out.println("enter '#' to finish!");

                                String text = new String();
                                String help = input.nextLine();

                                while(!help.contains("#")) {
                                    text.concat(help);
                                    help = input.nextLine();
                                }

                                String[] help2 = help.split("#");
                                text.concat(help2[0]);

                                Note note = new Note(LocalDate.now().toString(), title, text);

                                if(notes == null) {
                                    notes = new ArrayList<>();
                                    notes.add(note);
                                }
                                else {
                                    notes.add(note);
                                }

                                System.out.println("the new note has been added successfully!");

                                FOut.writeObject(notes);
                                FOut.close();
                            }
                        }
                        catch(Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 2:
                        try {
                            ObjectInputStream FIn = new ObjectInputStream(new FileInputStream("text.bin"));

                            ArrayList<Note> notes = (ArrayList<Note>) FIn.readObject();
                            FIn.close();

                            int i = 1;
                            if(notes != null) {
                                System.out.println("choose of the notes to remove or enter '0' to back to main menu: ");

                                for (Note element : notes) {
                                    System.out.println("" + i++ + " | " + element);
                                }
                            }
                            else {
                                System.out.println("Note box is empty");
                                break;
                            }

                            i = input.nextInt();

                            if(i == 0) {
                                break;
                            }
                            if(notes.size() > i - 1 && i - 1 >= 0) {
                                ObjectOutputStream FOut = new ObjectOutputStream(new FileOutputStream("text.bin"));

                                notes.remove(i - 1);

                                FOut.writeObject(notes);
                                FOut.close();

                                System.out.println("the note has been removed successfully!");
                            }
                            else {
                                System.out.println("Invalid index");
                            }
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 3:
                        try {
                            ObjectInputStream FIn = new ObjectInputStream(new FileInputStream("text.bin"));
                            System.out.println("choose a note to show:");
                            ArrayList<Note> notes = (ArrayList<Note>) FIn.readObject();
                            FIn.close();

                            int i = 0;
                            if(notes != null) {
                                for (Note element : notes) {
                                    System.out.println("" + i++ + " | " + element);
                                }
                            }
                            else {
                                System.out.println("Note box is empty");
                                break;
                            }

                            i = input.nextInt();

                            if(notes.size() > i && i >= 0) {
                                System.out.println("----     " + notes.get(i).getTitle() + "     ----");
                                System.out.println("");
                                System.out.println(notes.get(i).getText());
                            }
                            else {
                                System.out.println("Invalid index");
                                break;
                            }
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;
                    case 4:
                        try{

                            ObjectInputStream FIn = new ObjectInputStream(new FileInputStream("text.bin"));
                            System.out.println("choose a note to show:");
                            ArrayList<Note> notes = (ArrayList<Note>) FIn.readObject();
                            FIn.close();

                            int i = 0;

                            if(notes != null) {
                                for (Note element : notes) {
                                    System.out.println("" + i++ + element);
                                }
                            }
                            else {
                                System.out.println("Note box is empty");
                                break;
                            }

                            i = input.nextInt();

                            if(notes.size() > i && i >= 0) {
                                FileWriter FOut = new FileWriter(notes.get(i).getTitle() + ".txt");

                                System.out.println("then note has been exported successfully!");
                                System.out.println("you can find it on\"export\" directory.");

                                FOut.write("Date : " + notes.get(i).getDate() + " | " + "Title : " + notes.get(i).getTitle() + " | " + notes.get(i).getText());
                                FOut.close();
                            }
                            else {
                                System.out.println("Invalid index!");
                                break;
                            }
                        }
                        catch (Exception e) {
                            e.printStackTrace();
                        }
                        break;

                    default:
                        System.out.println("Delamo shekundi MOHANDES :( ");
                }
            }
            catch (Exception e) {

            }
        }
    }
}