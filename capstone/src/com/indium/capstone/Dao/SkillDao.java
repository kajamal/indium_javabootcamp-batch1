package com.indium.capstone.Dao;

import com.indium.capstone.Model.Skill;

import java.util.List;

public interface SkillDao {
    public Boolean create(Skill skill);
    public boolean update(Skill skill);
    public boolean delete(int skillID);
}
