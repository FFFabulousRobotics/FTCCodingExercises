# w5/ex3 · 盐汽水的三拍应援灯

来源：W5 / light。提交 `w5/ex3/Main.java`，默认包，只有 `Main` 为 public 顶层类。

## 背景

Gay哥按下START，盐汽水的应援灯才开始报数；按STOP后再戳按钮也不能偷偷加班。用普通Java模拟这一过程，不连接FTC硬件。

## 要求

1. CheerLight含private int count=10和private boolean running=false。init()必须把字段count设为0、running设为false，不可另建同名局部变量冒充初始化。

2. start()把running设为true；stop()把它设为false，二者都不重置count。

3. loop()每次检查当前running。为false时不输出、不改count；为true时先输出本次count并换行，再将count加2。

4. show()输出“count running”，一个空格、一次换行，boolean按Java小写输出。除loop和show外均静默。

## OJ 输入驱动

原题通过固定 Main 调用对象方法。此处提供读取命令的 Main，让 OJ 能用多组输入测试同一个类。保留 Main，补全上方作答类。每个测试用例都启动新的 JVM，共享库存只在同一组命令内共享。

第一行是命令数 q，随后 q 条命令。id 为对象编号。先创建对象，再操作；编号唯一。参数遵守上文范围。输入不会包含未知命令。

| 命令 | 参数 |
| --- | --- |
| `new` | `id` |
| `init` | `id` |
| `start` | `id` |
| `loop` | `id` |
| `stop` | `id` |
| `show` | `id` |

`new` 使用有参构造；若该类只有无参构造，则使用无参构造。`default` 使用无参构造。`show` 调用 show()；其他命令调用同名方法。

对象操作本身产生的输出，按原题要求直接写到标准输出，不打印提示文字。

## 样例

输入与预期输出分别见 [samples/1.in](samples/1.in) 和 [samples/1.out](samples/1.out)。

## 运行与提交

在仓库根目录运行：

```sh
./gradlew --quiet --console=plain :w5:runEx3 < w5/ex3/samples/1.in
```

提交 PR 后评论 `@minioj-bot run w5/ex3`。OJ 严格比较输出，包括空格与末尾换行。题面要求的字段、构造链、switch 穿透、this/super 和多态等代码结构由 PR 审阅检查；OJ 检查多组输入下的行为。原网站的知识题、分数权重和提交次数限制不适用于这里。
