import java.util.Scanner;

public class QuizOop {
    public static void main(String[] args) {
        Question question1 = new Question("В файл с каким расширением компилируется java-файл?");
        question1.addAnswer(new Answer(question1, "1. cs", false));
        question1.addAnswer(new Answer(question1, "2. java", false));
        question1.addAnswer(new Answer(question1, "3. class", true));
        question1.addAnswer(new Answer(question1, "4. exe", false));

        Question question2 = new Question("С помощью какой команды git можно получить полную копию удаленного репозитория?");
        question2.addAnswer(new Answer(question2, "1. commit", false));
        question2.addAnswer(new Answer(question2, "2. push", false));
        question2.addAnswer(new Answer(question2, "3. clone", true));
        question2.addAnswer(new Answer(question2, "4. copy", false));

        Question question3 = new Question("Какой применяется цикл, когда не известно количество итераций?");
        question3.addAnswer(new Answer(question3, "1. while", true));
        question3.addAnswer(new Answer(question3, "2. for", false));
        question3.addAnswer(new Answer(question3, "3. loop", false));

        Question[] questions = {question1, question2, question3};
        int countCorrect = 0;
        int countWrong = 0;

        System.out.println("Ответьте на вопросы!");

        for (Question question : questions) {
            question.getQuestion();
            question.getAnswers();

            String userAnswer = readAnswer();
            for (Answer answer : question.answers) {
                if (answer != null && answer.isCorrectAnswer)
                    if (userAnswer.equals(answer.answer.split(". ")[0])) {
                        System.out.println("Правильно");
                        countCorrect++;
                    }
                    else {
                        System.out.println("Неправильно");
                        countWrong++;
                    }
            }
            System.out.println();
        }

        System.out.println("Результат: правильно " + countCorrect + ", неправильно " + countWrong);
    }

    public static String readAnswer(){
        Scanner scan = new Scanner(System.in);
        return scan.next();
    }
}

class Question {
    private String question;
    private static final int MAX_ANSWERS = 4;
    protected Answer[] answers = new Answer[MAX_ANSWERS];
    private int count = 0;


    public Question(String question){
        this.question = question;
    }
    public void addAnswer(Answer answer){
        this.answers[count] = answer;
        count++;
    }

    public void getQuestion(){
        System.out.println(question);
    }

    public void getAnswers(){
        for (Answer answer: this.answers){
            if (answer != null)
                System.out.println(answer.answer);
        }
        System.out.println();
    }
}

class Answer {
    protected String answer;
    protected boolean isCorrectAnswer;

    Answer(Question question, String answer, Boolean isCorrectAnswer) {
        if (question == null)
            throw new IllegalArgumentException("Empty question");

        this.answer = answer;
        this.isCorrectAnswer = isCorrectAnswer;
    }
}