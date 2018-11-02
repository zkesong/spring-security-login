package com.zks.spring.security.login.dao;


import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.config.xml.ConfigurationParser;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/10/28.
 */
public class MybatisGenerator {
    public static void main(String[] args) throws Exception{
        List<String> list = new ArrayList<>();
        ConfigurationParser parser = new ConfigurationParser(list);
        Configuration config = parser.parseConfiguration(MybatisGenerator.class.getClassLoader()
                .getResourceAsStream("mybatisGenerator/studentGeneratorConfig.xml"));
        for(TableConfiguration tableConfiguration :
                config.getContext("Postgresql").getTableConfigurations()){
            tableConfiguration.setCountByExampleStatementEnabled(false);
            tableConfiguration.setUpdateByExampleStatementEnabled(false);
            tableConfiguration.setDeleteByExampleStatementEnabled(false);
            tableConfiguration.setSelectByExampleStatementEnabled(false);
            tableConfiguration.setUpdateByPrimaryKeyStatementEnabled(false);
        }
        MyBatisGenerator generator = new MyBatisGenerator(config, null, list);
        generator.generate(null);
    }
}
