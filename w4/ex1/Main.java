class Soda {
    private int hp;
    private static int potions = 2;

    public Soda(int hp) {
        // 补全构造方法
    }
    public void hurt(int damage) {
        // 补全扣血逻辑
    }
    public void heal() {
        // 补全治疗逻辑
    }
    public void show() {
        // 补全输出逻辑
    }
}

// 提供的输入驱动：保留 Main，在上方完成作答类。
public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        java.util.Map<Integer, Soda> objects = new java.util.HashMap<>();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String command = sc.next();
            int id = sc.nextInt();
            switch (command) {
                case "new": objects.put(id, new Soda(sc.nextInt())); break;
                case "hurt": objects.get(id).hurt(sc.nextInt()); break;
                case "heal": objects.get(id).heal(); break;
                case "show": objects.get(id).show(); break;
                default: throw new IllegalArgumentException("Unknown command: " + command);
            }
        }
    }
}
