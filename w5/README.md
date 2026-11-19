# Week 5

## w5/ex1 · 盐汽水的开盖尖叫

来源：W5 / bottle。提交 `w5/ex1/Main.java`，默认包，只有 `Main` 为 public 顶层类。

### 背景

盐汽水一激动就被摇出泡泡，Gay哥只能拿有限的毛巾收拾桌面。请用SaltBottle模拟每瓶独立的泡泡值和全场共享的毛巾。

### 要求

1. 字段为private int fizz和private static int towels=3。每个对象的fizz独立，初值由构造参数指定，保证在0到12之间。

2. shake(power)：power为0到20的整数，泡泡值增加power，超过12时固定为12。

3. calm()：只有fizz>0且towels>0时，消耗1条毛巾，fizz减少4，最低为0。失败操作不改变任何字段。

4. show()只输出“fizz towels”，两个值之间一个半角空格，末尾一次换行。其他方法静默。新对象不能重置毛巾。

### OJ 输入驱动

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

### 样例

输入与预期输出分别见 [samples/1.in](ex1/samples/1.in) 和 [samples/1.out](ex1/samples/1.out)。

### 运行与提交

在仓库根目录运行：

```sh
./gradlew --quiet --console=plain :w5:runEx1 < w5/ex1/samples/1.in
```

提交 PR 后评论 `@minioj-bot run w5/ex1`。OJ 严格比较输出，包括空格与末尾换行。题面要求的字段、构造链、switch 穿透、this/super 和多态等代码结构由 PR 审阅检查；OJ 检查多组输入下的行为。原网站的知识题、分数权重和提交次数限制不适用于这里。

## w5/ex2 · 盐汽水和Gay哥的合影机

来源：W5 / photo。提交 `w5/ex2/Main.java`，默认包，只有 `Main` 为 public 顶层类。

### 背景

盐汽水每摆一个造型就想打印照片，Gay哥提醒他：造型属于自己，相纸是大家共用的。请实现PhotoTicket，别让新来的盐汽水把相纸凭空补满。

### 要求

1. 字段为private int poses和private static int paper=5。poses范围0到4。无参构造必须用this(2)调用有参构造；有参初值保证合法。

2. pose(n)：n为0到10，poses增加n但不超过4。

3. printPhoto()：仅当poses>0且paper>0时，两者各减1；否则两个值都不变。创建新对象不重置paper。

4. show()输出“poses paper”，单个半角空格，一次换行。其他方法不能输出任何内容。

### OJ 输入驱动

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

### 样例

输入与预期输出分别见 [samples/1.in](ex2/samples/1.in) 和 [samples/1.out](ex2/samples/1.out)。

### 运行与提交

在仓库根目录运行：

```sh
./gradlew --quiet --console=plain :w5:runEx2 < w5/ex2/samples/1.in
```

提交 PR 后评论 `@minioj-bot run w5/ex2`。OJ 严格比较输出，包括空格与末尾换行。题面要求的字段、构造链、switch 穿透、this/super 和多态等代码结构由 PR 审阅检查；OJ 检查多组输入下的行为。原网站的知识题、分数权重和提交次数限制不适用于这里。

## w5/ex3 · 盐汽水的三拍应援灯

来源：W5 / light。提交 `w5/ex3/Main.java`，默认包，只有 `Main` 为 public 顶层类。

### 背景

Gay哥按下START，盐汽水的应援灯才开始报数；按STOP后再戳按钮也不能偷偷加班。用普通Java模拟这一过程，不连接FTC硬件。

### 要求

1. CheerLight含private int count=10和private boolean running=false。init()必须把字段count设为0、running设为false，不可另建同名局部变量冒充初始化。

2. start()把running设为true；stop()把它设为false，二者都不重置count。

3. loop()每次检查当前running。为false时不输出、不改count；为true时先输出本次count并换行，再将count加2。

4. show()输出“count running”，一个空格、一次换行，boolean按Java小写输出。除loop和show外均静默。

### OJ 输入驱动

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

### 样例

输入与预期输出分别见 [samples/1.in](ex3/samples/1.in) 和 [samples/1.out](ex3/samples/1.out)。

### 运行与提交

在仓库根目录运行：

```sh
./gradlew --quiet --console=plain :w5:runEx3 < w5/ex3/samples/1.in
```

