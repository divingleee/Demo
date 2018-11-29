package com.example.demo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @description:
 * @author: divingLee
 * @date: 2018/11/29 9:55
 */
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
//在 Hibernate 中可以利用 @DynamicInsert 和 @DynamicUpdate 生成动态 SQL 语句，即在插入和修改数据的时候，语句中只包括要插入或者修改的字段。提高 sql 效率。
@DynamicUpdate
@DynamicInsert
//删除执行的代码
@SQLDelete(sql = "UPDATE user SET is_delete = 1 WHERE id = ?")
//查询的时候自动添加查询条件
@Where(clause = "is_delete = 0")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)//主键则由数据库自动维护
    private Long id;

    private String name;
    private Integer age;
    private String company;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private int isDelete;

}
