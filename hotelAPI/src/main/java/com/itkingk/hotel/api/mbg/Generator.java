package com.itkingk.hotel.api.mbg;

import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.xml.ConfigurationParser;
import org.mybatis.generator.internal.DefaultShellCallback;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * mybatis自动生成model和mapper映射
 * @author kingk
 * @date 2020/4/18 23:03
 */
public class Generator {
	public static void main(String[] args) throws Exception {
		List<String> warnings = new ArrayList<>();
		boolean overwrite = true;

		InputStream is = Generator.class.getResourceAsStream("/db/mybatis-generator.xml");
		ConfigurationParser cp = new ConfigurationParser(warnings);
		Configuration config = cp.parseConfiguration(is);
		is.close();

		DefaultShellCallback callback = new DefaultShellCallback(overwrite);
		MyBatisGenerator generator = new MyBatisGenerator(config, callback, warnings);
		generator.generate(null);
		for (String warning : warnings) {
			System.out.println(warning);
		}
	}
}
