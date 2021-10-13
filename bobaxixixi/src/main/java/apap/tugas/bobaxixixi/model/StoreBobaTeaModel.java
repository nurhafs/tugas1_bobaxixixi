package apap.tugas.bobaxixixi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "store_boba_tea")
public class StoreBobaTeaModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idStoreBoba;

    @NotNull
    @Size(max = 12)
    @Column(name = "production_code", nullable = false, unique = true)
    private String prodCode;

    //relasi dengan store (child)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idStore", referencedColumnName = "idStore", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private StoreModel id_store;

    //relasi dengan boba tea (child)
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idBoba", referencedColumnName = "idBoba", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private BobaTeaModel id_boba;
}
