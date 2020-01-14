package edu.okstate.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@SuppressWarnings("serial")
@Embeddable
public class CompoundKeyTempData implements Serializable {
	
	@ManyToOne(cascade= {CascadeType.PERSIST, CascadeType.MERGE,
			 CascadeType.DETACH, CascadeType.REFRESH})
	@JoinColumn(name="Project_Template_ID")
	private TemplateHeaderData tempHeaderDataId;
	
	@Column(name="Project_Template_Row_ID")
	private int rowId;
	
	public CompoundKeyTempData() {}

	/**
	 * @param id
	 * @param rowId
	 */
	public CompoundKeyTempData(int rowId) {
		this.rowId = rowId;
	}

	public TemplateHeaderData getTempHeaderDataId() {
		return tempHeaderDataId;
	}

	public void setTempHeaderDataId(TemplateHeaderData tempHeaderDataId) {
		this.tempHeaderDataId = tempHeaderDataId;
	}

	public int getRowId() {
		return rowId;
	}

	public void setRowId(int rowId) {
		this.rowId = rowId;
	}

	@Override
	public String toString() {
		return "CompoundKeyTempData [rowId=" + rowId + "]";
	}

}
