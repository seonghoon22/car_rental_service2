package com.web.dto;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

import lombok.ToString;

@ToString
public class userDTO {
    @NotBlank(message = "아이디를 입력하세요")
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "아이디는 영문자와 숫자만 입력 가능합니다")
    private String id;

    @NotBlank(message = "비밀번호를 입력하세요")
    @Size(min=4, max=10, message = "비밀번호는 최소 4자리부터 최대 10자리입니다.")
    @Pattern(regexp = "[a-zA-Z0-9]+", message = "비밀번호는 영문자와 숫자만 입력 가능합니다")
    private String password;

    @NotBlank(message = "이름을 입력하세요")
    @Pattern(regexp = "[가-힣]+", message = "이름은 한글만 입력 가능합니다")
    private String name;

    @NotNull(message = "나이를 입력하세요")
    @Min(20) @Max(99)
    private int age;

    @NotBlank(message = "주소를 입력하세요")
    private String address;
    
    @NotBlank(message = "전화번호를 입력하세요")
    @Pattern(regexp = "^01([0|1|6|7|8|9])\\d{7,8}$", message = "올바른 전화번호 형식이 아닙니다")
    private String phone;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}