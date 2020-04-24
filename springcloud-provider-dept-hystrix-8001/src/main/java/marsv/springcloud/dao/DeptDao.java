package marsv.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springcloud.pojo.Dept;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface DeptDao {

    public boolean addDept(Dept dept);

    public Dept queryDept(Long deptno);

    public List<Dept> queryAll();
}
