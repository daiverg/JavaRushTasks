package com.javarush.task.task17.task1710;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;


/* 
CRUD
*/

public class Solution {
    public static List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c":
                createPerson(args[1], args[2], args[3]);
                break;

            case "-u":
                updatePerson(args[1], args[2], args[3], args[4]);
                break;

            case "-d":
                deletePerson(args[1]);
                break;

            case "-i":
                printId(Integer.parseInt(args[1]));
                break;
        }
    }

    private static void deletePerson(String idS) {
        int id = Integer.parseInt(idS);
        allPeople.get(id).setName(null);
        allPeople.get(id).setBirthDate(null);
        allPeople.get(id).setSex(null);

    }

    private static void updatePerson(String idS, String name, String sex, String birthDay) throws ParseException {
        SimpleDateFormat bd = new SimpleDateFormat("dd/MM/yyyy");
        int id = Integer.parseInt(idS);
        Sex esex;
        if (sex.equals("м")) {
            esex = Sex.MALE;
        }    else esex = Sex.FEMALE;

            allPeople.get(id).setName(name);
            allPeople.get(id).setBirthDate(bd.parse(birthDay));
            allPeople.get(id).setSex(esex);

//        System.out.println(allPeople.get(1));
    }

    private static void createPerson(String name, String sex, String birthDay) throws ParseException {
        SimpleDateFormat bd = new SimpleDateFormat("dd/MM/yyyy");
        if (sex.equals("м")) {
            allPeople.add(Person.createMale(name, bd.parse(birthDay)));
        }
        else allPeople.add(Person.createFemale(name, bd.parse(birthDay)));
        System.out.println(allPeople.size() - 1);
    }


        public static void printId (int id) {
            System.out.println(allPeople.get(id).toString());
        }
        //start here - начни тут
}
