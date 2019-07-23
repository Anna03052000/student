import java.util.Scanner;

class Game {
    int krestik = 0;
    int nolik = 0;
    public char[][] array(){
        char[][] arr = new char[3][3];
        arr[0][0] = '7';
        arr[0][1] = '8';
        arr[0][2] = '9';

        arr[1][0] = '4';
        arr[1][1] = '5';
        arr[1][2] = '6';

        arr[2][0] = '1';
        arr[2][1] = '2';
        arr[2][2] = '3';
        return arr;
    }
    public String checkGame(char[][] arr, int draw ) {
        if (((arr[0][1] == 'X' && arr[1][1] == 'X' && arr[2][1] == 'X')
                || (arr[0][2] == 'X' && arr[1][2] == 'X' && arr[2][2] == 'X')
                || (arr[0][0] == 'X' && arr[1][0] == 'X' && arr[2][0] == 'X'))) {
            return "Проигрыш: Игрок0";
        }
        if (((arr[0][1] == arr[2][1] && arr[1][1] == arr[0][1] && arr[2][1] == arr[1][1])
                || (arr[0][2] == arr[2][2] && arr[1][2] == arr[0][2] && arr[2][2] == arr[1][2])
                || (arr[0][0] == arr[2][0] && arr[1][0] == arr[0][0] && arr[2][0] == arr[1][0]))
                && (arr[0][1] == '0' || arr[0][2] == '0' || arr[0][0] =='0')) {
            return "Проигрыш: ИгрокX";
        }
        if (((arr[0][1] == 'X' && arr[0][0] == 'X' && arr[0][2] == 'X')
                || (arr[1][1] == 'X' && arr[1][0] == 'X' && arr[1][2] == 'X')
                || (arr[2][1] == 'X' && arr[2][0] == 'X' && arr[2][2] == 'X'))) {
            return "Проигрыш: Игрок0";
        }
        if (((arr[0][1] == arr[0][2] && arr[0][0] == arr[0][1] && arr[0][2] == arr[0][0])
                || (arr[1][1] == arr[1][2] && arr[1][0] == arr[1][1] && arr[1][2] == arr[1][0])
                || (arr[2][1] == arr[2][2] && arr[2][0] == arr[2][1] && arr[2][2] == arr[2][0]) )
                && (arr[0][1] == '0' || arr[1][1] == '0' || arr[2][1] == '0')) {
            return "Проигрыш: ИгрокX";
        }
        if (((arr[1][1] == arr[2][2] && arr[0][0] == arr[2][2] && arr[1][1] == arr[0][0])
                || (arr[0][2] == arr[1][1] && arr[2][0] == arr[0][2] && arr[1][1] == arr[2][0]))
                && (arr[1][1] == '0')) {
            return "Проигрыш: ИгрокX";
        }
        if (((arr[1][1] == arr[2][2] && arr[0][0] == arr[2][2] && arr[1][1] == arr[0][0])
                || arr[0][2] == arr[1][1] && arr[2][0] == arr[0][2] && arr[1][1] == arr[2][0])
                && (arr[1][1] == 'X' )) {
            return "Проигрыш: Игрок0";
        }
        if(draw == 0)
            return "Ничья";
        return "";
    }
    public void change1(char [][] arr, char str) {
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr[i].length; j++)
                if (arr[i][j] == str)
                    arr[i][j] = 'X';
    }
    public void change2(char [][] arr, char str){
        for (int i = 0; i < arr.length; i++)
            for (int j = 0; j < arr.length; j++)
                if(arr[i][j] == str)
                    arr[i][j] = '0';
    }
    public  void printArray(char [][]arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] +  "\t");
            }
            System.out.println();
        }
    }
    public char game1() {
        Scanner in = new Scanner(System.in);
        System.out.print("Ходит ИгрокX: ");
        char strkrestik = in.nextLine().charAt(0);
        return strkrestik;
    }
    public char game2() {
        Scanner in = new Scanner(System.in);
        System.out.print("Ходит Игрок0: ");
        char strnolik = in.nextLine().charAt(0);
        return strnolik;
    }
    public void  start(int draw, int num){
        char[][] arr = array();
        String res = "";
        printArray(arr);
        for (int i = 2; i < 11; i++) {
            if (i % 2 == 0) {
                change1(arr, game1());
                printArray(arr);
                res = checkGame(arr,draw);
                System.out.print(res);
                if (res.equals( "Проигрыш: Игрок0")) {
                    krestik++;
                    draw++;
                    System.out.println();
                    break;
                }
            }
            else {
                change2(arr, game2());
                printArray(arr);
                res = checkGame(arr,draw);
                System.out.print(res);
                if (res.equals("Проигрыш: ИгрокX")) {
                    nolik++;draw++;
                    System.out.println();
                    break;
                }
            }
        }
                if(draw == 1 && num!=2 && num!=3) {
                draw=0;
                System.out.println(checkGame(arr, draw));
            }
    }
}




