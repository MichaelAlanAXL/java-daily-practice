package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import model.Cidade;

import java.io.FileReader;
import java.util.List;

public class CidadeService {

    public List<Cidade> carregarCidades() {
        try (FileReader reader = new FileReader("data/cidades.json")) {
            return new Gson().fromJson(reader, new TypeToken<List<Cidade>>(){}.getType());
        } catch (Exception e) {
            throw new RuntimeException("Erro ao carregar JSON", e);
        }
    }
    
}
