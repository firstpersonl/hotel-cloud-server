package com.itkingk.hotel.api.mbg;

import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.CompilationUnit;
import org.mybatis.generator.api.dom.java.Field;
import org.mybatis.generator.api.dom.java.FullyQualifiedJavaType;
import org.mybatis.generator.internal.DefaultCommentGenerator;
import org.mybatis.generator.internal.util.StringUtility;

import java.util.Properties;

/**
 * 自定义mybatis自动生成器的规则
 * @author kingk
 * @date 2020/4/18 23:04
 */
public class CommentGenerator extends DefaultCommentGenerator {
	private boolean addRemarkComments = false;
	private static final String EXAMPLE_SUFFIX="Example";
	private static final String API_MODEL_PROPERTY_FULL_CLASS_NAME="io.swagger.annotations.ApiModelProperty";
	/**
	 * 设置用户配置的参数
	 */
	@Override
	public void addConfigurationProperties(Properties properties) {
		super.addConfigurationProperties(properties);
		this.addRemarkComments = StringUtility.isTrue(properties.getProperty("addRemarkComments"));
	}

	/**
	 * 给字段添加注释
	 */
	@Override
	public void addFieldComment(Field field, IntrospectedTable introspectedTable,
								IntrospectedColumn introspectedColumn) {
		String remarks = introspectedColumn.getRemarks();
		//根据参数和备注信息判断是否添加备注信息
		if (addRemarkComments && StringUtility.stringHasValue(remarks)) {
			addFieldJavaDoc(field, remarks);
			if (remarks.contains("\"")) {
				remarks = remarks.replace("\"","'");
			}
//			field.addJavaDocLine("@ApiModelProperty(value = \""+remarks+"\")");
		}
	}

	/**
	 * 给model的字段添加注释
	 */
	private void addFieldJavaDoc(Field field, String remarks) {
		//文档注释开始
		field.addJavaDocLine("/**");
		//获取数据库字段的备注信息
		String[] remarkLines = remarks.split(System.getProperty("line.separator"));
		for (String remarkLine : remarkLines) {
			field.addJavaDocLine(" * " + remarkLine);
		}
		addJavadocTag(field, false);
		field.addJavaDocLine(" */");
	}

	/**
	 * 导入包
	 * @param compilationUnit
	 */
//	@Override
//	public void addJavaFileComment(CompilationUnit compilationUnit) {
//		super.addJavaFileComment(compilationUnit);
//		if (!compilationUnit.isJavaInterface()&&!compilationUnit.getType().getFullyQualifiedName().contains(EXAMPLE_SUFFIX)) {
//			compilationUnit.addImportedType(new FullyQualifiedJavaType(API_MODEL_PROPERTY_FULL_CLASS_NAME));
//		}
//	}
}
