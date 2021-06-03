package kr.vaiv.sdt.kb.service;

import java.util.List;

import kr.vaiv.sdt.kb.domain.KbDto;

public interface KbService {
    List<KbDto> findAll();

    KbDto findById(Long kbId);

    void delete(Long kbId);

    void regist(KbDto dto);

    List<KbDto> findAllByParentKbId(Long parentKbId);

    void updt(KbDto dto);
}
