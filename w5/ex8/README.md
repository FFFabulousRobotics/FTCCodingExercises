# w5/ex8 · 盐汽水和Gay哥的双人应援站

来源：W5 / station。提交 `w5/ex8/Main.java`，默认包，只有 `Main` 为 public 顶层类。

## 背景

盐汽水和Gay哥各有自己的体力，却共用最后4张应援券。喊到没力气或没券必须闭麦，新建分身也不能刷券。实现CheerStation。

## 要求

1. 字段为private int energy、private boolean on=false、private static int tickets=4。无参构造用this(3)；有参energy保证0到8。构造不改tickets。

2. start()：只有energy>0且tickets>0才设on=true，否则设false。stop()设on=false，不改变体力或券数。

3. chant(rounds)：rounds在0到20。每轮仅在on、energy>0、tickets>0同时满足时消耗1体力和1券；条件不满足时设on=false且不消耗。成功消耗后若任一资源为0，也立即设on=false。

4. rest(gain)：gain在0到20，恢复体力且最多为8，不改券数，也不自动开启on。show()输出“energy on tickets”，单空格、一次换行。其余方法静默。

## OJ 输入驱动

原题通过固定 Main 调用对象方法。此处提供读取命令的 Main，让 OJ 能用多组输入测试同一个类。保留 Main，补全上方作答类。每个测试用例都启动新的 JVM，共享库存只在同一组命令内共享。

第一行是命令数 q，随后 q 条命令。id 为对象编号。先创建对象，再操作；编号唯一。参数遵守上文范围。输入不会包含未知命令。

| 命令 | 参数 |
| --- | --- |
| `new` | `id energy` |
| `default` | `id` |
| `start` | `id` |
| `stop` | `id` |
| `chant` | `id rounds` |
| `rest` | `id gain` |
| `show` | `id` |

`new` 使用有参构造；若该类只有无参构造，则使用无参构造。`default` 使用无参构造。`show` 调用 show()；其他命令调用同名方法。

对象操作本身产生的输出，按原题要求直接写到标准输出，不打印提示文字。

## 样例

输入与预期输出分别见 [samples/1.in](samples/1.in) 和 [samples/1.out](samples/1.out)。

## 运行与提交

在仓库根目录运行：

```sh
./gradlew --quiet --console=plain :w5:runEx8 < w5/ex8/samples/1.in
```

提交 PR 后评论 `@minioj-bot run w5/ex8`。OJ 严格比较输出，包括空格与末尾换行。题面要求的字段、构造链、switch 穿透、this/super 和多态等代码结构由 PR 审阅检查；OJ 检查多组输入下的行为。原网站的知识题、分数权重和提交次数限制不适用于这里。
