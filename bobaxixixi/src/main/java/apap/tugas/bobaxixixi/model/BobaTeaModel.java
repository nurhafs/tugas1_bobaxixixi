package apap.tugas.bobaxixixi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import java.util.List;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "boba_tea")
public class BobaTeaModel implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBoba;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String namaBoba;

    @NotNull
    @Column(name = "harga", nullable = false)
    private int harga;

    @NotNull
    @Column(name = "size", nullable = false)
    private int size;

    @NotNull
    @Column(name = "ice_level", nullable = false)
    private int ice_level;

    @NotNull
    @Column(name = "sugar_level", nullable = false)
    private int sugar_level;

    //relasi dengan Topping
    @ManyToOne(fetch = FetchType.EAGER, optional = false)
    @JoinColumn(name = "idTopping", referencedColumnName = "idTopping", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    private ToppingModel topping;

    // //relasi dengan store boba tea (parent)
    @OneToMany(mappedBy = "id_boba", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<StoreBobaTeaModel> stores;
}
