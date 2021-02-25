import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;

public class Exercise1 {

    public void findAndPrintValidNumbers(String filePath) {

        File file = new File(filePath);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)) {
            String phoneNumber = reader.readLine();

            while (phoneNumber != null) {
                if (phoneNumberValidation(phoneNumber)) {
                    System.out.println(phoneNumber);
                }
                phoneNumber = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }

    public boolean phoneNumberValidation(String phoneNumber) {
        boolean isValidNumber = false;
        if (phoneNumber.length() == 14) {
            if (Pattern.matches("\\(\\d{3}\\)\\s\\d{3}\\-\\d{4}", phoneNumber)) {
                isValidNumber = true;
            }
        } else if (phoneNumber.length() == 12) {
            if (Pattern.matches("\\d{3}\\-\\d{3}\\-\\d{4}", phoneNumber)) {
                isValidNumber = true;
            }
        }
        return isValidNumber;
    }
}