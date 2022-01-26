import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.bean.ColumnPositionMappingStrategy;
import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        String[] columnMapping = {"id", "firstName", "lastName", "country", "age"};
        String fileName = "data.csv";
        String gsFileName = "data.json";
        String[] employee = "1,John,Smith,USA,25".split(",");
        String[] employee1 = "2,Inav,Petrov,RU,23".split(",");
        createCSV(fileName, employee, employee1);
        List<Employee> list = parseCSV(columnMapping, fileName);
        String json = listToJson(list);
        writeString(json, gsFileName);
    }

    public static List<Employee> parseCSV(String[] string, String name) {
        List<Employee> list = null;
        try (CSVReader reader = new CSVReader(new FileReader(name))) {
            ColumnPositionMappingStrategy<Employee> strategy = new ColumnPositionMappingStrategy<>();
            strategy.setType(Employee.class);
            strategy.setColumnMapping(string);
            CsvToBean<Employee> csv = new CsvToBeanBuilder<Employee>(reader)
                    .withMappingStrategy(strategy)
                    .build();
            list = csv.parse();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
        return list;
    }

    public static String listToJson(List<Employee> list) {
        String gsonFile = null;
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        Type listType = new TypeToken<List<Employee>>() {
        }.getType();
        return gsonFile = gson.toJson(list, listType);
    }

    public static void writeString(String file, String name) {
        try (FileWriter gsFile = new FileWriter(name)) {
            gsFile.write(file);
            gsFile.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void createCSV(String name, String[] mass, String[] mass2) {
        try (CSVWriter writer = new CSVWriter(new FileWriter(name, true))) {
            writer.writeNext(mass);
            writer.writeNext(mass2);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


