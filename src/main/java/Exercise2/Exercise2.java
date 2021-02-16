package Exercise2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.stream.JsonWriter;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Exercise2 {

    public void setPerson(Person person) {
        this.person = person;
    }

    Person person;
    List<Person> personsList = new ArrayList<>();

    public Person getPerson() {
        return person;
    }

    public List<Person> getPersonsList() {
        return personsList;
    }

    public List<Person> readFileWithPersons(String filePath) {

        try (FileReader fileReader = new FileReader(filePath);
             BufferedReader reader = new BufferedReader(fileReader)) {
            String personData = reader.readLine();

            while (personData != null) {
                if (personData.isEmpty()) {
                    personData = reader.readLine();
                }
                if (personData.split(" ")[0].equals("name") && personData.split(" ")[1].equals("age")) {
                    personData = reader.readLine();
                }
                setPerson(new Person(personData.split(" ")[0], personData.split(" ")[1]));
                getPersonsList().add(getPerson());
                personData = reader.readLine();
            }
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return getPersonsList();
    }

    public void writePersonInJSON(List<Person> list) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (FileWriter file = new FileWriter("JSONPerson.json");
             BufferedWriter write = new BufferedWriter(file);
             JsonWriter jw = gson.newJsonWriter(write)) {
            jw.beginArray();
            for (Person person : list) {
                jw.jsonValue(gson.toJson(person));
            }
            jw.endArray();
            file.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
