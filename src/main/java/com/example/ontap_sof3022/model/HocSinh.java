package com.example.ontap_sof3022.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "students")
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotBlank(message = "Student code không được để trống")
    @Column(name = "StudentCode")
    private String studentCode;

    @NotBlank(message = "Họ tên không được để trống")
    @Column(name = "FullName")
    private String fullName;

    @NotNull(message = "Vui lòng chọn giới tính")
    @Column(name = "Gender")
    private Boolean gender;

    @Email(message = "Email không đúng định dạng")
    @Column(name = "Email")
    private String email;

    @NotBlank(message = "Số điện thoại không được để trống")
    @Column(name = "Phone")
    private String phone;

    @NotBlank(message = "Ngành học không được để trống")
    @Column(name = "Major")
    private String major;

    @NotBlank(message = "Tên lớp không được để trống")
    @Column(name = "ClassName")
    private String className;
}
