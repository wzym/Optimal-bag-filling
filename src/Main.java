import java.io.BufferedReader;
//import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Main {
    private Map<Integer, Integer> values = new HashMap<>();
    private int[] gold;

    public static void main(String[] args) throws IOException {
        //long startTime = System.currentTimeMillis();
        new Main().run();
        //long finishTime = System.currentTimeMillis();
        //System.out.println(finishTime - startTime);
    }

    private void run() throws IOException {
        String[][] params = getParams();
        int capacity = Integer.parseInt(params[0][0]);
        int partsAmount = Integer.parseInt(params[0][1]);
        gold = new int[partsAmount];
        for (int i = 0; i < partsAmount; i++) {
            gold[i] = Integer.parseInt(params[1][i]);
        }
        System.out.println(getMaxValue(capacity, gold.length - 1));
    }

    private int getMaxValue(int capacity, int lastItem) {
        int curValue = values.getOrDefault(capacity, 0);
        for (int i = 0; i <= lastItem; i++) {
            if (gold[i] <= capacity) {
                curValue = Math.max(curValue, getMaxValue(capacity - gold[i], i - 1) + gold[i]);
            }
            values.put(capacity, curValue);
        }
        return curValue;
    }

    private String[][] getParams() throws IOException {
        //BufferedReader bf = new BufferedReader(new FileReader("Test.txt"));
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String[][] parameters = new String[2][];
        parameters[0] = bf.readLine().split(" ");
        parameters[1] = bf.readLine().split(" ");
        return parameters;
    }
}