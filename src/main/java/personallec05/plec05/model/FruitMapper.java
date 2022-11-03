package personallec05.plec05.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Delete;

@Mapper
public interface FruitMapper {

  @Select("SELECT ID, NAME,PRICE from FRUIT")
  ArrayList<Fruit> selectAllFruit();

  @Select("SELECT ID, NAME, PRICE from FRUIT WHERE ID = #{id}")
  Fruit selectById(int id);

  @Delete("DELETE FROM FRUIT WHERE ID = #{id}")
  boolean deleteById(int id);
}
