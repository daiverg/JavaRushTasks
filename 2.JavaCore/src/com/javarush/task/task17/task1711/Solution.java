package com.javarush.task.task17.task1711;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/*
CRUD 2
*/

public class Solution {
    public static volatile List<Person> allPeople = new ArrayList<Person>();

    static {
        allPeople.add(Person.createMale("Иванов Иван", new Date()));  //сегодня родился    id=0
        allPeople.add(Person.createMale("Петров Петр", new Date()));  //сегодня родился    id=1
    }

    public static void main(String[] args) throws ParseException {
        switch (args[0]) {
            case "-c":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 3) {
                        createPerson(args[i], args[i + 1], args[i + 2]);
                    }
                }
                break;

            case "-u":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i += 4) {
                        updatePerson(args[i], args[i + 1], args[i + 2], args[i + 3]);
                    }
                }
                break;

            case "-d":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        deletePerson(args[i]);
                    }
                }
                break;

            case "-i":
                synchronized (allPeople) {
                    for (int i = 1; i < args.length; i++) {
                        printId(args[i]);
                    }
                }
                break;
        }

        //start here - начни тут
    }

    private static void createPerson(String name, String sex, String birthDay) throws ParseException {
        SimpleDateFormat bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        if (sex.equals("м")) {
            allPeople.add(Person.createMale(name, bd.parse(birthDay)));
        } else allPeople.add(Person.createFemale(name, bd.parse(birthDay)));
        System.out.println(allPeople.size() - 1);


    }

    private static void updatePerson(String idS, String name, String sex, String birthDay) throws ParseException {
        SimpleDateFormat bd = new SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH);
        int id = Integer.parseInt(idS);
        Sex esex = sex.equals("м") ? Sex.MALE : Sex.FEMALE;
        allPeople.get(id).setName(name);
        allPeople.get(id).setBirthDate(bd.parse(birthDay));
        allPeople.get(id).setSex(esex);

    }

    private static void deletePerson(String idS) {
        int id = Integer.parseInt(idS);
        allPeople.get(id).setName(null);
        allPeople.get(id).setBirthDate(null);
        allPeople.get(id).setSex(null);
    }

    private static void printId(String idS) {
        int id = Integer.parseInt(idS);
        System.out.println(allPeople.get(id).toString());
    }
}
