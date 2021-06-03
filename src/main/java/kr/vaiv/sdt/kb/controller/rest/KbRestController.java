package kr.vaiv.sdt.kb.controller.rest;

import java.util.List;
import java.util.Optional;

import javax.websocket.server.PathParam;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kr.vaiv.sdt.kb.domain.KbDto;
import kr.vaiv.sdt.kb.service.KbService;

@RestController
@RequestMapping("/kbs")
public class KbRestController {

    private KbService service;

    KbRestController(KbService service) {
        this.service = service;
    }

    // @CrossOrigin("*")
    // @GetMapping()
    // public ResponseEntity<List<KbDto>> list() {
    // return ResponseEntity.ok(service.findAll());
    // }

    @CrossOrigin("*")
    @GetMapping()
    public ResponseEntity<List<KbDto>> listByParentKbId(@RequestParam(required = false) Long parentKbId) {
        if (null == parentKbId) {
            return ResponseEntity.ok(service.findAll());
        }

        return ResponseEntity.ok(service.findAllByParentKbId(parentKbId));
    }

    @CrossOrigin("*")
    @GetMapping("/{kbId}")
    public ResponseEntity<KbDto> detail(@PathVariable("kbId") Long kbId) {
        return ResponseEntity.ok(service.findById(kbId));
    }

    @CrossOrigin("*")
    @DeleteMapping("/{kbId}")
    public ResponseEntity<KbDto> delete(@PathVariable("kbId") Long kbId) {
        service.delete(kbId);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin("*")
    @PostMapping()
    public ResponseEntity<KbDto> regist(@RequestBody KbDto dto) {
        service.regist(dto);
        return ResponseEntity.ok().build();
    }

    @CrossOrigin("*")
    @PutMapping()
    public ResponseEntity<KbDto> updt(@RequestBody KbDto dto) {
        service.updt(dto);
        return ResponseEntity.ok().build();
    }
}
