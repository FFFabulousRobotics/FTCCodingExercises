# FTC Coding Exercises

FFFabulous Robotics 的 Java 基础练习。使用 JDK 21，所有题目均为普通控制台程序，运行时不需要 Android Studio 或 FTC SDK。

## 开始练习

1. Fork 本仓库，将自己的 fork clone 到本地，新建分支。
2. 根据下表进入题目目录，阅读 README，补全 `Main.java` 中的作答代码。类名与文件名保持一致，不添加 package 声明。
3. 在仓库根目录编译全部练习，再运行所选题目，例如：

   ```sh
   ./gradlew build
   ./gradlew --quiet --console=plain :w1:runEx1 < w1/ex1/samples/1.in
   ```

   Windows 可在 Git Bash 中运行以上命令，或在命令提示符中将 `./gradlew` 替换为 `gradlew.bat`。首次运行会下载 Gradle 9.1.0；编译使用本机安装的 JDK 21。无需全局安装 Gradle。

   也可以直接运行 Java 工具：

   ```sh
   javac --release 21 -encoding UTF-8 w1/ex1/Main.java
   java -cp w1/ex1 Main < w1/ex1/samples/1.in
   ```

4. 对照 `samples/1.out` 检查输出，将代码 commit 并 push，向 **FFFabulousRobotics/FTCCodingExercises** 创建 PR。
5. 在 PR 评论中输入 `@minioj-bot run w1/ex1`，替换为本题编号。修改代码并 push 后，再评论即可重新评测。每次评论只运行一题。

只提交题目代码；不要提交 `.class` 或 `.build/`。通常一个 PR 完成一题，标题写明题号。样例通过后仍应检查边界条件；正式评测还有其他输入。

## Gradle 模块

根项目包含 `w0` 到 `w6` 七个模块。W0 是环境准备，W3 在当前课程源中没有独立编程题；这两个模块保留周次位置。其他模块按题目分别建立 source set 和可执行 JAR，因此 W5 的八个 `Main` 不会一起编译到同一个输出目录。

本地默认使用腾讯云 Gradle 镜像下载发行包。GitHub 工作流会将默认的 `gradle-wrapper.properties` 重命名为 `gradle-wrapper.local.properties`，再将 `gradle-wrapper.github.properties` 重命名为 `gradle-wrapper.properties`，切换到 Gradle 官方下载源。两份配置都位于 `gradle/wrapper/`。

| 命令                                           | 作用                          |
| ---------------------------------------------- | ----------------------------- |
| `./gradlew projects`                           | 查看所有周模块                |
| `./gradlew build`                              | 编译全部题目的模板或实现      |
| `./gradlew :w5:build`                          | 编译 W5 的八道题              |
| `./gradlew :w5:ex2Classes`                     | 只编译 w5/ex2                 |
| `./gradlew :w5:ex2Jar`                         | 构建 `w5/build/libs/ex2.jar`  |
| `./gradlew --quiet --console=plain :w5:runEx2` | 运行 w5/ex2，从标准输入读命令 |

`build` 编译代码并生成各题的 JAR，不判定答案是否正确。运行时可用 `< w5/ex2/samples/1.in` 提供样例输入，输出与对应 `.out` 文件比较。也可以在构建后运行 `java -jar w5/build/libs/ex2.jar < w5/ex2/samples/1.in`。OJ 使用 Gradle 构建所选题目的 JAR，再逐个输入测试该 JAR；提交无需包含生成的 build 目录。

## 题目

编号按每周编程题连续排列；来源中的小节编号保留在题面中。

