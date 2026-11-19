# FTC Coding Exercises

FFFabulous Robotics 的 Java 基础练习。

## 开始练习

1. Fork 本仓库，将自己的 fork clone 到本地，新建分支。
2. 进入对应周目录，阅读 README，再补全题目目录中 `Main.java` 的作答代码。类名与文件名保持不变，不添加 package 声明。
3. 在仓库根目录编译全部练习，再运行所选题目，例如对 w2/ex1 运行样例 1：

   ```sh
   ./gradlew build
   ./gradlew --quiet --console=plain :w2:runEx1 < w2/ex1/samples/1.in
   ```

   Windows 可在 Git Bash 中运行以上命令，或在命令提示符中将 `./gradlew` 替换为 `gradlew.bat`。首次运行会下载 Gradle 9.1.0；编译使用本机安装的 JDK 21。无需全局安装 Gradle。

   也可以直接运行 Java 工具：

   ```sh
   javac --release 21 -encoding UTF-8 w1/ex1/Main.java
   java -cp w1/ex1 Main < w1/ex1/samples/1.in
   ```

4. 对照 `samples/1.out` 检查输出，将代码 commit 并 push，向 **FFFabulousRobotics/FTCCodingExercises** 创建 PR。
5. 在 PR 评论中输入 `@minioj-bot run w1/ex1`，替换为本题编号。修改代码并 push 后，再评论即可重新评测。每次评论只运行一题。

## Gradle 模块

根项目包含 `w0` 到 `w6` 七个模块。可使用 Gradle 编译 exercises。

在下面的解释中，`i` `j` 和 `k` 都是数字：

| 命令                                           | 作用                         |
|------------------------------------------------|------------------------------|
| `./gradlew projects`                           | 查看所有模块                 |
| `./gradlew build`                              | 编译全部题目                 |
| `./gradlew :wi:build`                          | 编译 Week `i`                |
| `./gradlew :wi:exjClasses`                     | 只编译 `wi/exj`              |
| `./gradlew :wi:exjJar`                         | 构建 `wi/build/libs/exj.jar` |
| `./gradlew --quiet --console=plain :wi:runExj` | 运行 `wi/exj`                |

运行时可用 `< wi/exj/samples/k.in` 提供样例 `k` 的输入，输出与对应 `.out` 文件比较。
也可以在构建后运行 `java -jar wi/build/libs/exj.jar < wi/exj/samples/k.in`。
