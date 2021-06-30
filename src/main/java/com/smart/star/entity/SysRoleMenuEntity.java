package com.smart.star.entity;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author：yjw
 * @Date：2021/6/30
 * @Description:
 */
@Entity
@Table(name = "sys_role_menu", schema = "mall", catalog = "")
public class SysRoleMenuEntity {
    private String id;
    private String roleid;
    private String menuid;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "roleid")
    public String getRoleid() {
        return roleid;
    }

    public void setRoleid(String roleid) {
        this.roleid = roleid;
    }

    @Basic
    @Column(name = "menuid")
    public String getMenuid() {
        return menuid;
    }

    public void setMenuid(String menuid) {
        this.menuid = menuid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysRoleMenuEntity that = (SysRoleMenuEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(roleid, that.roleid) && Objects.equals(menuid, that.menuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleid, menuid);
    }
}
