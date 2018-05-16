搭建注意事项:
spring-mvc 和 spring 的配置文件分开存放,统一在web.xml中指定路径

spring-mvc配置中设置使用json个数传参以及UTF-8编码,建议使用xml配置 "<mvc:annotation-driven>"
java配置无法设置defaultCharset


参考：
springmvc整体配置参考：
https://blog.csdn.net/vitelon/article/details/53425138

web.xml 文件头参考：
https://blog.csdn.net/shuai_94250/article/details/51036429

