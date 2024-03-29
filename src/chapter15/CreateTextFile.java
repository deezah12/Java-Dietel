package chapter15;

import java.io.FileNotFoundException;
import java.util.Formatter;
import java.util.FormatterClosedException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class CreateTextFile {
    public static void main(String[] args){
        try(Formatter output = new Formatter("clients.txt")) {
            Scanner input = new Scanner(System.in);
            System.out.printf("%s%n%s%n?","Enter account number, first name, " +
                    "last name, balance.", "Enter ^Z to end input.");

            while(input.hasNext()){
                try{
                    output.format("%d %s %s %.2f%n", input.nextInt(), input.next(),
                            input.next(), input.nextDouble());
                } catch (NoSuchElementException elementException) {
                    System.err.println("invalid input try again");
                    input.nextLine();
                }
            }
        } catch (SecurityException | FileNotFoundException |
                 FormatterClosedException e) {
                    e.printStackTrace();
        }
    }
}