提交 PR 后评论 `@minioj-bot run w5/ex3`。OJ 严格比较输出，包括空格与末尾换行。题面要求的字段、构造链、switch 穿透、this/super 和多态等代码结构由 PR 审阅检查；OJ 检查多组输入下的行为。原网站的知识题、分数权重和提交次数限制不适用于这里。

## w5/ex4 · 盐汽水的彩虹打call机

来源：W5 / counter。提交 `w5/ex4/Main.java`，默认包，只有 `Main` 为 public 顶层类。

### 背景

Gay哥给盐汽水安排循环应援：第1种口号故意串到第2种，大家算分算到怀疑人生。请实现CheerCounter，把这套规则稳定记下来。

### 要求

1. 字段为private int score=0和private int played=0。play(rounds)的rounds在0到20之间，可多次调用，轮次接着以前继续。

2. 每轮先令played加1，再按played%3加分：余1加3分，余2加2分，余0加4分。必须使用switch，实现case 1先加1再无break穿透case 2加2。case 0加4后break。

3. show()输出“score played average”，单空格和一次换行。played为0时average输出0.0；否则必须使用浮点除法计算score/played。

4. play静默，show不改变状态。不能每次play都把轮次或总分清零。

### OJ 输入驱动

原题通过固定 Main 调用对象方法。此处提供读取命令的 Main，让 OJ 能用多组输入测试同一个类。保留 Main，补全上方作答类。每个测试用例都启动新的 JVM，共享库存只在同一组命令内共享。

第一行是命令数 q，随后 q 条命令。id 为对象编号。先创建对象，再操作；编号唯一。参数遵守上文范围。输入不会包含未知命令。

| 命令 | 参数 |
| --- | --- |
| `new` | `id` |
| `play` | `id rounds` |
| `show` | `id` |

`new` 使用有参构造；若该类只有无参构造，则使用无参构造。`default` 使用无参构造。`show` 调用 show()；其他命令调用同名方法。

对象操作本身产生的输出，按原题要求直接写到标准输出，不打印提示文字。

### 样例

输入与预期输出分别见 [samples/1.in](ex4/samples/1.in) 和 [samples/1.out](ex4/samples/1.out)。

### 运行与提交

在仓库根目录运行：

```sh
./gradlew --quiet --console=plain :w5:runEx4 < w5/ex4/samples/1.in
```

提交 PR 后评论 `@minioj-bot run w5/ex4`。OJ 严格比较输出，包括空格与末尾换行。题面要求的字段、构造链、switch 穿透、this/super 和多态等代码结构由 PR 审阅检查；OJ 检查多组输入下的行为。原网站的知识题、分数权重和提交次数限制不适用于这里。

## w5/ex5 · Gay哥和盐汽水的回声彩排

来源：W5 / echo。提交 `w5/ex5/Main.java`，默认包，只有 `Main` 为 public 顶层类。

### 背景

盐汽水负责喊拍子，Gay哥负责暂停。每轮喊出的数和喊完后记住的数不同，暂停期间不能出现幽灵回声。请实现EchoStage。

### 要求

1. 字段为private int shown=0和private boolean active=false。start()设active为true，stop()设为false，不重置shown。

2. run(rounds)的rounds在0到20之间，每次调用的局部i重新从1开始。i<=rounds且当前active为true时才进入本轮。

3. 每轮先用println输出shown的旧值并将shown加1，然后执行shown+=i。需在代码中使用后置自增。run(0)不输出不改值。

4. show()输出“shown active”，单空格、一次换行。start和stop静默；停止后调用run不能输出或改变shown。

### OJ 输入驱动

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

### 样例

输入与预期输出分别见 [samples/1.in](ex5/samples/1.in) 和 [samples/1.out](ex5/samples/1.out)。

### 运行与提交

在仓库根目录运行：

```sh
./gradlew --quiet --console=plain :w5:runEx5 < w5/ex5/samples/1.in
```

提交 PR 后评论 `@minioj-bot run w5/ex5`。OJ 严格比较输出，包括空格与末尾换行。题面要求的字段、构造链、switch 穿透、this/super 和多态等代码结构由 PR 审阅检查；OJ 检查多组输入下的行为。原网站的知识题、分数权重和提交次数限制不适用于这里。

## w5/ex6 · 盐汽水的串台音响

来源：W5 / sound。提交 `w5/ex6/Main.java`，默认包，只有 `Main` 为 public 顶层类。

### 背景

盐汽水按下1号键，音响非要顺便串到2号频道。Gay哥还把全场礼花锁成共享库存。请实现SoundBoard，保留这次有意的串台。

### 要求

