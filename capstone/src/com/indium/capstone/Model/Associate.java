package com.indium.capstone.Model;
import java.util.*;

public class Associate {
    private int id;
    private String name;
    private int age;
    private String businessUnit;
    private String email;
    private String location;
    private List<Skill> skills = new ArrayList<>();
    private Date createTime;
    private Date updateTime;

    public Associate(int id ,String name, int age, String businessUnit, String email, String location) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.businessUnit = businessUnit;
        this.email = email;
        this.location = location;
        this.createTime = new Date();
        this.updateTime = new Date();
    }

    public void addSkill(Skill skill) {
        skills.add(skill);
    }

    public void editSkill(int skillId, Skill updatedSkill) {
        for (Skill skill : skills) {
            if (skill.getId() == skillId) {
                skill.setName(updatedSkill.getName());
                skill.setDescription(updatedSkill.getDescription());
                skill.setCategory(updatedSkill.getCategory());
                skill.setExperience(updatedSkill.getExperience());
                updateTime = new Date();
                break;
            }
        }
    }

    public void deleteSkill(int skillId) {
        skills.removeIf(skill -> skill.getId() == skillId);
        updateTime = new Date();
    }

    public void viewDetails() {
        System.out.println("Associate ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Business Unit: " + businessUnit);
        System.out.println("Email: " + email);
        System.out.println("Location: " + location);
        System.out.println("Created on:" + getCreateTime());
        System.out.println("Skills: ");
        for (Skill skill : skills) {
            System.out.println("  Skill ID: " + skill.getId() + ", Name: " + skill.getName());
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public String getBusinessUnit() {
        return businessUnit;
    }

    public void setBusinessUnit(String businessUnit) {
        this.businessUnit = businessUnit;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public List<Skill> getSkills() {
        return skills;
    }

    public void setSkills(List<Skill> skills) {
        this.skills = skills;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
}