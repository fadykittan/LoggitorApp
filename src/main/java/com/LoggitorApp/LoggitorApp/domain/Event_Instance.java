package com.LoggitorApp.LoggitorApp.domain;

import java.math.BigInteger;

import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;

@Entity
@SqlResultSetMapping(
		name="ActionLogMapping",
	    classes={
	        @ConstructorResult(
	        		targetClass=ActionLog.class,
	            columns={
	                @ColumnResult(name="ID", type = BigInteger.class),
	                @ColumnResult(name="NAME", type = String.class),
	                @ColumnResult(name="SEVERITY", type = String.class),
	                @ColumnResult(name="DESC", type = String.class),
	                @ColumnResult(name="ACTION", type = String.class)
	            }
	        )
	    }
	)

@NamedNativeQuery(name="Event_Instance.getActionLogTable", query="SELECT OWNER.FIRSTNAME, TRIP.NAME, TRIP.TRIP_ID "
		+ "FROM TRIP INNER JOIN "
		+ "((OWNER INNER JOIN CAR ON OWNER.OWNERID = CAR.OWNER) "
		+ "INNER JOIN CAR_IN_TRIP ON CAR.ID = CAR_IN_TRIP.CAR_ID) "
		+ "ON TRIP.TRIP_ID = CAR_IN_TRIP.TRIP_ID "
		+ "WHERE (((TRIP.TRIP_ID)= :tripId))", resultSetMapping="ActionLogMapping")
public class Event_Instance {

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	long id;
	String date;
	
	@ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event")
	Event event;
	
	//empty constructor
	public Event_Instance() {}



	public Event_Instance(String date, Event event) {
		super();
		this.date = date;
		this.event = event;
	}



	//getters and setters
	public long getId() {
		return id;
	}



	public void setId(long id) {
		this.id = id;
	}



	public String getDate() {
		return date;
	}



	public void setDate(String date) {
		this.date = date;
	}



	public Event getEvent() {
		return event;
	}



	public void setEvent(Event event) {
		this.event = event;
	}
	
	
	
	
	
	
}
