package edu.okstate.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="project_header_data")
public class ProjectHeaderData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Project_ID")
	private int id;
	
	@OneToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH})
	@JoinColumn(name="Project_Template_ID")
	private TemplateHeaderData templateId;
	
	@Column(name="Project_Description")
	private String description;
	
	@Column(name="Project_County")
	private String county;
	
	@Column(name="Project_Project_Number")
	private String projNum;
	
	@Column(name="Project_Highway_Number")
	private String hgNum;
	
	@Column(name="Project_Engineer")
	private String Engineer;
	
	@Column(name="Project_Letting_Date")
	private String date;	// not sure about the DATE data type need to check
	
	@Column(name="Project_Reference_Marks")
	private String ref;
	
	@Column(name="Project_Sta_to_Sta")
	private String sta;
	
	@Column(name="Project_Job_Number")
	private String jobNum;
	
	@Column(name="Project_Is_Template")
	private byte isTemp;
	
	@OneToMany(targetEntity=ProjectDataFull.class,mappedBy="compound.proHeaderDataId",cascade = {CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH})
	private List<ProjectDataFull> proDataList;
	
	public ProjectHeaderData() {}

	/**
	 * @param description
	 * @param county
	 * @param projNum
	 * @param hgNum
	 * @param engineer
	 * @param date
	 * @param ref
	 * @param sta
	 * @param jobNum
	 */
	public ProjectHeaderData(String description, String county, String projNum, String hgNum, String engineer,
			String date, String ref, String sta, String jobNum, byte isTemp) {
		super();
		this.description = description;
		this.county = county;
		this.projNum = projNum;
		this.hgNum = hgNum;
		Engineer = engineer;
		this.date = date;
		this.ref = ref;
		this.sta = sta;
		this.jobNum = jobNum;
		this.isTemp = isTemp;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getCounty() {
		return county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getProjNum() {
		return projNum;
	}

	public void setProjNum(String projNum) {
		this.projNum = projNum;
	}

	public String getHgNum() {
		return hgNum;
	}

	public void setHgNum(String hgNum) {
		this.hgNum = hgNum;
	}

	public String getEngineer() {
		return Engineer;
	}

	public void setEngineer(String engineer) {
		Engineer = engineer;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getSta() {
		return sta;
	}

	public void setSta(String sta) {
		this.sta = sta;
	}

	public String getJobNum() {
		return jobNum;
	}

	public void setJobNum(String jobNum) {
		this.jobNum = jobNum;
	}

	public byte getIsTemp() {
		return isTemp;
	}

	public void setIsTemp(byte isTemp) {
		this.isTemp = isTemp;
	}
	
	public List<ProjectDataFull> getProDataList() {
		return proDataList;
	}

	public void setProDataList(List<ProjectDataFull> proDataList) {
		this.proDataList = proDataList;
	}

	public TemplateHeaderData getTemplateId() {
		return templateId;
	}

	public void setTemplateId(TemplateHeaderData templateId) {
		this.templateId = templateId;
	}

	@Override
	public String toString() {
		return "ProjectHeaderData [id=" + id + ", description=" + description + ", county="
				+ county + ", projNum=" + projNum + ", hgNum=" + hgNum + ", Engineer=" + Engineer + ", date=" + date
				+ ", ref=" + ref + ", sta=" + sta + ", jobNum=" + jobNum + ", isTemp=" + isTemp + "]";
	}

}
