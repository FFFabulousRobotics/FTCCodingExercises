# w5/ex5 · Gay哥和盐汽水的回声彩排

来源：W5 / echo。提交 `w5/ex5/Main.java`，默认包，只有 `Main` 为 public 顶层类。

## 背景

盐汽水负责喊拍子，Gay哥负责暂停。每轮喊出的数和喊完后记住的数不同，暂停期间不能出现幽灵回声。请实现EchoStage。

## 要求

1. 字段为private int shown=0和private boolean active=false。start()设active为true，stop()设为false，不重置shown。

2. run(rounds)的rounds在0到20之间，每次调用的局部i重新从1开始。i<=rounds且当前active为true时才进入本轮。

3. 每轮先用println输出shown的旧值并将shown加1，然后执行shown+=i。需在代码中使用后置自增。run(0)不输出不改值。

4. show()输出“shown active”，单空格、一次换行。start和stop静默；停止后调用run不能输出或改变shown。

## OJ 输入驱动

原题通过固定 Main 调用对象方法。此处提供读取命令的 Main，让 OJ 能用多组输入测试同一个类。保留 Main，补全上方作答类。每个测试用例都启动新的 JVM，共享库存只在同一组命令内共享。

第一行是命令数 q，随后 q 条命令。id 为对象编号。先创建对象，再操作；编号唯一。参数遵守上文范围。输入不会包含未知命令。

| 命令 | 参数 |
| --- | --- |
| `new` | `id` |
| `start` | `id` |
| `stop` | `id` |
| `run` | `id rounds` |
| `show` | `id` |

`new` 使用有参构造；若该类只有无参构造，则使用无参构造。`default` 使用无参构造。`show` 调用 show()；其他命令调用同名方法。

对象操作本身产生的输出，按原题要求直接写到标准输出，不打印提示文字。

## 样例

输入与预期输出分别见 [samples/1.in](samples/1.in) 和 [samples/1.out](samples/1.out)。

## 运行与提交

在仓库根目录运行：

```sh
./gradlew --quiet --console=plain :w5:runEx5 < w5/ex5/samples/1.in
```

提交 PR 后评论 `@minioj-bot run w5/ex5`。OJ 严格比较输出，包括空格与末尾换行。题面要求的字段、构造链、switch 穿透、this/super 和多态等代码结构由 PR 审阅检查；OJ 检查多组输入下的行为。原网站的知识题、分数权重和提交次数限制不适用于这里。
