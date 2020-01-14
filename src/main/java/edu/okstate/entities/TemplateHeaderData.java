package edu.okstate.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="template_header_data")
public class TemplateHeaderData {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="Project_Template_ID")
	private int id;
	
	@Column(name="Project_Template_Name")
	private String templateName;
	
	@OneToOne(mappedBy="templateId",cascade={CascadeType.PERSIST, CascadeType.DETACH,
			CascadeType.MERGE, CascadeType.REFRESH})
	private ProjectHeaderData projectHeader;
	
	public TemplateHeaderData() {}

	/**
	 * @param templateName
	 */
	public TemplateHeaderData(String templateName) {
		super();
		this.templateName = templateName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	public ProjectHeaderData getProjectHeader() {
		return projectHeader;
	}

	public void setProjectHeader(ProjectHeaderData projectHeader) {
		this.projectHeader = projectHeader;
	}

	@Override
	public String toString() {
		return "TemplateHeaderData [id=" + id + ", templateName=" + templateName + "]";
	}

}
