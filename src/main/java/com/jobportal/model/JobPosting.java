package com.jobportal.model;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Job_Posting")
public class JobPosting {
	@Id
	@Column(name = "posting_id")
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int postingId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "poster_id")
	private User posterId;
	
	//TO IMPORT TAGS
	//@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	//private List<Tags> tags;
	
	@Column (name = "date", nullable = false)
	private Timestamp date;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column (name = "description", nullable = false)
	private String description;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "location_id")
	private Location locationId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "industry_id")
	private Industry industryId;
	
	@ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
	@JoinColumn(name = "company_id")
	private Company companyId;
	
	@OneToMany(mappedBy="postingId", fetch=FetchType.LAZY)
	private List<Application> applicationList = new ArrayList<>();
	
	@ManyToMany(cascade=CascadeType.ALL, fetch=FetchType.LAZY)
	private List<Tag> tagsList = new ArrayList<>();


//	@Override
//	public boolean equals(Object obj) {
//		if (this == obj)
//			return true;
//		if (obj == null)
//			return false;
//		if (getClass() != obj.getClass())
//			return false;
//		JobPosting other = (JobPosting) obj;
//		if (company != other.company)
//			return false;
//		if (date == null) {
//			if (other.date != null)
//				return false;
//		} else if (!date.equals(other.date))
//			return false;
//		if (description == null) {
//			if (other.description != null)
//				return false;
//		} else if (!description.equals(other.description))
//			return false;
//		if (industry != other.industry)
//			return false;
//		if (location != other.location)
//			return false;
//		if (posterId != other.posterId)
//			return false;
//		if (postingId != other.postingId)
//			return false;
//		if (title == null) {
//			if (other.title != null)
//				return false;
//		} else if (!title.equals(other.title))
//			return false;
//		return true;
//	}
}