import java.util.Scanner;

public class Quiz {
    public static void main(String[] args) {
        System.out.println("Ответьте на вопросы!");

        String[] questions = {
                "В файл с каким расширением компилируется java-файл?",
                "С помощью какой команды git можно получить полную копию удаленного репозитория?",
                "Какой применяется цикл, когда не известно количество итераций?"
        };

        String[][] answers = {
                {"1. cs", "2. java", "3. class", "4. exe"},
                {"1. commit", "2. push", "3. clone", "4. copy"},
                {"1. while", "2. for", "3. loop"}
        };

        int[] correctAnswers = {3, 3, 1};

        int countCorrect = 0;
        int countWrong = 0;

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);

            for (int j = 0; j < answers[i].length; j++) {
                System.out.println(answers[i][j]);
            }

            System.out.println();
            Scanner scan = new Scanner(System.in);
            int answer = scan.nextInt();

            if (answer == correctAnswers[i]) {
                System.out.println("Правильно");
                countCorrect++;
            } else {
                System.out.println("Неправильно");
                countWrong++;
            }

            System.out.println();
        }

        System.out.println("Результат: правильно " + countCorrect + ", неправильно " + countWrong);
    }
}