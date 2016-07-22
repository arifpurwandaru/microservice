package com.mitrais.scrummit.dao;

import java.util.List;

import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.mitrais.scrummit.model.MasterMenu;

@Repository
public interface MenuDAO extends IDAO<MasterMenu, String> {

	@Query("{parentId:{$exists:false}}")
	public List<MasterMenu> find1stLvlMenu();
	
	@Query("{children : {$exists:true}, $where:'this.children.length>0'}")
	public List<MasterMenu> findMenusHaveChildren();
}
