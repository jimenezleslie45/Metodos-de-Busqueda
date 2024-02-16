import java.util.Scanner;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> data = loadData("C:\\Users\\leslie\\Desktop\\pseudocodigos3.txt");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el elemento a buscar");
        int element = scanner.nextInt();

        System.out.println("Ingrese el algoritmo a utilizar (1: Binario, 2: Secuencial)");
        int algorithm = scanner.nextInt();

        int result = search(data, element, algorithm);
        System.out.println("Resultado de la búsqueda: " + result);

        scanner.close();
    }

    public static List<Integer> loadData(String filename) {
        List<Integer> data = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (!line.trim().isEmpty()) {
                    int number = Integer.parseInt(line.trim());
                    data.add(number);
                }
            }
        } catch (IOException e) {
            System.out.println("Error al cargar los datos: " + e.getMessage());
        } catch (NumberFormatException e) {
            System.out.println("Error al convertir la cadena a número: " + e.getMessage());
        }
        return data;
    }


    public static int search(List<Integer> data, int element, int algorithm) {
        if (algorithm == 1) {
            return binarySearch(data, element, 0, data.size() - 1);
        } else if (algorithm == 2) {
            return linearSearch(data, element);
        } else {
            return -1;
        }
    }

    public static int binarySearch(List<Integer> data, int element, int start, int end) {
        if (start > end) {
            return -1;
        }
        int mid = (start + end) / 2;
        if (data.get(mid) == element) {
            return mid;
        } else if (data.get(mid) > element) {
            return binarySearch(data, element, start, mid - 1);
        } else {
            return binarySearch(data, element, mid + 1, end);
        }
    }

    public static int linearSearch(List<Integer> data, int element) {
        for (int i = 0; i < data.size(); i++) {
            if (data.get(i) == element) {
                return i;
            }
        }
        return -1;
    }
}
