import com.indium.capstone.Model.Associate;
import com.indium.capstone.Model.Skill;
import com.indium.capstone.Service.AssociateSkillTracker;


import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AssociateSkillTracker Tracker = new AssociateSkillTracker();

        Scanner scanner = new Scanner(System.in);
        int skillId =1;

        while (true) {
            System.out.println("Skill Tracker App Menu:");
            System.out.println("1. Add Associate");
            System.out.println("2. List Associates");
            System.out.println("3. Edit Associate");
            System.out.println("4. Delete Associate");
            System.out.println("5. Add Skill to Associate");
            System.out.println("6. Edit Skill");
            System.out.println("7. Delete Skill");
            System.out.println("8. View Associate Details");
            System.out.println("9. Search associates");
            System.out.println("10.show key metrics");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the Associate ID");
                    int id = scanner.nextInt();
                    System.out.print("Enter Associate Name: ");
                    String name = scanner.next();
                    System.out.print("Enter Associate Age: ");
                    int age = scanner.nextInt();
                    System.out.print("Enter Business Unit: ");
                    String businessUnit = scanner.next();
                    System.out.print("Enter Email: ");
                    String email = scanner.next();
                    System.out.print("Enter Location: ");
                    String location = scanner.next();
                    Associate newAssociate = new Associate(id,name, age, businessUnit, email, location);
                    Tracker.addAssociate(newAssociate);
                    System.out.println("Associate added!");
                    System.out.println("Created on: " + newAssociate.getCreateTime());
                    break;
                case 2:
                    System.out.println("List of Associates:");
                    Tracker.listAssociates();
                    break;
                case 3:
                    System.out.print("Enter Associate ID to Edit: ");
                    int editAssociateId = scanner.nextInt();
                    System.out.print("Enter Associate Name: ");
                    name = scanner.next();
                    System.out.print("Enter Associate Age: ");
                    age = scanner.nextInt();
                    System.out.print("Enter Business Unit: ");
                    businessUnit = scanner.next();
                    System.out.print("Enter Email: ");
                    email = scanner.next();
                    System.out.print("Enter Location: ");
                    location = scanner.next();
                    Associate updatedAssociate = new Associate(editAssociateId,name, age, businessUnit, email, location);
                    Tracker.editAssociate(editAssociateId, updatedAssociate);
                    System.out.println("Associate edited successfully!");
                    System.out.println("updated on:" + updatedAssociate.getUpdateTime());
                    break;
                case 4:
                    System.out.print("Enter Associate ID to Delete: ");
                    int deleteAssociateId = scanner.nextInt();
                    Tracker.deleteAssociate(deleteAssociateId);
                    System.out.println("Associate deleted successfully!");
                    break;
                case 5:
                    System.out.print("Enter Associate ID to Add Skill: ");
                    int addSkillAssociateId = scanner.nextInt();
                    System.out.print("Enter Skill Name: ");
                    String skillName = scanner.next();
                    System.out.print("Enter Skill Description: ");
                    String skillDescription = scanner.next();
                    System.out.print("Enter Skill Category (Primary/Secondary): ");
                    String skillCategory = scanner.next();
                    System.out.print("Enter Skill Experience (months): ");
                    int skillExperience = scanner.nextInt();
                    Skill newSkill = new Skill(skillId,skillName, skillDescription, skillCategory, skillExperience);
                    Tracker.addSkillToAssociate(addSkillAssociateId, newSkill);
                    System.out.println("Skill added to associate successfully!");
                    skillId++;
                    break;
                case 6:
                    System.out.print("Enter Skill ID to Edit: ");
                    int editSkillId = scanner.nextInt();
                    System.out.print("Enter Skill Name: ");
                    skillName = scanner.next();
                    System.out.print("Enter Skill Description: ");
                    skillDescription = scanner.next();
                    System.out.print("Enter Skill Category (Primary/Secondary): ");
                    skillCategory = scanner.next();
                    System.out.print("Enter Skill Experience (months): ");
                    skillExperience = scanner.nextInt();
                    Skill updatedSkill = new Skill(skillId,skillName, skillDescription, skillCategory, skillExperience);
                    Tracker.editSkill(editSkillId, updatedSkill);
                    skillId++;
                    System.out.println("Skill edited successfully!");
                    break;
                case 7:
                    System.out.print("Enter Skill ID to Delete: ");
                    int deleteSkillId = scanner.nextInt();
                    Tracker.deleteSkill(deleteSkillId);
                    System.out.println("Skill deleted successfully!");
                    break;
                case 8:
                    System.out.print("Enter Associate ID to View Details: ");
                    int viewAssociateId = scanner.nextInt();
                    Tracker.viewAssociate(viewAssociateId);
                    break;
                case 9:{
                    System.out.println("1.search associate by associate name");
                    System.out.println("2.search associate by associate id");
                    System.out.println("3.search associate by location");
                    System.out.println("4.search associate by skills");
                    int searchChoice = scanner.nextInt();
                    switch (searchChoice){
                        case 1 :{
                            System.out.println("enter associate name");
                            name = scanner.next();
                            Tracker.searchAssociateByName(name);
                            break;
                        }
                        case 2:{
                            System.out.println("enter associate id");
                            viewAssociateId = scanner.nextInt();
                            Tracker.viewAssociate(viewAssociateId);
                            break;
                        }
                        case 3 :{
                            System.out.println("enter location");
                            location = scanner.next();
                            Tracker.searchAssociateByLocation(location);
                            break;
                        }
                        case 4:{
                            System.out.println("enter skill name");
                            skillName = scanner.next();
                            Tracker.searchAssociateBySkills(skillName);
                            break;
                        }
                        default :
                            System.out.println("exiting due to invalid option");
                            break;
                    }
                    break;
                }
                case 10:{
                    System.out.println("1.To find associates account");
                    System.out.println("2.To find associates count with grater than n skills");
                    System.out.println("3.To find associate id's with grater than n skills");
                    System.out.println("4.To find associates with particular skill");
                    choice  = scanner.nextInt();
                    switch (choice){
                        case 1:{
                            Tracker.getTotalAssociates();
                            break;
                        }
                        case 2:{
                            System.out.println("enter count of n : ");
                            int count = scanner.nextInt();
                            Tracker.getTotalAssociatesWithSkillsGreaterThan(count);
                            break;
                        }
                        case 3:{
                            System.out.println("enter count of n : ");
                            int count = scanner.nextInt();
                            Tracker.getAssociateIdsWithSkillsGreaterThan(count);
                            break;
                        }
                        case 4:{
                            System.out.println("enter the skill to search");
                            String skill = scanner.next();
                            Tracker.getTotalAssociatesWithSkills(skill);
                            break;
                        }
                        default:{
                            System.out.println("exiting due to wrong option");
                            break;
                        }
                    }
                    break;

                }
                case 0:
                    System.out.println("Exiting Skill Tracker App.");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}