package com.Brafe.Brafe.domain.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "TAB_COMPRA")
public class CompraEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COMPRA")
    private Long id;

    @Column(name = "VALOR_TOTAL")
    private Double valorTotal;

    @Column(name = "DATA_COMPRA", nullable = false)
    private Date data;

    @OneToOne
    @JoinColumn(name = "ID_USUARIO")
    private UsuarioEntity usuario;

    @OneToOne
    @JoinColumn(name = "ID_ENDERECO")
    private EnderecoEntity endereco;

    @OneToOne
    @JoinColumn(name = "ID_PAGAMENTO")
    private PagamentoEntity pagamento;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "TEM",
            joinColumns = @JoinColumn(name = "ID_COMPRA", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "ID_PRODUTO", nullable = false)
    )
    private Set<ProdutoEntity> produtos = new HashSet<>();

    @PrePersist
    protected void prePersist() {
        if (this.data == null) data = new Date();
    }
}