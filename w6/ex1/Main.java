import java.util.Scanner;

class Soda {
    private String name;
    private int gender;
    private char property;
    private int height;
    private int charm;
    public Soda(String name, int gender, char property, int height, int charm) {
        // TODO 使用this初始化全部字段
    }
    public String getName() { return null; }
    public int getGender() { return 0; }
    public char getProperty() { return 'A'; }
    public int getHeight() { return 0; }
    public int getCharm() { return 0; }
    public void setHeight(int height) { /* TODO 校验并修改 */ }
    public void setCharm(int charm) { /* TODO 校验并修改 */ }
    public boolean canMatch(Soda other) { return false; }
    public void showInfo() { /* TODO 本地格式 */ }
    public void showInfo(String prefix) { /* TODO 自定义前缀格式 */ }
}
class ForeignTraveler extends Soda {
    private String origin;
    public ForeignTraveler(String name, int gender, char property, int height, int charm, String origin) {
        super(name, gender, property, height, charm);
        // TODO 初始化origin
    }
    @Override
    public void showInfo() { /* TODO 异乡格式 */ }
    @Override
    public boolean canMatch(Soda other) { return false; }
}

// 在Main外实现Soda和ForeignTraveler。
public class Main {
    // 提供的对象方法测试驱动，保留此方法。
    private static void runCommands(Scanner sc) {
        java.util.Map<Integer, Soda> objects = new java.util.HashMap<>();
        int q = sc.nextInt();
        for (int i = 0; i < q; i++) {
            String command = sc.next();
            int id = sc.nextInt();
            switch (command) {
                case "local":
                    objects.put(id, new Soda(sc.next(), sc.nextInt(), sc.next().charAt(0), sc.nextInt(), sc.nextInt()));
                    break;
                case "foreign":
                    objects.put(id, new ForeignTraveler(sc.next(), sc.nextInt(), sc.next().charAt(0), sc.nextInt(), sc.nextInt(), sc.next()));
                    break;
                case "height": objects.get(id).setHeight(sc.nextInt()); break;
                case "charm": objects.get(id).setCharm(sc.nextInt()); break;
                case "match": System.out.println(objects.get(id).canMatch(objects.get(sc.nextInt()))); break;
                case "show": objects.get(id).showInfo(); break;
                case "prefix": objects.get(id).showInfo(sc.next()); break;
                case "get":
                    Soda s = objects.get(id);
                    System.out.println(s.getName() + " " + s.getGender() + " " + s.getProperty() + " " + s.getHeight() + " " + s.getCharm());
                    break;
                default: throw new IllegalArgumentException("Unknown command: " + command);
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        if (sc.hasNext("commands")) {
            sc.next();
            runCommands(sc);
            return;
        }
        int n = sc.nextInt();
        Soda[] travelers = new Soda[n];
        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            int gender = sc.nextInt();
            char property = sc.next().charAt(0);
            int height = sc.nextInt();
            int charm = sc.nextInt();
            if (type.equals("Local")) {
                travelers[i] = new Soda(name, gender, property, height, charm);
            } else {
                String origin = sc.next();
                travelers[i] = new ForeignTraveler(name, gender, property, height, charm, origin);
            }
        }
        Soda host = new Soda("主办人", 0, 'D', 165, 90);
        // TODO 按顺序检查双方是否同意，调用t.showInfo()，只输出第一位成功者。
        // TODO 若无人成功，输出“罪人舞步旋”。
    }
}
