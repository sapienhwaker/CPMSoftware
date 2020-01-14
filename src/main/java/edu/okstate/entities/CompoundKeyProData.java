package edu.okstate.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class CompoundKeyProData implements Serializable {
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="Project_ID")
	private ProjectHeaderData proHeaderDataId;
	
	private CompoundKeyTempData compound;
	
	public CompoundKeyProData() {}

	public ProjectHeaderData getProHeaderDataId() {
		return proHeaderDataId;
	}

	public void setProHeaderDataId(ProjectHeaderData proHeaderDataId) {
		this.proHeaderDataId = proHeaderDataId;
	}

	public CompoundKeyTempData getCompound() {
		return compound;
	}

	public void setCompound(CompoundKeyTempData compound) {
		this.compound = compound;
	}

}
