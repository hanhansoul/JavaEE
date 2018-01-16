package OneToManyMapper;

import OneToManyMapper.mapper.ClazzMapper;
import OneToManyMapper.mapper.StudentMapper;
import OneToManyMapper.po.Clazz;
import OneToManyMapper.po.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * Created by Administrator on 2018/1/10 0010.
 */
public class ClazzMapperTest {
    SqlSessionFactory sqlSessionFactory = null;
    SqlSession session = null;

    @Before
    public void initialization() throws IOException {
        InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void selectClazzByIdTest() {
        session = sqlSessionFactory.openSession();
        ClazzMapper cm = session.getMapper(ClazzMapper.class);
        // 调用selectClazzById方法
        Clazz clazz = cm.selectClazzById(1);
        // 查看查询到的clazz对象信息
        System.out.println(clazz.getId() + " "+ clazz.getCode() + " "+clazz.getName());
        // 查看clazz对象关联的学生信息
        List<Student> students = clazz.getStudentList();
        for(Student stu : students) System.out.println(stu);
    }

    @Test
    public void selectStudentByIdTest() {
        session = sqlSessionFactory.openSession();
        StudentMapper cm = session.getMapper(StudentMapper.class);
        // 调用selectClazzById方法
        Student student = cm.selectStudentById(1);
        // 查看clazz对象关联的学生信息
        System.out.println(student);
    }

    @After
    public void destroy() {
        session.commit();
        session.close();
    }
}