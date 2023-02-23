package com.iesam.Protectora.Data.LocalDataStore;


//import com.google.gson.Gson;
//import com.google.gson.reflect.TypeToken;
import com.iesam.Protectora.Domain.Models.Cat;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;
public class CatFileLocalDataSource implements CatLocalDataSource{

    private static CatFileLocalDataSource instance = null;

   // private Gson gson = new Gson();

    private final Type typeCatList = new Type <ArrayList<Cat>>() {
    }.getType();

    private CatFileLocalDataSource() {
    }

    public void save(Cat cats) {
        List<Cat> cat = findAll();
        cat.add(cats);
        saveToFile(cat);
    }

    private void saveToFile(List<Cat> contacts) {
        try {
            FileWriter myWriter = new FileWriter("cats.txt");
            //myWriter.write(gson.toJson(cats));
            myWriter.close();
            System.out.println("contact guardado correctamente");
        } catch (IOException e) {
            System.out.println("Ha ocurrido un error");
            e.printStackTrace();
        }
    }


    public Cat findById(Integer contactId) {
        List<Cat> cats = findAll();
        for (Cat cat : cats) {
            if (Objects.equals(cat.getId(), cat)) {
                return cat;
            }
        }
        return null;
    }

    public List<Cat> findAll() {
        try {
            File myObj = new File("Cats.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                myReader.close();
                //return gson.fromJson(data, typeCatList);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
        return new ArrayList<Cat>();
    }

    @Override
    public void delete(Integer idCat) {
        List<Cat> cats = findAll();
        List<Cat> newList = new ArrayList<>();
        for (Cat cat : cats) {
            if (!Objects.equals(cat.getId(), idCat)) {
                newList.add(cat);
            }
        }
        saveToFile(newList);
    }

    public static CatFileLocalDataSource getInstance() {
        if (instance == null) {
            instance = new CatFileLocalDataSource();
        }
        return instance;
    }
}
