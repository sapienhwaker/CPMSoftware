package edu.okstate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="template_all")
public class TemplateData {
	
	@Id
	private CompoundKeyTempData compound;
	
	@Column(name="Template_Activity_Name")
	private String actName;
	
	@Column(name="Template_Activity_Unit")
	private String unit;
	
	@Column(name="Template_Activity_Level")
	private int level;
	
	@Column(name="Template_Activity_Child")
	private int child;
	
	@Column(name="Template_Activity_Parent")
	private int parent;
	
	@Column(name="Activity_Avg_Prod_Rate")
	private double avgProdRate;
	
	@Column(name="Activity_Min_Prod_Rate")
	private double minProdRate;
	
	@Column(name="Activity_Max_Prod_Rate")
	private double maxProdRate;
	
	@Column(name="Activity_Task_Predecessor_Logic")
	private String predecessorLogic;

	public TemplateData() {}
	
	/**
	 * @param rowId
	 * @param actName
	 * @param unit
	 * @param level
	 * @param child
	 * @param parent
	 * @param avgProdRate
	 * @param minProdRate
	 * @param maxProdRate
	 * @param predecessorLogic
	 */
	public TemplateData(String actName, String unit, int level, int child, int parent, double avgProdRate,
			double minProdRate, double maxProdRate, String predecessorLogic) {
		this.actName = actName;
		this.unit = unit;
		this.level = level;
		this.child = child;
		this.parent = parent;
		this.avgProdRate = avgProdRate;
		this.minProdRate = minProdRate;
		this.maxProdRate = maxProdRate;
		this.predecessorLogic = predecessorLogic;
	}

	public CompoundKeyTempData getCompound() {
		return compound;
	}

	public void setCompound(CompoundKeyTempData compound) {
		this.compound = compound;
	}

	public String getActName() {
		return actName;
	}

	public void setActName(String actName) {
		this.actName = actName;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getChild() {
		return child;
	}

	public void setChild(int child) {
		this.child = child;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public double getAvgProdRate() {
		return avgProdRate;
	}

	public void setAvgProdRate(double avgProdRate) {
		this.avgProdRate = avgProdRate;
	}

	public double getMinProdRate() {
		return minProdRate;
	}

	public void setMinProdRate(double minProdRate) {
		this.minProdRate = minProdRate;
	}

	public double getMaxProdRate() {
		return maxProdRate;
	}

	public void setMaxProdRate(double maxProdRate) {
		this.maxProdRate = maxProdRate;
	}

	public String getPredecessorLogic() {
		return predecessorLogic;
	}

	public void setPredecessorLogic(String predecessorLogic) {
		this.predecessorLogic = predecessorLogic;
	}

	@Override
	public String toString() {
		return "TemplateData [actName=" + actName + ", unit=" + unit + ", level=" + level
				+ ", child=" + child + ", parent=" + parent + ", avgProdRate=" + avgProdRate + ", minProdRate="
				+ minProdRate + ", maxProdRate=" + maxProdRate + ", predecessorLogic=" + predecessorLogic + "]";
	}

}
