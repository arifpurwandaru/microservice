package hello;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mitrais.scrummit.dao.UserDAO;
import com.mitrais.scrummit.model.User;

import hello.model.Athing;

@RestController
public class HelloController {
	
	@Autowired
	UserDAO userDao;

    @RequestMapping("/")
    public String index() {
        return "Test Plain String";
    }

    @RequestMapping("/cobaRequestHeader")
    public String cobaRequestHeader(@RequestHeader("headerku") String headerku) {
        return "Request Headermu: "+headerku;
    }
    
    @RequestMapping(value="/justTest", method=RequestMethod.GET)
    public @ResponseBody Athing justReturnObj(){
    	return new Athing("iniIdne", "Test Name");
    }
    
    @RequestMapping(value="/listUser", method=RequestMethod.GET)
    public @ResponseBody List<User> justRetrieveUser(){
    	return userDao.findAll();
    }
    
    @RequestMapping(value="/tesOneUser", method=RequestMethod.GET)
    public @ResponseBody User findByEmail(){
    	return userDao.findByEmail("ArifNazar.Purwandaru@mitrais.com");
    }
    @RequestMapping(value="/findByUsername", method=RequestMethod.GET)
    public @ResponseBody User findByUsername(@RequestHeader("username") String username){
    	return userDao.findByUsername(username);
    }
}