1. 字段为private int energy=0和private static int confetti=3。tap(mode)用switch处理mode：1先加2再穿透2继续加3，2只加3，0只加1，其他整数不变。

2. 每次tap结束后energy最多为9。必须实际使用switch且case 1到case 2之间不写break。

3. perform()仅在energy>=4且confetti>0时消耗4点energy和1份confetti。失败时都不变，且所有对象共享confetti。

4. show()输出“energy confetti”，一个半角空格、一次换行。其他方法静默，创建新对象不补礼花。

### OJ 输入驱动

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

### 样例

输入与预期输出分别见 [samples/1.in](ex6/samples/1.in) 和 [samples/1.out](ex6/samples/1.out)。

### 运行与提交

在仓库根目录运行：

```sh
./gradlew --quiet --console=plain :w5:runEx6 < w5/ex6/samples/1.in
```

提交 PR 后评论 `@minioj-bot run w5/ex6`。OJ 严格比较输出，包括空格与末尾换行。题面要求的字段、构造链、switch 穿透、this/super 和多态等代码结构由 PR 审阅检查；OJ 检查多组输入下的行为。原网站的知识题、分数权重和提交次数限制不适用于这里。

## w5/ex7 · 盐汽水和Gay哥的拼车箱

来源：W5 / planner。提交 `w5/ex7/Main.java`，默认包，只有 `Main` 为 public 顶层类。

### 背景

Gay哥给盐汽水瓶安排拼车。瓶子装得下就不多开一箱，有空位必须算清楚，空车也别凭空出现。请实现BoxPlanner。

### 要求

1. private int need和private int perBox由构造方法赋值，保证0<=need<=1000、1<=perBox<=50。对象间独立。

2. add(count)：count非负，且保证增加后need<=1000，只增加本对象need。

3. boxes()返回足够且最少的箱数；empty()返回这些箱子的总空位数。need=0时两者均为0。表达式必须通用，禁止硬编码样例结果。

4. show()输出“need boxes() empty()”，单空格、一次换行。计算方法和add不能输出或修改perBox；boxes与empty也不得修改need。

### OJ 输入驱动

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

### 样例

输入与预期输出分别见 [samples/1.in](ex7/samples/1.in) 和 [samples/1.out](ex7/samples/1.out)。

### 运行与提交

在仓库根目录运行：

```sh
./gradlew --quiet --console=plain :w5:runEx7 < w5/ex7/samples/1.in
```

提交 PR 后评论 `@minioj-bot run w5/ex7`。OJ 严格比较输出，包括空格与末尾换行。题面要求的字段、构造链、switch 穿透、this/super 和多态等代码结构由 PR 审阅检查；OJ 检查多组输入下的行为。原网站的知识题、分数权重和提交次数限制不适用于这里。

## w5/ex8 · 盐汽水和Gay哥的双人应援站

来源：W5 / station。提交 `w5/ex8/Main.java`，默认包，只有 `Main` 为 public 顶层类。

### 背景

盐汽水和Gay哥各有自己的体力，却共用最后4张应援券。喊到没力气或没券必须闭麦，新建分身也不能刷券。实现CheerStation。

### 要求

1. 字段为private int energy、private boolean on=false、private static int tickets=4。无参构造用this(3)；有参energy保证0到8。构造不改tickets。

2. start()：只有energy>0且tickets>0才设on=true，否则设false。stop()设on=false，不改变体力或券数。

3. chant(rounds)：rounds在0到20。每轮仅在on、energy>0、tickets>0同时满足时消耗1体力和1券；条件不满足时设on=false且不消耗。成功消耗后若任一资源为0，也立即设on=false。

4. rest(gain)：gain在0到20，恢复体力且最多为8，不改券数，也不自动开启on。show()输出“energy on tickets”，单空格、一次换行。其余方法静默。

### OJ 输入驱动

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

### 样例

输入与预期输出分别见 [samples/1.in](ex8/samples/1.in) 和 [samples/1.out](ex8/samples/1.out)。

### 运行与提交

在仓库根目录运行：

```sh
./gradlew --quiet --console=plain :w5:runEx8 < w5/ex8/samples/1.in
```

提交 PR 后评论 `@minioj-bot run w5/ex8`。OJ 严格比较输出，包括空格与末尾换行。题面要求的字段、构造链、switch 穿透、this/super 和多态等代码结构由 PR 审阅检查；OJ 检查多组输入下的行为。原网站的知识题、分数权重和提交次数限制不适用于这里。
