package MODEL;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class FileManager {

    /**
     * Function takes data from products.cvs and puts it into a set using streams and function mapping
     *
     * @return a set containing distinct menuitems from file
     */
    public static Set<MenuItem> products() {
        String file = "products.csv";
        Set<MenuItem> itemStream = new HashSet<>();
        try {
            Stream<String> stream = Files.lines(Paths.get(file));
            itemStream = stream.skip(1)
                    .map(FileManager::mapping)
                    .collect(Collectors.toSet());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return itemStream;
    }

    /**
     * Function returns a baseproduct object created using data from line split by ',' because is a csv file.
     * @param line a line from file products split
     * @return a new Baseproduct object with attributes being data columns from file
     */
    public static BaseProduct mapping(String line) {
        String[] attributes = line.split(",");
        String title = attributes[0];
        double rating = Double.parseDouble(attributes[1]);
        double calories = Double.parseDouble(attributes[2]);
        double proteins = Double.parseDouble(attributes[3]);
        double fats = Double.parseDouble(attributes[4]);
        double sodium = Double.parseDouble(attributes[5]);
        double price = Double.parseDouble(attributes[6]);
        return new BaseProduct(title, rating, calories, proteins, fats, sodium, price);
    }

    public static void Bill(Order order, List<MenuItem> itemList)
    {
        try {
            FileWriter writer=new FileWriter("bon.txt");
            writer.append(order.toString()+"\n");
            for (MenuItem menuItem : itemList) {
                writer.append(menuItem.toString()+"\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void reports(String report1,String report2,String report3,String report4)
    {
        try {
            FileWriter writer=new FileWriter("reports.txt");
            writer.append("Report 1:\n");
            writer.append(report1);
            writer.append("Report 2:\n");
            writer.append(report2);
            writer.append("Report 3:\n");
            writer.append(report3);
            writer.append("Report 4:\n");
            writer.append(report4);
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
