# w5/ex2 · 盐汽水和Gay哥的合影机

来源：W5 / photo。提交 `w5/ex2/Main.java`，默认包，只有 `Main` 为 public 顶层类。

## 背景

盐汽水每摆一个造型就想打印照片，Gay哥提醒他：造型属于自己，相纸是大家共用的。请实现PhotoTicket，别让新来的盐汽水把相纸凭空补满。

## 要求

1. 字段为private int poses和private static int paper=5。poses范围0到4。无参构造必须用this(2)调用有参构造；有参初值保证合法。

2. pose(n)：n为0到10，poses增加n但不超过4。

3. printPhoto()：仅当poses>0且paper>0时，两者各减1；否则两个值都不变。创建新对象不重置paper。

4. show()输出“poses paper”，单个半角空格，一次换行。其他方法不能输出任何内容。

## OJ 输入驱动

原题通过固定 Main 调用对象方法。此处提供读取命令的 Main，让 OJ 能用多组输入测试同一个类。保留 Main，补全上方作答类。每个测试用例都启动新的 JVM，共享库存只在同一组命令内共享。

第一行是命令数 q，随后 q 条命令。id 为对象编号。先创建对象，再操作；编号唯一。参数遵守上文范围。输入不会包含未知命令。

| 命令 | 参数 |
| --- | --- |
| `new` | `id poses` |
| `default` | `id` |
| `pose` | `id count` |
| `print` | `id` |
| `show` | `id` |

`new` 使用有参构造；若该类只有无参构造，则使用无参构造。`default` 使用无参构造。`show` 调用 show()；其他命令调用同名方法，其中 `print` 调用 printPhoto()。

对象操作本身产生的输出，按原题要求直接写到标准输出，不打印提示文字。

## 样例

输入与预期输出分别见 [samples/1.in](samples/1.in) 和 [samples/1.out](samples/1.out)。

## 运行与提交

在仓库根目录运行：

```sh
./gradlew --quiet --console=plain :w5:runEx2 < w5/ex2/samples/1.in
```

提交 PR 后评论 `@minioj-bot run w5/ex2`。OJ 严格比较输出，包括空格与末尾换行。题面要求的字段、构造链、switch 穿透、this/super 和多态等代码结构由 PR 审阅检查；OJ 检查多组输入下的行为。原网站的知识题、分数权重和提交次数限制不适用于这里。
