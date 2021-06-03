package kr.vaiv.sdt.kb.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "kb")
@Entity()
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Kb {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long kbId;

    @Column(name = "parent_kb_id")
    private Long parentKbId;

    private String sj;

    private String cn;

    private String url;

    @Column(name = "regist_dt")
    private Date registDt;

    @Column(name = "del_yn")
    private String delYn;
}
