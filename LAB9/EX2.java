public class EX2 {
    public static void runFirstThread(String input) {
        for (int i = 0; i < input.length() / 2; i++) {
            char c = input.charAt(i);
            System.out.println("Thread 1: " + c);
        }
    }

    public static void runSecondThread(String input) {
        for (int i = input.length()-1; i >= input.length()/2; i--) {
            char c = input.charAt(i);
            System.out.println("Thread 2: " + c);
        }
    }

    public static void main(String[] args) {
        String string = "Ora de java";
        Thread thread1 = new Thread(() -> runFirstThread(string));
        Thread thread2 = new Thread(() -> runSecondThread(string));
        thread1.start();
        thread2.start();
    }
}
