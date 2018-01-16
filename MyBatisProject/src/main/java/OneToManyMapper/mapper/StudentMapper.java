package OneToManyMapper.mapper;


import OneToManyMapper.po.Student;

public interface StudentMapper {

	// 根据id查询学生信息
	Student selectStudentById(Integer id);
	
}
