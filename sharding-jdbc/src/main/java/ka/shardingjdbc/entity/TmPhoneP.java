package ka.shardingjdbc.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "tm_phone", indexes = {
        @Index(name = "encryptPhone_index", columnList = "encryptPhone"),
        @Index(name = "phone_index", columnList = "phone"),
})
public class TmPhoneP {


    @Column(length = 32)
    private String encryptPhone;

    @Id
    private Long phone;

}