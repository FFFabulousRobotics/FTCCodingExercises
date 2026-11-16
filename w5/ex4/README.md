# w5/ex4 · 盐汽水的彩虹打call机

来源：W5 / counter。提交 `w5/ex4/Main.java`，默认包，只有 `Main` 为 public 顶层类。

## 背景

Gay哥给盐汽水安排循环应援：第1种口号故意串到第2种，大家算分算到怀疑人生。请实现CheerCounter，把这套规则稳定记下来。

## 要求

1. 字段为private int score=0和private int played=0。play(rounds)的rounds在0到20之间，可多次调用，轮次接着以前继续。

2. 每轮先令played加1，再按played%3加分：余1加3分，余2加2分，余0加4分。必须使用switch，实现case 1先加1再无break穿透case 2加2。case 0加4后break。

3. show()输出“score played average”，单空格和一次换行。played为0时average输出0.0；否则必须使用浮点除法计算score/played。

4. play静默，show不改变状态。不能每次play都把轮次或总分清零。

## OJ 输入驱动

原题通过固定 Main 调用对象方法。此处提供读取命令的 Main，让 OJ 能用多组输入测试同一个类。保留 Main，补全上方作答类。每个测试用例都启动新的 JVM，共享库存只在同一组命令内共享。

第一行是命令数 q，随后 q 条命令。id 为对象编号。先创建对象，再操作；编号唯一。参数遵守上文范围。输入不会包含未知命令。

| 命令 | 参数 |
| --- | --- |
| `new` | `id` |
| `play` | `id rounds` |
| `show` | `id` |

`new` 使用有参构造；若该类只有无参构造，则使用无参构造。`default` 使用无参构造。`show` 调用 show()；其他命令调用同名方法。

对象操作本身产生的输出，按原题要求直接写到标准输出，不打印提示文字。

## 样例

输入与预期输出分别见 [samples/1.in](samples/1.in) 和 [samples/1.out](samples/1.out)。

## 运行与提交

在仓库根目录运行：

```sh
./gradlew --quiet --console=plain :w5:runEx4 < w5/ex4/samples/1.in
```

提交 PR 后评论 `@minioj-bot run w5/ex4`。OJ 严格比较输出，包括空格与末尾换行。题面要求的字段、构造链、switch 穿透、this/super 和多态等代码结构由 PR 审阅检查；OJ 检查多组输入下的行为。原网站的知识题、分数权重和提交次数限制不适用于这里。
