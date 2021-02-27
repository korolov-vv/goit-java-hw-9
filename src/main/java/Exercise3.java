import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class Exercise3 {

    public void countWords(String text){
        Map<String, Integer> myMap = new HashMap<>();
        String[] words = text.split(" ");

        List<String> list = Arrays.asList(words.clone());

        for(String word: list){
            if (!myMap.containsKey(word)) {
            myMap.put(word, Collections.frequency(list, word));
        }
        }

        myMap.entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed())
        .forEach(e -> System.out.println(e.getKey() + " " + e.getValue()));
    }

    public String readFile(String filePath) {
        StringBuilder stb = new StringBuilder();
        File file = new File(filePath);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)){
            String line = reader.readLine();

            while (line != null){
                stb.append(line).append(" ");
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return stb.toString();
    }

}
