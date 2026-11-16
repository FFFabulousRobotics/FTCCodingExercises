# w5/ex7 · 盐汽水和Gay哥的拼车箱

来源：W5 / planner。提交 `w5/ex7/Main.java`，默认包，只有 `Main` 为 public 顶层类。

## 背景

Gay哥给盐汽水瓶安排拼车。瓶子装得下就不多开一箱，有空位必须算清楚，空车也别凭空出现。请实现BoxPlanner。

## 要求

1. private int need和private int perBox由构造方法赋值，保证0<=need<=1000、1<=perBox<=50。对象间独立。

2. add(count)：count非负，且保证增加后need<=1000，只增加本对象need。

3. boxes()返回足够且最少的箱数；empty()返回这些箱子的总空位数。need=0时两者均为0。表达式必须通用，禁止硬编码样例结果。

4. show()输出“need boxes() empty()”，单空格、一次换行。计算方法和add不能输出或修改perBox；boxes与empty也不得修改need。

## OJ 输入驱动

原题通过固定 Main 调用对象方法。此处提供读取命令的 Main，让 OJ 能用多组输入测试同一个类。保留 Main，补全上方作答类。每个测试用例都启动新的 JVM，共享库存只在同一组命令内共享。

第一行是命令数 q，随后 q 条命令。id 为对象编号。先创建对象，再操作；编号唯一。参数遵守上文范围。输入不会包含未知命令。

| 命令 | 参数 |
| --- | --- |
| `new` | `id need perBox` |
| `add` | `id count` |
| `boxes` | `id` |
| `empty` | `id` |
| `show` | `id` |

`new` 使用有参构造；若该类只有无参构造，则使用无参构造。`default` 使用无参构造。`show` 调用 show()；其他命令调用同名方法。`boxes`、`empty` 分别输出对应方法的返回值并换行。

对象操作本身产生的输出，按原题要求直接写到标准输出，不打印提示文字。

## 样例

输入与预期输出分别见 [samples/1.in](samples/1.in) 和 [samples/1.out](samples/1.out)。

## 运行与提交

在仓库根目录运行：

```sh
./gradlew --quiet --console=plain :w5:runEx7 < w5/ex7/samples/1.in
```

提交 PR 后评论 `@minioj-bot run w5/ex7`。OJ 严格比较输出，包括空格与末尾换行。题面要求的字段、构造链、switch 穿透、this/super 和多态等代码结构由 PR 审阅检查；OJ 检查多组输入下的行为。原网站的知识题、分数权重和提交次数限制不适用于这里。
