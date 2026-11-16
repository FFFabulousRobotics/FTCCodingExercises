class PhotoTicket {
    private int poses;
    private static int paper = 5;

    public PhotoTicket() {
        // 在这里补全
    }
    public PhotoTicket(int poses) {
        // 在这里补全
    }
    public void pose(int n) {
        // 在这里补全
    }
    public void printPhoto() {
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
        java.util.Map<Integer, PhotoTicket> objects = new java.util.HashMap<>();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String command = sc.next();
            int id = sc.nextInt();
            switch (command) {
                case "new": objects.put(id, new PhotoTicket(sc.nextInt())); break;
                case "default": objects.put(id, new PhotoTicket()); break;
                case "pose": objects.get(id).pose(sc.nextInt()); break;
                case "print": objects.get(id).printPhoto(); break;
                case "show": objects.get(id).show(); break;
                default: throw new IllegalArgumentException("Unknown command: " + command);
            }
        }
    }
}
