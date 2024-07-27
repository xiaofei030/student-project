package homework2;

import org.apache.ibatis.cursor.Cursor;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Project: homework2
 * @Author: pgthinker
 * @GitHub: https://github.com/ningning0111
 * @Date: 2024/6/9 19:27
 * @Description:
 */
public class UseMybatis {
    private static SqlSession session;

    static {
        try {
            String resource = "mybatis-config.xml";
            InputStream inputStream = Resources.getResourceAsStream(resource);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            session = sqlSessionFactory.openSession();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {
        System.out.println("=======单表查询=====");
        List<Course> courses = session.selectList("course.findCourseAll");
        System.out.println(courses);
        System.out.println("===================");


        System.out.println("======关联表查询=====");
        List<Student> students = session.selectList("course.findStudentByCourseName", "JAVA WEB程序设计");
        System.out.println(students);
        System.out.println("===================");

        System.out.println("======动态查询=====");
        Map<String, String> params = new HashMap<>();
        params.put("qq","2200948129");
        List<Student> studentsByParams = session.selectList("course.findStudentByParams", params);
        System.out.println(studentsByParams);
        System.out.println("===================");

    }
}
