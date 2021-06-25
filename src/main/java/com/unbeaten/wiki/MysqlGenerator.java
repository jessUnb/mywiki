package com.unbeaten.wiki;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

public class MysqlGenerator {
    
    public static void main(String[] args) {
        // 实例化代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

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
        globalConfig.setOutputDir(System.getProperty("user.dir")+"/src/main/java");
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

        // 数据库表策略设置
        StrategyConfig strategyConfig = new StrategyConfig();
        //【实体】是否为lombok模型（默认 false）
        strategyConfig.setEntityLombokModel(true);
        //生成 @RestController 控制器
        strategyConfig.setRestControllerStyle(true);

        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);
        autoGenerator.setStrategy(strategyConfig);

        autoGenerator.execute();

    }

}