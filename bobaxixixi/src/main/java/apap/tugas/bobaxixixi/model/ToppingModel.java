package apap.tugas.bobaxixixi.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Setter @Getter
@Entity
@Table(name = "topping")
public class ToppingModel implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idTopping;

    @NotNull
    @Size(max = 255)
    @Column(name = "nama", nullable = false)
    private String namaTopping;

    @NotNull
    @Column(name = "harga", nullable = false)
    private int harga;

    //relasi dengan BobaTea
    @OneToMany(mappedBy = "topping", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private List<BobaTeaModel> listBobaTea;

}
