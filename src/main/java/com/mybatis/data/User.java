package com.mybatis.data;

/**
 * Created by xionggp on 17/4/1.
 */
public class User {

    private long id;

    private String username;

    private String password;

    private String cardId;

    private String gender;

    private String education;

    private String address;

    private int skillId;

    private int status;

    public User() {

    }

    public User(long id, String username, String password, String cardId, String gender, String education,
                String address, int skillId, int status) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.cardId = cardId;
        this.gender = gender;
        this.education = education;
        this.address = address;
        this.skillId = skillId;
        this.status = status;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSkillId() {
        return skillId;
    }

    public void setSkillId(int skillId) {
        this.skillId = skillId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
