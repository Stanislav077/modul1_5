import java.util.Scanner;

/**
 * Created by Станислав on 14.03.2018.
 */
public class Horse {

    int arr[][];
    int arr2[][];
    int div[][];

    public Horse() {
        arr = new int[5][5];
        arr2 = new int[5 + 4][5 + 4];

        div = new int[8][2];
        div = new int[][] {
                {-1, -2},
                {-2, -1},
                {-2,  1},
                { 1, -2},
                {-1,  2},
                { 2, -1},
                { 1,  2},
                { 2,  1}
        };
    }

    public void init() {
        arr = new int[][] {
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0},
        };
        Scanner in = new Scanner(System.in);
        System.out.println("Введите расположение коня от 1-5 по вертикали");
       int vert = in.nextInt();
        System.out.println("Введите расположение коня от 1-5 по горизонтали");
        int gor = in.nextInt();
        arr[vert-1][gor-1]=5;
        for (int a = 0; a < 9; a++) {
            for (int b = 0; b < 9; b++) {
                arr2[a][b] = -1;
            }
        }

        for (int i = 2; i < arr2.length - 2; i++) {
            for (int j = 2; j < arr2[i].length - 2; j++) {
                arr2[i][j] = arr[i - 2][j - 2];
            }
        }
    }
    public void moveTo() {
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++) {
                if (arr2[i][j] == 5) {
                    for (int k = 0; k < 8; k++) {
                        if (arr2[i + div[k][0]][j + div[k][1]] == 0) {
                            arr2[i + div[k][0]][j + div[k][1]] = 6;
                        }
                    }
                }
            }
        }
    }
    public String toString() {
        String str = "";
        String arr3 = "*";
        String arr4 = "K";
        String arr5 = "S";
        String arr6 = "х";
        for (int i = 0; i < arr2.length; i++) {
            for (int j = 0; j < arr2[i].length; j++){
               // str = str + arr2[i][j] + " ";
                if(arr2[i][j] == -1){
                    str = str + arr3 + " ";
                }else if(arr2[i][j] == 0){
                    str = str + arr6 + " ";
                }else if(arr2[i][j] == 6){
                    str = str + arr4 + " ";
                }else{
                    str = str + arr5 + " ";
                }

            }
            str = str + "\n";
        }
        str = str + "\n";
        return str;
    }
}
