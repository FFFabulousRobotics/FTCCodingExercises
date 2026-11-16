# w6/ex1 · FTC 年度交友大会 2.0

来源：W6.1。提交 `w6/ex1/Main.java`，默认包，只有 `Main` 为 public 顶层类。

## 背景

去年，主办人在FTC找到了伙伴。今年，更多异星旅行者来到FFF星球，中央系统决定用面向对象的方式管理嘉宾。请实现Soda与ForeignTraveler，找到第一位双方都同意的旅行者。

## 要求

## 基类 Soda

Soda保存下列5个private实例字段，通过构造方法使用this初始化。所有列出的构造与方法均为public。构造参数保证合法；构造、getter、setter和canMatch不得输出内容。

- **name**：类型：String；含义：姓名
- **gender**：类型：int；含义：0或1
- **property**：类型：char；含义：A、B、C或D
- **height**：类型：int；含义：身高，按构造参数保存
- **charm**：类型：int；含义：魅力，按构造参数保存

提供构造Soda(String name, int gender, char property, int height, int charm)，以及getName()、getGender()、getProperty()、getHeight()和getCharm()，分别返回对应字段。

setHeight(int height)忽略负数，其他值保存；setCharm(int charm)只保存0到100的值，包含端点。拒绝非法修改时保留原值。0到100仅限制setter修改，不限制构造初值；构造直接保存输入，不调用setter替代赋值。

### canMatch 返回当前对象是否同意对方

签名为boolean canMatch(Soda other)。先检查当前对象this的属性，不能把双方的身高、魅力或性别条件混在同一次判断中。

- **A**：本次判断规则：不附加条件，返回true
- **B**：本次判断规则：仅要求双方gender相同
- **C**：本次判断规则：仅要求双方gender不同
- **D且other也是D**：本次判断规则：直接返回true，跳过父类的身高与魅力比较
- **D且other不是D**：本次判断规则：按other的A/B/C属性检查性别，同时要求other.height < this.height且other.charm > this.charm

D遇到A/B/C时，A无性别限制，B要求双方同性，C要求双方异性。身高和魅力均为严格比较，等号不满足。使用getter读取other的字段即可。

### 输出方法

showInfo()输出一行：本地盐汽水 姓名 性别 属性 身高 魅力。重载showInfo(String prefix)输出一行：prefix 姓名 性别 属性 身高 魅力。各项间单个半角空格，每次调用只换行一次。

## 子类 ForeignTraveler

ForeignTraveler extends Soda，新增private String origin。提供public构造方法，参数依次为name、gender、property、height、charm、origin；先用super(...)初始化父类，再保存origin。可自行提供getOrigin()，但本题不强制这个额外接口。

重写以下两个方法，并保留@Override：

showInfo()输出：异乡旅行者 姓名 性别 属性 身高 魅力 来自:origin。其中“来自:”使用半角冒号，与origin之间没有空格。

canMatch(Soda other)先执行“傲慢规则”：如果对方other的身高<=160，直接返回false。否则调用并返回super.canMatch(other)。检查的是对方，不是旅行者自己的身高；这条子类规则优先于父类D-D特例。

## Main 的处理流程

读入n，创建长度为n的Soda[] travelers。按输入顺序创建Soda或ForeignTraveler对象，存入同一个数组。

创建Soda host = new Soda("主办人", 0, 'D', 165, 90);。

按数组顺序取出Soda类型引用t。仅当t.canMatch(host) && host.canMatch(t)为true时，双方匹配成功。

成功时先输出“宣布无人罪”，再调用t.showInfo()输出其信息，立即结束遍历；没有任何成功者则只输出“罪人舞步旋”。

同一个Soda数组可以存放两种实际类型的对象；用Soda引用调用被重写的实例方法时，执行实际对象的版本。这就是本题要求使用的多态。输入读取可参考随题提供的可选框架，匹配循环由你补全。

## 输入

首行n，1 <= n < 10。随后n条记录：

```text
Local 姓名 性别 属性 身高 魅力
Foreign 姓名 性别 属性 身高 魅力 来自
```

姓名与来自为1到20个不含空白的字符；gender为0或1；property为A/B/C/D。身高与魅力为int范围内的正整数，构造魅力允许大于100。只有setter修改时受各自校验范围约束。

## 输出

成功时输出两行，第一行“宣布无人罪”，第二行调用首位匹配者的showInfo()输出。本地为“本地盐汽水 姓名 性别 属性 身高 魅力”，异乡为“异乡旅行者 姓名 性别 属性 身高 魅力 来自:origin”。无匹配时仅输出“罪人舞步旋”。各字段使用单个半角空格，不得输出调试信息或多余空行。

## 提供的方法测试模式

Main 还提供方法测试入口：首个单词为 `commands`，随后是命令数 q 和 q 条命令。保留 runCommands 方法以及 main 开头的模式分支；正常大会输入仍以 n 开头。编号唯一，创建后再使用。

| 命令 | 参数 | 作用 |
| --- | --- | --- |
| local | id name gender property height charm | 创建 Soda |
| foreign | id name gender property height charm origin | 创建 ForeignTraveler |
| height | id value | 调用 setHeight |
| charm | id value | 调用 setCharm |
| match | id otherId | 输出 canMatch 的 boolean 返回值 |
| get | id | 依次输出五个 getter 的值，单空格分隔 |
| show | id | 调用 showInfo() |
| prefix | id text | 调用 showInfo(text) |

每个输出命令都换行，方法静默要求仍适用。新增测试模式用于检查 setter、重载和子类规则，学生无需自行编写驱动。

## 样例

### 样例 1

输入：

```text
3
Local 提瓦特路人甲 1 A 170 80
Foreign 枫丹水神 0 C 160 95 枫丹
Local 纳塔火龙 1 D 155 85
```

输出：

```text
宣布无人罪
本地盐汽水 纳塔火龙 1 D 155 85
```

### 样例 2

输入：

```text
3
Local 提瓦特路人甲 1 A 170 80
Foreign 枫丹水神 0 C 160 95 枫丹
Foreign 纳塔火龙 1 C 155 85 纳塔
```

输出：

```text
罪人舞步旋
```

### 样例 3

输入：

```text
3
Local 路人 1 A 180 99
Foreign 纳塔旅人 1 C 160 95 纳塔
Local 备用嘉宾 1 D 150 85
```

输出：

```text
宣布无人罪
异乡旅行者 纳塔旅人 1 C 160 95 来自:纳塔
```

## 运行与提交

在仓库根目录运行：

```sh
./gradlew --quiet --console=plain :w6:runEx1 < w6/ex1/samples/1.in
```

提交 PR 后评论 `@minioj-bot run w6/ex1`。OJ 严格比较输出，包括空格与末尾换行。题面要求的字段、构造链、switch 穿透、this/super 和多态等代码结构由 PR 审阅检查；OJ 检查多组输入下的行为。原网站的知识题、分数权重和提交次数限制不适用于这里。
