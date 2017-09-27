package evolution.dao;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import evolution.entity.AnyEntity;

@Mapper
public interface AnyDao {
	@Insert("insert into any_entity(name, age, gender) values(#{anyEntity.name}, #{anyEntity.age}, #{anyEntity.gender})")
	public void insert(@Param("anyEntity") AnyEntity anyEntity);
	
	@Select("select * from any_entity")
	public List<AnyEntity> findAll();
}