| OJ 题号 | 原课程       | 题目                                          |
| ------- | ------------ | --------------------------------------------- |
| w1/ex1  | W1.2 / FP102 | [向 19726 报到](w1/ex1/README.md)             |
| w2/ex1  | W2.4         | [FTC 年度交友大会](w2/ex1/README.md)          |
| w4/ex1  | W4           | [别让 host 变成白开水](w4/ex1/README.md)      |
| w5/ex1  | W5 / bottle  | [盐汽水的开盖尖叫](w5/ex1/README.md)          |
| w5/ex2  | W5 / photo   | [盐汽水和Gay哥的合影机](w5/ex2/README.md)     |
| w5/ex3  | W5 / light   | [盐汽水的三拍应援灯](w5/ex3/README.md)        |
| w5/ex4  | W5 / counter | [盐汽水的彩虹打call机](w5/ex4/README.md)      |
| w5/ex5  | W5 / echo    | [Gay哥和盐汽水的回声彩排](w5/ex5/README.md)   |
| w5/ex6  | W5 / sound   | [盐汽水的串台音响](w5/ex6/README.md)          |
| w5/ex7  | W5 / planner | [盐汽水和Gay哥的拼车箱](w5/ex7/README.md)     |
| w5/ex8  | W5 / station | [盐汽水和Gay哥的双人应援站](w5/ex8/README.md) |
| w6/ex1  | W6.1         | [FTC 年度交友大会 2.0](w6/ex1/README.md)      |

W4/W5 的原题通过固定 Main 调用方法。这里提供读取命令的 Main，便于 OJ 用不同输入调用对象；题面列出了命令格式，保留驱动即可。W6 保留大会的原始输入格式，并提供 `commands` 方法测试模式，另见 [方法模式样例](w6/ex1/samples/4.in)。

输出严格比较，空格、标点和末尾换行都要匹配。使用 `println` 正常换行，不输出提示或调试信息。代码结构要求仍以各题题面为准，由 PR 审阅检查；OJ 检查输入输出行为。

知识选择题、阅读题、环境配置、自我检查和需要 FTC SDK/机器人生命周期的题目不在这个 OJ 题集中。原网站的分数权重、一次提交限制和分配试卷规则没有迁移到 MiniOJ。

## 维护者配置

本仓库的 `.github/workflows/pull-requests.yml` 只保留评论触发条件、权限、并发控制和可复用工作流调用。实际的 checkout、工作区准备、容器评测、artifact 保存和评论发布集中在 `MiniOJ-images/.github/workflows/judge.yml`，其中评测和发布评论仍使用两个独立 job。调用时只传入现有的两个 App secret。

PR 评论工作流拉取 `MiniOJ-images` 仓库发布的 `ghcr.io/fffabulousrobotics/minioj-java21:1.0.1`。镜像提供 JDK 21、Gradle 9.1.0 和从 PyPI 安装的 MiniOJ 0.3.0，每次评测无需重新构建镜像或安装工具。题目配置仍来自独立的 `MiniOJ-config` 仓库。

工作流先在 runner 上将默认分支项目与 PR 的 `Main.java` 组合到 `judge-work/`，再将它以可写方式挂载到容器的 `/workspace`。容器以 runner 的 UID/GID 运行，Gradle 的 build 产物和缓存可直接写入，不需要 sudo。Gradle 用户缓存使用临时目录；配置中的构建命令调用镜像自带的 `gradle --offline`，不重建 wrapper 缓存。

评测时关闭网络。JSON 配置先清理该周的旧产物，再调用对应 `exNJar` 任务，通过 `java -jar` 逐个测试构建产物。MiniOJ 通过 `--output` 保存完整 Markdown，不接触 GitHub 或 token；另一个 job 负责生成带提交版本号的评论，并发布到 PR。完整反馈保存在 workflow artifact 中，超过评论长度限制时只截断评论。

在源仓库中配置 `MINIOJ_CLIENT_ID` 和 `MINIOJ_PRIVATE_KEY`，对应的 GitHub App 需能读取本仓库和 `MiniOJ-config`，并对本仓库有 Issues 写权限以发布 PR 评论。fork 无需配置这些 secrets；应向源仓库提交 PR。合并后的默认分支须包含工作流，评论触发器才会启用。

先将包含可复用工作流的 `MiniOJ-images` 版本标记为 `v1.0.0`，并发布 `1.0.0` 镜像，再启用消费者工作流。GHCR 包可设为公开，或在包的 Manage Actions access 中授予本仓库读取权限；本工作流通过带有 `packages: read` 权限的 `GITHUB_TOKEN` 登录 GHCR。后续升级可复用工作流时，更新调用处 `uses` 的版本。需要覆盖默认镜像或配置仓库时，可在调用处使用 `with.image` 或 `with.config-repository`；后者填写同一 owner 下的仓库名，默认 `MiniOJ-config`。
