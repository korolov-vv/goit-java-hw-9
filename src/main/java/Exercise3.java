import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class Exercise3 {

    public void countWords(String text){
        HashMap<String, String> myMap = new HashMap<>();
        String[] words = text.split(" ");
        int wordsCount = 1;
        for (int i = 0; i < (words.length - 1); i++) {
            for (int j = (i + 1); j < words.length; j++) {
                if(words[i].equals(words[j])){
                    wordsCount++;
                }
            }
            if(!myMap.containsKey(words[i])) {
                myMap.put(words[i], Integer.toString(wordsCount));
                wordsCount = 1;
            }
        }
        for(Map.Entry<String, String> entry: myMap.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }

    public String readFile(String filePath) {
        StringBuilder stb = new StringBuilder();
        File file = new File(filePath);
        try (FileReader fileReader = new FileReader(file);
             BufferedReader reader = new BufferedReader(fileReader)){
            String line = reader.readLine();

            while (line != null){
                stb.append(line + " ");
                line = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return stb.toString();
    }

}
