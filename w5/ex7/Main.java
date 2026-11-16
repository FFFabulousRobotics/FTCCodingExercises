class BoxPlanner {
    private int need;
    private int perBox;

    public BoxPlanner(int need, int perBox) {
        // 在这里补全
    }
    public void add(int count) {
        // 在这里补全
    }
    public int boxes() {
        // 在这里补全
        return 0;
    }
    public int empty() {
        // 在这里补全
        return 0;
    }
    public void show() {
        // 在这里补全
    }
}

// 提供的输入驱动：保留 Main，在上方完成作答类。
public class Main {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        java.util.Map<Integer, BoxPlanner> objects = new java.util.HashMap<>();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String command = sc.next();
            int id = sc.nextInt();
            switch (command) {
                case "new": objects.put(id, new BoxPlanner(sc.nextInt(), sc.nextInt())); break;
                case "add": objects.get(id).add(sc.nextInt()); break;
                case "boxes": System.out.println(objects.get(id).boxes()); break;
                case "empty": System.out.println(objects.get(id).empty()); break;
                case "show": objects.get(id).show(); break;
                default: throw new IllegalArgumentException("Unknown command: " + command);
            }
        }
    }
}
