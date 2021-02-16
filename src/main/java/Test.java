import Exercise2.Exercise2;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        String filePathPhoneNumbers = "src/main/resources/PhonenUmbers.txt";
        String filePathWithPersons = "src/main/resources/Persons.txt";
        String filePathWithWords = "src/main/resources/Words.txt";
        new Exercise1().findAndPrintValidNumbers(filePathPhoneNumbers);

        System.out.println("Exercise2. List of persons:");
        System.out.println(new Exercise2().readFileWithPersons(filePathWithPersons));
        System.out.println("__________________________________");
        new Exercise2().writePersonInJSON(new Exercise2().readFileWithPersons(filePathWithPersons));

        System.out.println("Words:");
        new Exercise3().countWords(new Exercise3().readFile(filePathWithWords));
        System.out.println("__________________________________");
    }
}
