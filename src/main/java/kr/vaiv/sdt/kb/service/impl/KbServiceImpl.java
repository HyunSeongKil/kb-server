package kr.vaiv.sdt.kb.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import kr.vaiv.sdt.kb.domain.KbDto;
import kr.vaiv.sdt.kb.entity.Kb;
import kr.vaiv.sdt.kb.persistence.KbRepository;
import kr.vaiv.sdt.kb.service.KbService;

@Service
public class KbServiceImpl implements KbService {

    private KbRepository repo;

    KbServiceImpl(KbRepository repo) {
        this.repo = repo;
    }

    @Override
    public List<KbDto> findAll() {
        List<Kb> kbs = repo.findAll();

        List<KbDto> dtos = new ArrayList<>();

        kbs.forEach(entity -> {
            dtos.add(toDto(entity));
        });

        return dtos;
    }

    @Override
    public KbDto findById(Long kbId) {
        Optional<Kb> opt = repo.findById(kbId);

        if (opt.isPresent()) {
            Kb entity = opt.get();

            return toDto(entity);
        }

        return null;

    }

    KbDto toDto(Kb entity) {
        return KbDto.builder().kbId(entity.getKbId()).parentKbId(entity.getParentKbId()).sj(entity.getSj())
                .cn(entity.getCn()).url(entity.getUrl()).registDt(entity.getRegistDt()).delYn(entity.getDelYn())
                .build();
    }

    @Override
    public void delete(Long kbId) {
        Optional<Kb> opt = repo.findById(kbId);
        if (opt.isEmpty()) {
            return;
        }

        Kb entity = opt.get();
        Kb entity2 = Kb.builder().cn(entity.getCn()).delYn("Y").kbId(entity.getKbId())
                .parentKbId(entity.getParentKbId()).registDt(entity.getRegistDt()).sj(entity.getSj())
                .url(entity.getUrl()).build();

        repo.saveAndFlush(entity2);
    }

    @Override
    public void regist(KbDto dto) {
        Kb entity = Kb.builder().cn(dto.getCn()).parentKbId(dto.getParentKbId()).registDt(new Date()).sj(dto.getSj())
                .url(dto.getUrl()).delYn("N").build();

        repo.save(entity);
    }

    @Override
    public List<KbDto> findAllByParentKbId(Long parentKbId) {
        List<Kb> kbs = repo.findAllByParentKbId(parentKbId);

        List<KbDto> dtos = new ArrayList<>();

        kbs.forEach(entity -> {
            dtos.add(toDto(entity));
        });

        return dtos;
    }

    @Override
    public void updt(KbDto dto) {
        Optional<Kb> opt = repo.findById(dto.getKbId());
        if (opt.isEmpty()) {
            return;
        }

        Kb entity = opt.get();

        Kb newEntity = Kb.builder().cn(dto.getCn()).kbId(entity.getKbId()).parentKbId(entity.getParentKbId())
                .registDt(entity.getRegistDt()).sj(dto.getSj()).url(dto.getUrl()).delYn(entity.getDelYn()).build();

        repo.save(newEntity);

    }

}
