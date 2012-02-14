package com.abner.model;

import java.util.LinkedHashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Role extends BaseEntity {
	private static final long serialVersionUID = 1173999578373208363L;

	private Set<UserEntity> users = new LinkedHashSet<UserEntity>();
	private String name;

	public Role(String name) {
		this.setName(name);
	}

	@Column(length = 20, nullable = false, name = "name")
	@Id
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(joinColumns = @JoinColumn(referencedColumnName = "name",name="name"), inverseJoinColumns = { @JoinColumn(referencedColumnName = "id",name="user_id") })
	public Set<UserEntity> getUsers() {
		return users;
	}

	public void setUsers(Set<UserEntity> users) {
		this.users = users;
	}
}
