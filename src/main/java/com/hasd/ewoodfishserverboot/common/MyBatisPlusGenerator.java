package com.hasd.ewoodfishserverboot.common;

import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import java.util.Collections;

public class MyBatisPlusGenerator {

    //表名
    public static final String TABLE_NAME = "user";
    //作者
    public static final String AUTHOR = "hasd";
    //Mapper路径
    public static final String OUT_PUT_FILE = "D:/Code/E-WoodFish-Server-Boot/src/main/resources/mapper";
    //父级路径
    public static final String PARENT_PATH = "D:/Code/E-WoodFish-Server-Boot/src/main/java";
    //父级包名
    public static final String PARENT_CLASS = "com.hasd.ewoodfishserverboot";


    public static void main(String[] args) {
        FastAutoGenerator.create(
                        "jdbc:mysql://hasdsd.cn:3307/ewoodfish",
                        "root",
                        "123456")
                .globalConfig(builder -> {
                    builder.author(AUTHOR) // 设置作者
                            .fileOverride() // 覆盖已生成文件
                            .enableSwagger() // 开启 swagger 模式
                            .outputDir(PARENT_PATH)
                            .disableOpenDir() //不打开目录
                            .commentDate("yyyy-MM-dd");
                })
                .packageConfig(builder -> {
                    builder.parent(PARENT_CLASS) // 设置父包名
                            .pathInfo(Collections.singletonMap(OutputFile.xml, OUT_PUT_FILE));
                })
                .strategyConfig(builder -> {
                    builder.addInclude(TABLE_NAME)//设置表名
                            .entityBuilder()    //entity前置，才能用lombok
                            .enableLombok();  //使用lombok
                })
                .templateEngine(new FreemarkerTemplateEngine())
                .execute();
    }
}
