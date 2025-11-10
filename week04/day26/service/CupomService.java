package service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.Cupom;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.function.Supplier;

public class CupomService {
    private static final String FILE_PATH = "data/cupons.json";

    // Gson com suporte a LocalDate
    private final Gson gson = new GsonBuilder()
            .setPrettyPrinting()
            .registerTypeAdapter(java.time.LocalDate.class, new com.google.gson.JsonSerializer<java.time.LocalDate>() {
                @Override
                public com.google.gson.JsonElement serialize(java.time.LocalDate src, java.lang.reflect.Type typeOfSrc, com.google.gson.JsonSerializationContext context) {
                    return new com.google.gson.JsonPrimitive(src.toString());
                }
            })
            .registerTypeAdapter(java.time.LocalDate.class, new com.google.gson.JsonDeserializer<java.time.LocalDate>() {
                @Override
                public java.time.LocalDate deserialize(com.google.gson.JsonElement json, java.lang.reflect.Type typeOfT, com.google.gson.JsonDeserializationContext context) throws com.google.gson.JsonParseException {
                    return java.time.LocalDate.parse(json.getAsString());
                }
            })
            .create();
    private final List<Cupom> cupons = new ArrayList<>();

    private final Supplier<Cupom> gerarCupom = () -> {
        String codigo = UUID.randomUUID().toString().substring(0, 8).toUpperCase();
        double desconto = Math.round((Math.random() * 20 + 5) * 100.0) / 100.0; // 5% a 25%
        LocalDate validade = LocalDate.now().plusDays((int)(Math.random() * 30) + 1);
        return new Cupom(codigo, desconto, validade);
    };

    public void gerarNovoCupom() {
        Cupom novo = gerarCupom.get();
        cupons.add(novo);
        System.out.println("Novo cupom gerado:\n" + novo);
    }

    public void listarCupons() {
        if (cupons.isEmpty()) {
            System.out.println("Nenhum cupom gerado ainda.");
            return;
        }
        cupons.forEach(System.out::println);
    }

    public void salvarEmArquivo() {
        try {
            File file = new File(FILE_PATH);
            if (file.getParentFile() != null) {
                file.getParentFile().mkdirs();
            }
            try (FileWriter writer = new FileWriter(file)) {
                gson.toJson(cupons, writer);
            }
            System.out.println("Cupons salvos com sucesso em: " + file.getAbsolutePath());
        } catch (Exception e) {
            System.out.println("Erro ao salvar: " + e);
            e.printStackTrace();
        }
    }

    public void carregarDoArquivo() {
        File f = new File(FILE_PATH);
        if (!f.exists()) {
            // arquivo não existe ainda; nada a carregar
            return;
        }
        try (FileReader reader = new FileReader(f)) {
            Type listType = new TypeToken<List<Cupom>>(){}.getType();
            List<Cupom> lista = gson.fromJson(reader, listType);
            if (lista != null) cupons.addAll(lista);
        } catch (Exception e) {
            System.out.println("Erro ao carregar cupons: " + e);
            e.printStackTrace();
        }
    }
}
