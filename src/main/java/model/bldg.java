package model;

import java.sql.Date;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;


	@Entity
	public class bldg {
	    @Id
	    @GeneratedValue(strategy=GenerationType.AUTO)
		private long id;
	    @Column(length =255)
	    private String bldg_name;
	    @Column(length =3)
	    private int bldg_floor;
	    @Column(length =3)
	    private String bldg_room_no;
	    @Column(length =5)
	    private int renter_id;
	    @Column(length =255)
	    private String document_taken;
	    @Column(name = "lease_start_date")
	    @DateTimeFormat(pattern = "dd-MM-yyyy")
	    private Date lease_start_date; 
	    
	}
