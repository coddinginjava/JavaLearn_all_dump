import java.util.Arrays;

public class Test {

    public static void main(String[] args) {
        String[] names = {
                "Adam",
                "Brian",
                "Charles",
                "Dillon",
                "Eman",
                "Sai", "tylor"};

        System.out.println("names = " + Arrays.deepToString(horSort(names, 2)));

    }

    private static String[][] horSort(String[] names, int col) {
        int row = names.length / col + 1;
        String[][] results = new String[row][col];
        for(int i = 0 ; i < names.length ; i++)
        {
            results[i/col ][ i%col ] = names[i];
        }

        return results;

    }

    /*"Adam", "Brian", "Charles"
"   Dillon", "Eman", "Sai",
    tylor*/
}


