package apap.tugas.bobaxixixi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "manager")
public class ManagerModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idManager;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String namaManager;

    @NotNull
    @Column(name = "gender", nullable = false)
    private int gender;

    @NotNull
    @Column(nullable = false)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate date_of_birth;

    //relasi dengan store (parent)
    @OneToOne(mappedBy = "manager", fetch = FetchType.LAZY, cascade = CascadeType.ALL, optional = false)
    private StoreModel store;
}
