import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
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
        int[] gold = new int[partsAmount];
        for (int i = 0; i < partsAmount; i++) {
            gold[i] = Integer.parseInt(params[1][i]);
        }
        System.out.println(getMaxAmount(capacity, gold));
    }

    private int getMaxAmount(int capacity, int[] gold) {
        return 0;
    }

    private String[][] getParams() throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("Test.txt"));
        String[][] parameters = new String[2][];
        parameters[0] = bf.readLine().split(" ");
        parameters[1] = bf.readLine().split(" ");
        return parameters;
    }
}