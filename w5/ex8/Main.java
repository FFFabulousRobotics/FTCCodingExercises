class CheerStation {
    private int energy;
    private boolean on = false;
    private static int tickets = 4;

    public CheerStation() {
        // 在这里补全
    }
    public CheerStation(int energy) {
        // 在这里补全
    }
    public void start() {
        // 在这里补全
    }
    public void stop() {
        // 在这里补全
    }
    public void chant(int rounds) {
        // 在这里补全
    }
    public void rest(int gain) {
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
        java.util.Map<Integer, CheerStation> objects = new java.util.HashMap<>();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String command = sc.next();
            int id = sc.nextInt();
            switch (command) {
                case "new": objects.put(id, new CheerStation(sc.nextInt())); break;
                case "default": objects.put(id, new CheerStation()); break;
                case "start": objects.get(id).start(); break;
                case "stop": objects.get(id).stop(); break;
                case "chant": objects.get(id).chant(sc.nextInt()); break;
                case "rest": objects.get(id).rest(sc.nextInt()); break;
                case "show": objects.get(id).show(); break;
                default: throw new IllegalArgumentException("Unknown command: " + command);
            }
        }
    }
}
