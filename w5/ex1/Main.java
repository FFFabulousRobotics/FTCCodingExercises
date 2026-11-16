class SaltBottle {
    private int fizz;
    private static int towels = 3;

    public SaltBottle(int fizz) {
        // 在这里补全
    }
    public void shake(int power) {
        // 在这里补全
    }
    public void calm() {
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
        java.util.Map<Integer, SaltBottle> objects = new java.util.HashMap<>();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String command = sc.next();
            int id = sc.nextInt();
            switch (command) {
                case "new": objects.put(id, new SaltBottle(sc.nextInt())); break;
                case "shake": objects.get(id).shake(sc.nextInt()); break;
                case "calm": objects.get(id).calm(); break;
                case "show": objects.get(id).show(); break;
                default: throw new IllegalArgumentException("Unknown command: " + command);
            }
        }
    }
}
