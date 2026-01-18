package com.example.ontap_sof3022.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "Students")
@Entity
public class HocSinh {
//    CREATE TABLE dbo.Students (
//    Id          INT IDENTITY(1,1) NOT NULL,
//    StudentCode NVARCHAR(20)  NOT NULL,
//    FullName    NVARCHAR(100) NOT NULL,
//    Gender      NVARCHAR(10)  NOT NULL,
//    Email       NVARCHAR(120) NOT NULL,
//    Phone       NVARCHAR(20)  NULL,
//    Major       NVARCHAR(50)  NOT NULL,
//    ClassName   NVARCHAR(30)  NOT NULL,
//
//    CONSTRAINT PK_Students PRIMARY KEY (Id)
//);
@Id
@GeneratedValue (strategy = GenerationType.IDENTITY)
@Column(name = "Id")
private Integer id;

@Column(name = "StudentCode")
private String studentCode;

@Column(name = "FullName")
private String fullName;

@Column(name = "Gender")
private String gender;

@Column(name = "Email")
private String email;

@Column(name = "Phone")
private String phone;

@Column(name = "Major")
private String major;

@Column(name = "ClassName")
private String className;

}
