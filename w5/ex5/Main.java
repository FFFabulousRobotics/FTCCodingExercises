class EchoStage {
    private int shown = 0;
    private boolean active = false;

    public void start() {
        // 在这里补全
    }
    public void stop() {
        // 在这里补全
    }
    public void run(int rounds) {
        // 在这里补全
    }
    public void show() {
        // 在这里补全
    }
}

// 提供的输入驱动：保留 Main，在上方完成作答类。
public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        java.util.Map<Integer, EchoStage> objects = new java.util.HashMap<>();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String command = sc.next();
            int id = sc.nextInt();
            switch (command) {
                case "new": objects.put(id, new EchoStage()); break;
                case "start": objects.get(id).start(); break;
                case "stop": objects.get(id).stop(); break;
                case "run": objects.get(id).run(sc.nextInt()); break;
                case "show": objects.get(id).show(); break;
                default: throw new IllegalArgumentException("Unknown command: " + command);
            }
        }
    }
}
