package com.chris.mybatisplus.entities;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Accessors(chain = true)
@TableName("t_user") //在不配置的情况下默认表名与类名一致
public class User {

    public User(String name, int age, Date bir) {
        this.name = name;
        this.age = age;
        this.bir = bir;
    }


    /**
     * AUTO:数据库自增
     * INPUT:inset前自行设置主键值
     * ASSIGN_ID:分配ID，主键类型为Number(Integer和Long)使用接口IdentifierGenerator的nextId方法（默认实现类为DefaultIdentifierGenerator雪花算法）
     * ASSIGN_UUID:分配UUID，主键类型为String,使用接口IdentifierGenerator的nextId方法（默认default方法）
     */
    @TableId(value = "tableId", type = IdType.AUTO)
    private Integer id;

    /**
     * 表中列名与Java类中属性的映射
     * 如果列名和属性名一致可以不用配置此注解
     */

    @TableField("last_name")
    private String name;
    private Integer age;
    private Date bir;

    // 不映射数据表中的任何字段
    @TableField(exist = false)
    private String notColumn;
}
