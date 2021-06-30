package com.unbeaten.wiki;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.core.toolkit.StringPool;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.util.ArrayList;
import java.util.List;

public class MysqlGenerator {
    
    public static void main(String[] args) {
        // 实例化代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();
        String projectPath = System.getProperty("user.dir");//得到当前项目的路径
        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setUrl("jdbc:mysql://localhost:3306/wiki?useUnicode=true&characterEncoding=utf8");
        dsc.setDriverName("com.mysql.cj.jdbc.Driver");
        dsc.setUsername("root");
        dsc.setPassword("root");
        autoGenerator.setDataSource(dsc);

        //全局配置
        GlobalConfig globalConfig = new GlobalConfig();
        globalConfig.setOutputDir(projectPath+"/src/main/java");
        globalConfig.setOpen(false);
        globalConfig.setAuthor("unbeaten");
        autoGenerator.setGlobalConfig(globalConfig);

        // 包配置（生成的entity、controller、service等包名）
        PackageConfig packageConfig = new PackageConfig();
        packageConfig.setParent("com.unbeaten.wiki");

//        在Parent下面再生成一个包放生成的代码
//        packageConfig.setModuleName("generator");

        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setServiceImpl("service.impl");
        packageConfig.setMapper("mapper");
        packageConfig.setEntity("domain");

        autoGenerator.setPackageInfo(packageConfig);


        // 自定义配置
        InjectionConfig cfg = new InjectionConfig() {
            @Override
            public void initMap() {
                // to do nothing
            }
        };

//         如果模板引擎是 velocity
        String templatePath = "/templates/mapper.xml.vm";

        // 自定义输出配置
        List<FileOutConfig> focList = new ArrayList<>();
        // 自定义配置会被优先输出
        focList.add(new FileOutConfig(templatePath) {
            @Override
            public String outputFile(TableInfo tableInfo) {
                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
                return projectPath + "/src/main/resources/mapper/" + tableInfo.getEntityName() + "Mapper" + StringPool.DOT_XML;
            }
        });

        cfg.setFileOutConfigList(focList);
        autoGenerator.setCfg(cfg);

        // 配置模板
        TemplateConfig templateConfig = new TemplateConfig();

        templateConfig.setXml(null);
        autoGenerator.setTemplate(templateConfig);

        // 数据库表策略设置
        StrategyConfig strategyConfig = new StrategyConfig();
        //【实体】是否为lombok模型（默认 false）
        strategyConfig.setEntityLombokModel(true);
        //生成 @RestController 控制器
        strategyConfig.setRestControllerStyle(true);
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);

//        strategyConfig.setI nclude("content");
        autoGenerator.setStrategy(strategyConfig);


        autoGenerator.execute();

    }

}