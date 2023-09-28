package com.indium.capstone.Service;


import com.indium.capstone.Dao.Associateinterface;
import com.indium.capstone.Dao.AssosiateServiceDao;
import com.indium.capstone.Dao.SkillDao;
import com.indium.capstone.Dao.SkillDaoImpl;
import com.indium.capstone.Model.Associate;
import com.indium.capstone.Model.Skill;


import java.util.*;
import java.util.stream.Collectors;

public class AssociateSkillTracker implements AssociateSkillsService {

    private List<Associate> associates = new ArrayList<>();
    private List<Skill> skills = new ArrayList<>();
    Associateinterface associateinterface;
    SkillDao skillDao;

    public AssociateSkillTracker(){
           associateinterface = new AssosiateServiceDao();
           skillDao = new SkillDaoImpl();

    }

    public void addAssociate(Associate associate) {
        associateinterface.create(associate);
    }

    public void listAssociates() {
             associates = associateinterface.getall();
            for (Associate associate : associates) {
                associate.viewDetails();
                System.out.println();
        }

    }

    public void editAssociate(int associateId, Associate updatedAssociate) {
        boolean edit =  associateinterface.update(updatedAssociate);
    }


    public void deleteAssociate(int associateId) {
        boolean delete = associateinterface.delete(associateId);
    }

    public void addSkillToAssociate(int associateId, Skill skill) {
            boolean addSkillStatus = skillDao.create(skill);
        }



    public void editSkill(int skillId, Skill updatedSkill) {
        boolean editSkillStatus = skillDao.update(updatedSkill);
    }

    public void deleteSkill(int skillId) {
        boolean deleteSkillStatus = skillDao.delete(skillId);

    }


    public void searchAssociateByName(String name){
        associates = associateinterface.getall();
        List<Associate> associatesByName = associates.stream()
                .filter(associate -> associate.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        for (Associate associate : associatesByName) {
            associate.viewDetails();
        }
    }

    public void searchAssociateByLocation(String location){
        associates = associateinterface.getall();
        associates = associateinterface.getall();
        List<Associate> associatesByLocation = associates.stream()
                .filter(associate -> associate.getLocation().equalsIgnoreCase(location))
                .collect(Collectors.toList());
        for (Associate associate : associatesByLocation) {
            associate.viewDetails();
        }
    }

    public void searchAssociateBySkills(String skillName){
        List<Associate> associatesBySkills =  associates.stream()
                .filter(associate -> associate.getSkills().stream()
                        .anyMatch(skill -> skill.getName().equalsIgnoreCase(skillName)))
                .collect(Collectors.toList());
        for (Associate associate : associatesBySkills) {
            associate.viewDetails();
        }
    }

    public void getTotalAssociates() {
        associates = associateinterface.getall();
        System.out.println("the total associates are : "+associates.size());
    }

    public void getTotalAssociatesWithSkillsGreaterThan(int n) {
        int count = (int) associates.stream()
                .filter(associate -> associate.getSkills().size() > n)
                .count();
        System.out.println("total associates with grater than "+n+" skills are : "+count);
    }

    public void getAssociateIdsWithSkillsGreaterThan(int n) {
        List<Integer> associateIdsWithSkillsGreaterThan = associates.stream()
                .filter(associate -> associate.getSkills().size() > n)
                .map(Associate::getId)
                .collect(Collectors.toList());
        System.out.println("associate id's with skills graterthan "+n+" skills are");
        for (int associate : associateIdsWithSkillsGreaterThan) {
            System.out.println(associate);
        }

    }

    public void getTotalAssociatesWithSkills(String requiredSkills) {
        int totalAssociatesWithSkills =  (int) associates.stream()
                .filter(associate -> associate.getSkills().stream()
                        .anyMatch(skill -> skill.getName().equalsIgnoreCase(requiredSkills)))
                .count();
        System.out.println("total associates with given skill are : "+totalAssociatesWithSkills);
    }


}