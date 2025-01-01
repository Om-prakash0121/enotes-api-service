package com.enote.entity;

import java.util.Date;

import jakarta.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter; 

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@MappedSuperclass
public class CommonVar {

    private boolean isActive;
    private boolean isDeleted;
    private int createdBy;
    private Date createdOn=new Date();
    private int updatedBy;
    private Date updatedOn=new Date();

}
