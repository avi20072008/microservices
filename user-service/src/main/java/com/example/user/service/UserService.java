package com.example.user.service;

import com.example.user.VO.Department;
import com.example.user.VO.ResponseTemplateVO;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.xml.ws.Response;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUser(User user){
        return userRepository.save(user);
    }

    public User findUserById(Long id){
        return userRepository.findById(id).orElseThrow(()->new NoSuchElementException("There is no user with id"));
    }

    public ResponseTemplateVO getUserWithDepartment(Long id) {
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User userObject = userRepository.findById(id).orElseThrow(()->new NoSuchElementException("There is no user with id"));

        //We have collected user information, we need its related Department. use RestTempalte -
        Long deptId = userObject.getDeptId();
        Department dept = null;

        if(deptId !=null){
            dept = restTemplate.getForObject("http://DEPARTMENT-SERVICE/depts/" + deptId, Department.class);
        }

        responseTemplateVO.setUser(userObject);
        responseTemplateVO.setDepartment(dept);

        return responseTemplateVO;
    }

    public List<User> findAllUsers() {
       return userRepository.findAll();
    }
}
