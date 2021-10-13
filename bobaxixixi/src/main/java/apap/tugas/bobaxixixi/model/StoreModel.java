package apap.tugas.bobaxixixi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalTime;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "store")
public class StoreModel implements Serializable {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStore;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama_store", nullable = false)
    private String namaStore;

    @NotNull
    @Size(max = 255)
    @Column(name = "alamat_store", nullable = false)
    private String alamatStore;

    @NotNull
    @Size(max = 12)
    @Column(name = "notelp_store", nullable = false)
    private String noTeleponStore;

    @NotNull
    @Size(max = 10)
    @Column(name = "store_code", nullable = false, unique = true)
    private String store_code;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime jamBuka;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "HH:mm")
    private LocalTime jamTutup;

    //relasi dengan manager (child)
    @OneToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idManager", referencedColumnName = "idManager", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE) //perlu ga ya? kan manager bisa diganti
    private ManagerModel manager;

    // //relasi dengan store boba tea (parent)
    @OneToMany(mappedBy = "id_store", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<StoreBobaTeaModel> bobas;

}
