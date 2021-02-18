package com.haydikodlayalim.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "adres")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(of = {"id"})
@ToString
public class Adres implements Serializable {
    @Id
    @SequenceGenerator(name = "seq_kisi_adres",allocationSize = 1)
    @GeneratedValue(generator = "seq_kisi_adres", strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(length = 500)
    private String adres;

    @Enumerated
    private AdresTip adresTip;

    @Column
    private Boolean aktif;

    @ManyToOne //fetch = FetchType.LAZY -> Sadece bu kişinin getter metodu çağrılırsa alınır.
    @JoinColumn(name = "kisi_adres_id")
    private Kisi kisi;

    public enum AdresTip {
        EV_ADRESI,
        IS_ADRESI,
        DIGER
    }
}
