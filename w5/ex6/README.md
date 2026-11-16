# w5/ex6 · 盐汽水的串台音响

来源：W5 / sound。提交 `w5/ex6/Main.java`，默认包，只有 `Main` 为 public 顶层类。

## 背景

盐汽水按下1号键，音响非要顺便串到2号频道。Gay哥还把全场礼花锁成共享库存。请实现SoundBoard，保留这次有意的串台。

## 要求

1. 字段为private int energy=0和private static int confetti=3。tap(mode)用switch处理mode：1先加2再穿透2继续加3，2只加3，0只加1，其他整数不变。

2. 每次tap结束后energy最多为9。必须实际使用switch且case 1到case 2之间不写break。

3. perform()仅在energy>=4且confetti>0时消耗4点energy和1份confetti。失败时都不变，且所有对象共享confetti。

4. show()输出“energy confetti”，一个半角空格、一次换行。其他方法静默，创建新对象不补礼花。

## OJ 输入驱动

原题通过固定 Main 调用对象方法。此处提供读取命令的 Main，让 OJ 能用多组输入测试同一个类。保留 Main，补全上方作答类。每个测试用例都启动新的 JVM，共享库存只在同一组命令内共享。

第一行是命令数 q，随后 q 条命令。id 为对象编号。先创建对象，再操作；编号唯一。参数遵守上文范围。输入不会包含未知命令。

| 命令 | 参数 |
| --- | --- |
| `new` | `id` |
| `tap` | `id mode` |
| `perform` | `id` |
| `show` | `id` |

`new` 使用有参构造；若该类只有无参构造，则使用无参构造。`default` 使用无参构造。`show` 调用 show()；其他命令调用同名方法。

对象操作本身产生的输出，按原题要求直接写到标准输出，不打印提示文字。

## 样例

输入与预期输出分别见 [samples/1.in](samples/1.in) 和 [samples/1.out](samples/1.out)。

## 运行与提交

在仓库根目录运行：

```sh
./gradlew --quiet --console=plain :w5:runEx6 < w5/ex6/samples/1.in
```

提交 PR 后评论 `@minioj-bot run w5/ex6`。OJ 严格比较输出，包括空格与末尾换行。题面要求的字段、构造链、switch 穿透、this/super 和多态等代码结构由 PR 审阅检查；OJ 检查多组输入下的行为。原网站的知识题、分数权重和提交次数限制不适用于这里。
