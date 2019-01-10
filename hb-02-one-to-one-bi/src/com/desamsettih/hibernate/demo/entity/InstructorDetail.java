package com.desamsettih.hibernate.demo.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="instructor_detail")
public class InstructorDetail {
	
	//Annotate the class as an entity and map it to a database table
	
	//Define the fields 
	
	
	//Annotate the fields with db column names
	
	//Create constructors
	
	
	//Generate getter/setter methods
	
	//Generate toString() method
	
	
	
	@Column(name="id")
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="youtube_channel")
	private String youtubeChannel;

	@Column(name="hobby")
	private String hobby;
	
	
	public InstructorDetail()
	{
		
	}


	public InstructorDetail(String youtubeChannel, String hobby) {
		this.youtubeChannel = youtubeChannel;
		this.hobby = hobby;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getYoutubeChannel() {
		return youtubeChannel;
	}


	public void setYoutubeChannel(String youtubeChannel) {
		this.youtubeChannel = youtubeChannel;
	}


	public String getHobby() {
		return hobby;
	}


	public void setHobby(String hobby) {
		this.hobby = hobby;
	}


	//Add new field for instructor(also getters and setters)
	
	@OneToOne(mappedBy="instructorDetail",cascade={CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
	private Instructor instructor;
	
	
	@Override
	public String toString() {
		return "InstructorDetail [id=" + id + ", youtubeChannel=" + youtubeChannel + ", hobby=" + hobby + "]";
	}


	public Instructor getInstructor() {
		return instructor;
	}


	public void setInstructor(Instructor instructor) {
		this.instructor = instructor;
	}
	
	
	
	
	
	
	
	
	

}
