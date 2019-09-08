package cn.jacken.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper {
    @Insert("insert into user(name) values(#{name})")
    public  void insert(@Param("name") String name);
}
