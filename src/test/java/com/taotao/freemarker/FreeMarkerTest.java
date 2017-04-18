package com.taotao.freemarker;

import java.io.File;
import java.io.FileWriter;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;

import freemarker.template.Configuration;
import freemarker.template.Template;

public class FreeMarkerTest {

	public class Student{
		public Student(int id,String name,String address){
			this.id =id;
			this.name=name;
			this.address=address;
		}
		private int id;
		private String name;
		private String address;
		public int getId() {
			return id;
		}
		public void setId(int id) {
			this.id = id;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
	}
	
	@Test
	public void testFreeMarker() throws Exception{
		Configuration configuration = new Configuration(Configuration.getVersion());
		configuration.setDirectoryForTemplateLoading(new File("E:\\Program\\Java-SSM\\TaoTao\\taotao-portal\\src\\main\\webapp\\WEB-INF\\ftl"));
		configuration.setDefaultEncoding("utf-8");
		Template template = configuration.getTemplate("first.ftl");
		Map root = new HashMap();
		root.put("hello", "freemarker");
		Writer out= new FileWriter(new File("E:\\Program\\Java-SSM\\TaoTao\\test\\testFreemarker\\hello.html"));
		template.process(root, out);
		out.flush();
		out.close();
		
		
	}
	
	@Test
	public void testFreeMarkerTemplete() throws Exception{
		Configuration configuration = new Configuration(Configuration.getVersion());
		configuration.setDirectoryForTemplateLoading(new File("E:\\Program\\Java-SSM\\TaoTao\\taotao-portal\\src\\main\\webapp\\WEB-INF\\ftl"));
		configuration.setDefaultEncoding("utf-8");
		Template template = configuration.getTemplate("second.ftl");
		Map root = new HashMap<>();
		root.put("title", "hello freemarker");
		root.put("student",new Student(1,"test1","Toronto"));
		
		List<Student> stuList = new ArrayList<>();
		stuList.add(new Student(1,"test1","beijing1"));
		stuList.add(new Student(2,"test2","beijing2"));
		stuList.add(new Student(3,"test3","beijing3"));
		stuList.add(new Student(4,"test4","beijing4"));
		root.put("students", stuList);
		root.put("curdate", new Date());
		Writer out= new FileWriter(new File("E:\\Program\\Java-SSM\\TaoTao\\test\\testFreemarker\\second.html"));
		template.process(root, out);
		out.flush();
		out.close();
		
		
	}
}
