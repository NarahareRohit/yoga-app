package com.app.entities;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "batch")
@Getter
@Setter
@ToString
public class BatchEntity extends BaseEntity {
	
    @Enumerated(EnumType.STRING)
    @Column (unique = true)
    private BatchEnum batchName;
   
	public BatchEntity(BatchEnum batchName) {
		super();
		this.batchName = batchName;
	}

	public BatchEntity() {
		super();
	}

	public BatchEnum getBatchName() {
		return batchName;
	}

	public void setBatchName(BatchEnum batchName) {
		this.batchName = batchName;
	}
	


}
