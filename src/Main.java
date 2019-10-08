import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
//import java.io.InputStreamReader;

public class Main {
    private int[] gold;

    public static void main(String[] args) throws IOException {
        long startTime = System.currentTimeMillis();
        new Main().run();
        long finishTime = System.currentTimeMillis();
        System.out.println(finishTime - startTime);
    }

    private void run() throws IOException {
        String[][] params = getParams();
        int capacity = Integer.parseInt(params[0][0]);
        int partsAmount = Integer.parseInt(params[0][1]);
        gold = new int[partsAmount];
        for (int i = 0; i < partsAmount; i++) {
            gold[i] = Integer.parseInt(params[1][i]);
        }
        System.out.println(getMaxValue(capacity));
    }

    private int getMaxValue(int capacity) {
        int[][] values = new int[capacity + 1][gold.length + 1];
        for (int w = 0; w < capacity; w++) {
            values[w][0] = 0;
        }
        for (int i = 0; i < gold.length; i++) {
            values[0][i] = 0;
        }
        for (int i = 1; i <= gold.length; i++) {
            for (int w = 1; w <= capacity; w++) {
                values[w][i] = values[w][i - 1];
                if (gold[i - 1] <= w)
                    values[w][i] = Math.max(values[w][i], values[w - gold[i - 1]][i - 1] + gold[i - 1]);
            }
        }
        return values[capacity][gold.length];
    }

    private String[][] getParams() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("Test.txt"));
        //BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[][] parameters = new String[2][];
        parameters[0] = bf.readLine().split(" ");
        parameters[1] = bf.readLine().split(" ");
        return parameters;
    }
}