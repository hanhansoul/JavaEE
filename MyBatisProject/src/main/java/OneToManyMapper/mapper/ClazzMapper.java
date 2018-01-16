package OneToManyMapper.mapper;


import OneToManyMapper.po.Clazz;

public interface ClazzMapper {

	// 根据id查询班级信息
	Clazz selectClazzById(Integer id);
	
}
