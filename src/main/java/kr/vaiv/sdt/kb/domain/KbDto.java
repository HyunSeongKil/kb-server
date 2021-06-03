package kr.vaiv.sdt.kb.domain;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class KbDto {
    private Long kbId;

    private Long parentKbId;

    private String sj;

    private String cn;

    private String url;

    private Date registDt;

    private String delYn;
}
