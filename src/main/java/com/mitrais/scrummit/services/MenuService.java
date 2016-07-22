package com.mitrais.scrummit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.BasicQuery;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mitrais.scrummit.dao.MenuDAO;
import com.mitrais.scrummit.model.MasterMenu;

@RestController
public class MenuService {

	@Autowired
	MenuDAO menuDAO;
	
	@Autowired
	MongoTemplate mongoTemplate;

    @RequestMapping(value="/firstLevelMenu", method=RequestMethod.GET)
    public @ResponseBody List<MasterMenu> firstLevelMenu(){
    	return menuDAO.find1stLvlMenu();
    }
    
    @RequestMapping(value="/listMenusHaveChildren", method=RequestMethod.GET)
    public @ResponseBody List<MasterMenu> justRetrieveMenu(){
    	/*Query q = new BasicQuery("{children : {$exists:true}, $where:'this.children.length>0'}");
    	return mongoTemplate.find(q, MasterMenu.class);*/
    	return menuDAO.findMenusHaveChildren();
    }
    
    @RequestMapping(value="/MasterMenu/byId/{id}", method=RequestMethod.GET)
    public @ResponseBody MasterMenu getById(@PathVariable String id){
    	return menuDAO.findOne(id);
    }
    

    
    

    @RequestMapping(path = "/MasterMenu/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public MasterMenu insert(@RequestBody MasterMenu menu){
        return menuDAO.insert(menu);
    }

}
