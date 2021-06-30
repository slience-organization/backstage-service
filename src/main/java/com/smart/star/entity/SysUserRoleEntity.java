package com.smart.star.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author：yjw
 * @Date：2021/6/30
 * @Description:
 */
@Entity
@Table(name = "sys_user_role", schema = "mall", catalog = "")
public class SysUserRoleEntity {
    private String id;
    private String userid;
    private String roleid;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "userid")
    public String getUserid() {
        return userid;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    @Basic
    @Column(name = "roleid")
    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUserRoleEntity that = (SysUserRoleEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(userid, that.userid) && Objects.equals(roleid, that.roleid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userid, roleid);
    }
}
