Git is a 言归正传，现在我们编写一个readme.txt文件，内容如下：

Git is a distributed version control system.
Git is free softwar.
Git is really very useful especially for a team.
I'm really enjoy it now.
Hope you will enjoy it,too. Because it's really excellent and there are a lot of developers love it. 
release：预发布分支，当产品即将发布的时候，要进行最后的调整和测试，这时候就可以分出一个预发布分支，进行最后的bug fix。测试完全以后，发布新版本，就可以把预发布分支删除。预发布分支一般命名为release-*。

hotfix：修复bug分支，当产品已经发布了，突然出现了重大的bug。这时候就要新建一个hotfix分支，继续紧急的bug修复工作，当bug修复完以后，把该分支合并到master和develop以后，就可以把该分支删除。修复bug分支命名一般为hotfix-*

release和hotfix分支离我们还比较遥远。。就不详述，有兴趣的同学可以参考本文最后的参考资料进行学习。
