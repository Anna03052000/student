
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int k = 0;
        Scanner in = new Scanner(System.in);
        Game game = new Game();
        char[][] arr = game.array();
        do {
            int draw =1;
            System.out.println("Начать игру нажмите - 1");
            System.out.println("собрать статистику нажмите - 2");
            System.out.println("Выйти из приложения нажмите - 3");
            int num = in.nextInt();
            in.nextLine();
            if (num == 1) {
                game.start(draw,num);
            }
            else if (num == 2) {
                System.out.println("Статистика");
                System.out.printf("ИгрокX: %d  \n", game.krestik);
                System.out.printf("Игрок0: %d  \n", game.nolik);
            }
            else if (num == 3) {
                k++;
            }
        }while(k < 1);
    }
}
