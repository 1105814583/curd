package com.lee.ssm.genarate;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.exception.InvalidConfigurationException;
import org.mybatis.generator.exception.XMLParserException;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.IOException;
import java.io.InputStream;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lee
 * @version 2022/4/18 23:12
 * @since JDK8
 */

public class DoGenerate {

    public static void main(String[] args) throws InterruptedException, SQLException, IOException, InvalidConfigurationException, XMLParserException {
        List<String> list = new ArrayList<>();
        boolean overwrite = true;
        //类路径
        InputStream is = DoGenerate.class.getClassLoader().getResourceAsStream("generatorConfig.xml");
        //项目根路径方式
//        File fileConfig = new File("./src/main/resources/generatorConfig.xml");

        ConfigurationParser cp = new ConfigurationParser(list);
        Configuration config = cp.parseConfiguration(is);
        DefaultShellCallback callback = new DefaultShellCallback(overwrite);
        MyBatisGenerator mybatisGenerate = new MyBatisGenerator(config, callback, list);
        mybatisGenerate.generate(null);
    }

}
