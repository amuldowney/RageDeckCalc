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
	
	public List<SkillProcSet> GenerateTable(List<Skill> skills){
		
		List<SkillProcSet> x  = substep(new SkillProcSet(skills.get(0)),skills.size(),2);
		return x;
	}
	//Get skill list
	//Develop Skill list and percentage of happening
	//Start with first proc, skill added to a list
	
	//Method that takes a list of skill and hydras to the two possbilities
	//unless the skill list is at the end OR full
	
	//The hydra is to add to the list of skill lists and chance to happen
	
	private List<SkillProcSet> substep(SkillProcSet skillproc, int maxdepth, int currentdepth){
		if (currentdepth > maxdepth || skillproc.skills.size()  >=3){
			ArrayList<SkillProcSet> x= new ArrayList<SkillProcSet>();
			x.add(skillproc);
			return x;
		}
		else{
			double newSkillProcChance = (skillproc.ChanceToProc * SkillProcConfigurationWizard.PROC_SUCESS_REDUCTION)+(this.skills.get(currentdepth-1).SkillProcChaneBoost());
			int duplicates = this.duplicates(skillproc, this.skills.get(currentdepth-1));
			if(duplicates > 0){newSkillProcChance *= (SkillProcConfigurationWizard.DUPLICATE_PROC_SUCESS_REDUCTION / duplicates);}
			
			SkillProcSet yes = skillproc.Copy();
			yes.skills.add(this.skills.get(currentdepth-1));
			yes.ChanceToProc *= newSkillProcChance/100;
			
			SkillProcSet no = skillproc.Copy();
			no.ChanceToProc *= (100 - newSkillProcChance)/100;
			
			List<SkillProcSet> x =  this.substep(yes, maxdepth, currentdepth+1);
			x.addAll(this.substep(no,maxdepth,currentdepth+1));
			
			return x;
		}
		
		
	}
	
	private int duplicates(SkillProcSet setOfSkills, Skill skill){
		int ret = 0;
		for(Skill already : setOfSkills.skills){
			if(skill.toString() == already.toString()){
				ret++;
			}
		}
		return ret;
	}
	
	

}
