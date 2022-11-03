package personallec05.plec05.model;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface FruitMapper {

  @Select("SELECT ID, NAME,PRICE from FRUIT")
  ArrayList<Fruit> selectAllFruit();
}
