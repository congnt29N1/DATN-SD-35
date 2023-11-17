package com.example.datn.Repository;

import com.example.datn.Entity.Veao;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface VeAoRepository extends JpaRepository<Veao,Integer> {
    @Query("UPDATE Veao va SET va.enabled = ?2 WHERE va.idVeao = ?1")
    @Modifying
    void updateEnabledStatus(Integer id, boolean enabled);

    @Query("SELECT va FROM Veao va WHERE UPPER(CONCAT(va.idVeao, ' ', va.tenVeao, ' ', va.moTaVeao)) LIKE %?1%")
    public Page<Veao> findAll(String keyword, Pageable pageable);

    public Veao findByTenVeao(String ten);
}
