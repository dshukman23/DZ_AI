package logger;

public class Main {
    public static void main(String[] args) throws InterruptedException {


        Logger logger1 = new SimpleLogger();
        logger1.log("Закончил учёбу");
        Thread.sleep(3000);
        logger1.log("Почистил зубы");
        Thread.sleep(3000);
        logger1.log("Пошел спать");

        System.out.println();

        Logger logger = new SmartLogger();
        logger.log("Закончил учёбу");
        Thread.sleep(3000);
        logger.log("Почистил зубы");
        Thread.sleep(3000);
        logger.log("Пошел спать");
        Thread.sleep(3000);
        logger.log("Не смог уснуть error");
    }
}
