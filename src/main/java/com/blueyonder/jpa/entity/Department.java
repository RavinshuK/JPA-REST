package com.blueyonder.jpa.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name="department")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Department {
	
	@Id
//	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@JsonProperty
	private int depid;
	@JsonProperty
	private String depname;
	@JsonProperty
	private String deplocation;
	
	@Override
	public String toString() {
		return "Department [depid=" + depid + ", depname=" + depname + ", deplocation=" + deplocation + "]";
	}

	public void setDeplocation(String deplocation2) {
		// TODO Auto-generated method stub
		this.deplocation = deplocation2;
	}
	
	public void setDepname(String depname2)
	{
		this.depname = depname2;
	}
	
	public void setDepid(int depid2) {
		this.depid=depid2;
	}
	
	public String getDepname() {
		return depname;
	}
	
	public String getDeplocation() {
		return deplocation;
	}
	public int getDepid() {
		return depid;
	}
}
