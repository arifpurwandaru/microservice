package com.mitrais.scrummit.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;

@SuppressWarnings("serial")
@Document(collection = "master_menu")
public class MasterMenu extends Common implements Serializable {

    @Id
    @JsonSerialize(using = ToStringSerializer.class)
    private ObjectId id;

    @Field(value = "menuname")
    private String   menuname;

    @Field(value="cssclass")
    private String cssclass;
    
    @Field(value="href")
    private String href;
    
    @Field(value="parentId")
    private String parentId;
    
    @DBRef
    @Field(value="children")
    private List<MasterMenu> children = new ArrayList<MasterMenu>();

	public ObjectId getId() {
		return id;
	}

	public void setId(ObjectId id) {
		this.id = id;
	}

	public String getMenuname() {
		return menuname;
	}

	public void setMenuname(String menuname) {
		this.menuname = menuname;
	}
	public List<MasterMenu> getChildren() {
		return children;
	}

	public void setChildren(List<MasterMenu> children) {
		this.children = children;
	}

	public String getCssclass() {
		return cssclass;
	}

	public void setCssclass(String cssclass) {
		this.cssclass = cssclass;
	}

	public String getHref() {
		return href;
	}

	public void setHref(String href) {
		this.href = href;
	}

	public String getParentId() {
		return parentId;
	}

	public void setParentId(String parentId) {
		this.parentId = parentId;
	}

    
}
