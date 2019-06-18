# Spring 全家桶

# Maven 基本使用

```bash
# 创建项目
mvn archtype:generate \
    -DgroupId={project-packaging} \
    -DartifactId={project-name} \
    -DarchtypeArtifactId={maven-template} \
    -DinteractiveMode=false

# 一个具体的命令
mvn archtype:generate \
    -DgroupId=cn.lavenliu \
    -DartifactId=demo
    -DarchtypeArtifactId=maven-archtype-quickstart \
    -DinteractiveMode=false

# 打包
mvn clean package -Dmaven.test.skip=true
```

基本的pom.xml配置：

```xml
<properties>
	<java.version>1.8</java.version>
	<project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
</properties>
```

如果要以`jar`的方式运行，需要在pom.xml文件中添加如下配置：

```xml
<build>
	<plugins>
		<plugin>
			<groupId>org.apache.maven.plugins</groupId>
			<artifactId>maven-shade-plugin</artifactId>
			<version>2.1</version>
			<executions>
				<execution>
					<phase>package</phase>
					<goals>
						<goal>shade</goal>
					</goals>
					<configuration>
						<transformers>
							<transformer
								implementation="org.apache.maven.plugins.shade.resource.ManifestResourceTransformer">
								<mainClass>hello.HelloWorld</mainClass>
							</transformer>
						</transformers>
					</configuration>
				</execution>
			</executions>
		</plugin>
	</plugins>
</build>
```

# Lombok 基本使用

有了 `Lombok` 可以少写很多 `Getter/Setter` 方法，这样代码看上去会很环保。

在 `pom.xml` 文件中加入依赖：

```xml
<dependency>
    <groupId>org.projectlombok</groupId>
    <artifactId>lombok</artifactId>
    <optional>true</optional>
</dependency>
```

常用的注解：
- `@Data`
- `@NoArgsConstructor`

# Hello World

一个最基本的Spring Boot项目是怎么样的。`pom.xml` 文件如下：

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
	<modelVersion>4.0.0</modelVersion>
	<parent>
		<groupId>org.springframework.boot</groupId>
		<artifactId>spring-boot-starter-parent</artifactId>
		<version>2.1.1.RELEASE</version>
		<relativePath/> <!-- lookup parent from repository -->
	</parent>
	<groupId>lavenliu.demo</groupId>
	<artifactId>helloworld</artifactId>
	<version>0.0.1-SNAPSHOT</version>
	<name>HelloWorld</name>
	<description>Demo project for Spring Boot</description>

	<properties>
		<java.version>1.8</java.version>
	</properties>

	<dependencies>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-web</artifactId>
		</dependency>

		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-test</artifactId>
			<scope>test</scope>
		</dependency>
	</dependencies>

	<build>
		<plugins>
			<plugin>
				<groupId>org.springframework.boot</groupId>
				<artifactId>spring-boot-maven-plugin</artifactId>
			</plugin>
		</plugins>
	</build>

</project>
```

# 数据库相关


