package com.wanghaodong.design_pattern.model;

import java.io.Serializable;
import javax.persistence.*;

@Table(name = "age_log")
public class AgeLog implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String age;

    private String memo;

    private static final long serialVersionUID = 1L;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return age
     */
    public String getAge() {
        return age;
    }

    /**
     * @param age
     */
    public void setAge(String age) {
        this.age = age;
    }

    /**
     * @return memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }
}