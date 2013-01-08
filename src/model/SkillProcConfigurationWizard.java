package model;

import java.util.ArrayList;
import java.util.List;

public class SkillProcConfigurationWizard {
	
	private static double PROC_SUCESS_REDUCTION = 0.5;//skill procs drop by half when another proc has occured
	private static double DUPLICATE_PROC_SUCESS_REDUCTION = 0.5;//skill procs drop by half when a duplicate proc has occured
	
	
	private List<Skill> skills;
	
	
	public SkillProcConfigurationWizard(List<Skill> skills){
		this.skills = skills;
	}
	
	private void GenerateTable(List<Skill> skills){
		
		List<SkillProcSet> x  = substep(new SkillProcSet(skills.get(0)),skills.size(),1);
		
	}
	//Get skill list
	//Develop Skill list and percentage of happening
	//Start with first proc, skill added to a list
	
	//Method that takes a list of skill and hydras to the two possbilities
	//unless the skill list is at the end OR full
	
	//The hydra is to add to the list of skill lists and chance to happen
	
	private List<SkillProcSet> substep(SkillProcSet skillproc, int maxdepth, int currentdepth){
		if (currentdepth == maxdepth || skillproc.skills.size()  >=3){
			ArrayList<SkillProcSet> x= new ArrayList<SkillProcSet>();
			x.add(skillproc);
			return x;
		}
		else{
			double newSkillProcChance = (skillproc.ChanceToProc +(this.skills.get(currentdepth).SkillProcChaneBoost()))* this.PROC_SUCESS_REDUCTION;
			
		}
		
		
	}
	
	

}
