package org.springcloud.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/*
 * 链式写法
 *
 * Dept dept = new Dept()
 * dept.setDeptno(xx).setDeptName(xx).setDb_source(xx);
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true) //开启链式写法
public class Dept implements Serializable {

    private Long deptno;

    private String deptName;

    private String db_source;

    public Dept(String deptName) {
        this.deptName = deptName;
    }


}
