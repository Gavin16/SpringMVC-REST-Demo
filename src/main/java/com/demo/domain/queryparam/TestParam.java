package com.demo.domain.queryparam;

import com.demo.domain.UserDTO;

import java.util.List;

/**
 * @Auther: Minsky
 * @Date: 2019/1/5 21:00
 * @Description:
 */
public class TestParam {

    private String name;

    private Integer age;

    private List<String> addrList;

    private UserDTO userDTO;

    private String testRef;

    public String getTestRef() {
        return testRef;
    }

    public void setTestRef(String testRef) {
        this.testRef = testRef;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getAddrList() {
        return addrList;
    }

    public void setAddrList(List<String> addrList) {
        this.addrList = addrList;
    }

    public UserDTO getUserDTO() {
        return userDTO;
    }

    public void setUserDTO(UserDTO userDTO) {
        this.userDTO = userDTO;
    }

    @Override
    public String toString() {
        return "TestParam{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", addrList=" + addrList +
                ", userDTO=" + userDTO +
                ", testRef='" + testRef + '\'' +
                '}';
    }
}
