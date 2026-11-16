# w5/ex1 · 盐汽水的开盖尖叫

来源：W5 / bottle。提交 `w5/ex1/Main.java`，默认包，只有 `Main` 为 public 顶层类。

## 背景

盐汽水一激动就被摇出泡泡，Gay哥只能拿有限的毛巾收拾桌面。请用SaltBottle模拟每瓶独立的泡泡值和全场共享的毛巾。

## 要求

1. 字段为private int fizz和private static int towels=3。每个对象的fizz独立，初值由构造参数指定，保证在0到12之间。

2. shake(power)：power为0到20的整数，泡泡值增加power，超过12时固定为12。

3. calm()：只有fizz>0且towels>0时，消耗1条毛巾，fizz减少4，最低为0。失败操作不改变任何字段。

4. show()只输出“fizz towels”，两个值之间一个半角空格，末尾一次换行。其他方法静默。新对象不能重置毛巾。

## OJ 输入驱动

原题通过固定 Main 调用对象方法。此处提供读取命令的 Main，让 OJ 能用多组输入测试同一个类。保留 Main，补全上方作答类。每个测试用例都启动新的 JVM，共享库存只在同一组命令内共享。

第一行是命令数 q，随后 q 条命令。id 为对象编号。先创建对象，再操作；编号唯一。参数遵守上文范围。输入不会包含未知命令。

| 命令 | 参数 |
| --- | --- |
| `new` | `id fizz` |
| `shake` | `id power` |
| `calm` | `id` |
| `show` | `id` |

`new` 使用有参构造；若该类只有无参构造，则使用无参构造。`default` 使用无参构造。`show` 调用 show()；其他命令调用同名方法。

对象操作本身产生的输出，按原题要求直接写到标准输出，不打印提示文字。

## 样例

输入与预期输出分别见 [samples/1.in](samples/1.in) 和 [samples/1.out](samples/1.out)。

## 运行与提交

在仓库根目录运行：

```sh
./gradlew --quiet --console=plain :w5:runEx1 < w5/ex1/samples/1.in
```

提交 PR 后评论 `@minioj-bot run w5/ex1`。OJ 严格比较输出，包括空格与末尾换行。题面要求的字段、构造链、switch 穿透、this/super 和多态等代码结构由 PR 审阅检查；OJ 检查多组输入下的行为。原网站的知识题、分数权重和提交次数限制不适用于这里。
