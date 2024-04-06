package ka.shardingjdbc.controller;


import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.tags.Tag;
import ka.shardingjdbc.entity.TmPhoneP;
import ka.shardingjdbc.repo.TmPhoneRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.sql.DataSource;

@RestController
@Slf4j
@RequestMapping("/phones")
@Tag(
        name = "PhoneControllerAPI",
        description = "手机号控制器接口",
        externalDocs = @ExternalDocumentation(
                description = "这是一个接口文档介绍",
                url = "https://www.cnblogs.com/antLaddie/"))
public class PhoneController {

    @Resource
    private TmPhoneRepository tmPhoneRepository;

    @Resource
    DataSource dataSource;

    @GetMapping("/phone/{phone}")
    public TmPhoneP findByPhone(@PathVariable Long phone) {
        return tmPhoneRepository.findByPhone(phone); // 假设你已经定义了这样的查询方法  
    }

    @GetMapping("/encryptPhone/{encryptPhone}")
    public TmPhoneP findByPhone(@PathVariable String encryptPhone) {
        return tmPhoneRepository.findByEncryptPhone(encryptPhone); // 假设你已经定义了这样的查询方法
    }

    @PostMapping("/insert")
    public TmPhoneP insert(Long phone) {
        TmPhoneP tmPhoneP = new TmPhoneP();
        tmPhoneP.setEncryptPhone(phone + "");
        tmPhoneP.setPhone(phone);
        tmPhoneP = tmPhoneRepository.save(tmPhoneP);
        return tmPhoneP; // 假设你已经定义了这样的查询方法
    }

}


