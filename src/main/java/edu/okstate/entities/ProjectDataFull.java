package edu.okstate.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "project_data_full")
public class ProjectDataFull {

    @Id
    private CompoundKeyProData compound;

    @Column(name = "Template_Activity_Name")
    private String activityName;

    @Column(name = "Template_Activity_Unit")
    private String activityUnit;

    @Column(name = "Template_Activity_Level")
    private int activityLevel;

    @Column(name = "Template_Activity_Child")
    private int activityChild;

    @Column(name = "Template_Activity_Parent")
    private int activityParent;

    @Column(name = "Activity_Quantity")
    private double quantity;

    @Column(name = "Activity_Avg_Prod_Rate")
    private double avgProdRate;

    @Column(name = "Activity_Duration")
    private double duration;

    @Column(name = "Activity_Duration_Override")
    private double durationOverride;

    @Column(name = "Activity_Comments")
    private String comments;

    @Column(name = "Activity_Min_Prod_Rate")
    private double minProdRate;

    @Column(name = "Activity_Max_Prod_Rate")
    private double maxProdRate;

    @Column(name = "Activity_Add_Tech_Details")
    private String techDetails;

    @Column(name = "Activity_Task_Predecessor_Logic")
    private String taskPredecessor;

    public ProjectDataFull() {
    }

    public ProjectDataFull(String activityName, String activityUnit, int activityLevel, int activityChild, int activityParent, double quantity, double avgProdRate, double duration, double durationOverride, String comments, double minProdRate, double maxProdRate, String techDetails, String taskPredecessor) {
        this.activityName = activityName;
        this.activityUnit = activityUnit;
        this.activityLevel = activityLevel;
        this.activityChild = activityChild;
        this.activityParent = activityParent;
        this.quantity = quantity;
        this.avgProdRate = avgProdRate;
        this.duration = duration;
        this.durationOverride = durationOverride;
        this.comments = comments;
        this.minProdRate = minProdRate;
        this.maxProdRate = maxProdRate;
        this.techDetails = techDetails;
        this.taskPredecessor = taskPredecessor;
    }

    public CompoundKeyProData getCompound() {
        return compound;
    }

    public void setCompound(CompoundKeyProData compound) {
        this.compound = compound;
    }

    public double getQuantity() {
        return quantity;
    }

    public void setQuantity(double quantity) {
        this.quantity = quantity;
    }

    public double getAvgProdRate() {
        return avgProdRate;
    }

    public void setAvgProdRate(double avgProdRate) {
        this.avgProdRate = avgProdRate;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getDurationOverride() {
        return durationOverride;
    }

    public void setDurationOverride(double durationOverride) {
        this.durationOverride = durationOverride;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
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

    public String getTechDetails() {
        return techDetails;
    }

    public void setTechDetails(String techDetails) {
        this.techDetails = techDetails;
    }

    public String getTaskPredecessor() {
        return taskPredecessor;
    }

    public void setTaskPredecessor(String taskPredecessor) {
        this.taskPredecessor = taskPredecessor;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public String getActivityUnit() {
        return activityUnit;
    }

    public void setActivityUnit(String activityUnit) {
        this.activityUnit = activityUnit;
    }

    public int getActivityParent() {
        return activityParent;
    }

    public void setActivityParent(int activityParent) {
        this.activityParent = activityParent;
    }

    public int getActivityLevel() {
        return activityLevel;
    }

    public void setActivityLevel(int activityLevel) {
        this.activityLevel = activityLevel;
    }

    public int getActivityChild() {
        return activityChild;
    }

    public void setActivityChild(int activityChild) {
        this.activityChild = activityChild;
    }
    

    @Override
    public String toString() {
        return "ProjectDataFull{" + "activityName=" + activityName + ", activityUnit=" + activityUnit + ", activityLevel=" + activityLevel + ", activityChild=" + activityChild + ", activityParent=" + activityParent + ", quantity=" + quantity + ", avgProdRate=" + avgProdRate + ", duration=" + duration + ", durationOverride=" + durationOverride + ", comments=" + comments + ", minProdRate=" + minProdRate + ", maxProdRate=" + maxProdRate + ", techDetails=" + techDetails + ", taskPredecessor=" + taskPredecessor + '}';
    }
}
