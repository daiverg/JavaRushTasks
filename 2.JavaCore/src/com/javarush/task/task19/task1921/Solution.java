package com.javarush.task.task19.task1921;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Date;

/* 
Хуан Хуанович
*/

public class Solution {
    public static final List<Person> PEOPLE = new ArrayList<Person>();

    public static void main(String[] args) throws IOException, ParseException {
        BufferedReader fileReader = new BufferedReader(new FileReader(args[0]));
        SimpleDateFormat formatter = new SimpleDateFormat("dd MM yyyy");
        Person person;

        while (fileReader.ready()){
            String tmpLine = fileReader.readLine();
            String name = tmpLine.replaceAll("\\d", "").trim();
            String dateTemp = tmpLine.replaceAll("(([a-zA-Z])-?)?(([а-яА-Я])-?)?","").trim();
            Date birthDate = formatter.parse(dateTemp);
            person = new Person(name, birthDate);
            PEOPLE.add(person);
        }

        fileReader.close();

//        for (int i = 0; i < PEOPLE.size(); i++) {
//            System.out.println(PEOPLE.get(i).getName() + " " + PEOPLE.get(i).getBirthDate());
//        }

    }
}
