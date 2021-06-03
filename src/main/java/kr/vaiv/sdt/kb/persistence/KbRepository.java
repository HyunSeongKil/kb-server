package kr.vaiv.sdt.kb.persistence;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kr.vaiv.sdt.kb.entity.Kb;

public interface KbRepository extends JpaRepository<Kb, Long> {

    List<Kb> findAllByParentKbId(Long parentKbId);

    List<Kb> findAllByKbId(Long parentKbId);

}