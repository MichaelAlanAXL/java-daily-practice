package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Item;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class FileService {

    private static final String FILE_PATH = "data/shopping-list.json";
    private final Gson gson = new GsonBuilder().setPrettyPrinting().create();
    
    public void salvar(List<Item> lista) {
        try {
            File file = new File(FILE_PATH);
            file.getParentFile().mkdirs();

            try (FileWriter writer = new FileWriter(file)) {
                gson.toJson(lista, writer);
            }
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e.getMessage());
        }
    }

    public List<Item> carregar() {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            Type listType = new TypeToken<List<Item>>(){}.getType();
            List<Item> items = gson.fromJson(reader, listType);
            return items != null ? items : new ArrayList<>();
        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}
