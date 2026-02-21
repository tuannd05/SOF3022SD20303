package com.example.ontap_sof3022.repo;

import com.example.ontap_sof3022.model.HocSinh;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

//Đánh dấu đây là bean tầng repository tác động đến csdl
@Repository
//dung interface khong can class => extends JpaRepository<HocSinh, Integer>
//HocSinh: Entity ma repo quan ly (map toi bang trong csdl la students)
//Integer: Kieu khoa chinh (id)
//ke thua JpaRepository co san toan bo phuong thuc CRUD/Query
public interface HocSinhRepo extends JpaRepository<HocSinh, Integer> {
    @Query(value = """
    SELECT h FROM HocSinh h
    WHERE
        h.studentCode LIKE %:key%
        OR h.fullName LIKE %:key%
        OR h.email LIKE %:key%
        OR h.phone LIKE %:key%
        OR h.major LIKE %:key%
        OR h.className LIKE %:key%
""")
    List<HocSinh> searchAll(@Param("key") String key);
}
