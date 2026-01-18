package com.example.ontap_sof3022.repo;

import com.example.ontap_sof3022.model.HocSinh;
import org.hibernate.boot.models.JpaAnnotations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HocSinhRepo extends JpaRepository<HocSinh, Integer> {

}
