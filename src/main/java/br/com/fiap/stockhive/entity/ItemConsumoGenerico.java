package br.com.fiap.stockhive.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table ( name = "T_ITEMGENERICO")
public class ItemConsumoGenerico {
	
	@Id
	@SequenceGenerator (name = "SEQ_ID_ITEM_CONSUMO_GENERICO", allocationSize = 1)
	@GeneratedValue ( generator = "SEQ_ID_ITEM_CONSUMO_GENERICO", strategy = GenerationType.SEQUENCE)
	@Column (name = "IDITEMGENERICO")
	private Integer itemConsumoGenericoId;
	
	@Column (name = "NOME")
	private String nome;
	
	@Column (name = "PRECO_MEDIO")
	private Double precoMedio;
	
	@Column (name = "QUANTIDADE_TOTAL")
	private Integer quantidadeTotal;
	
	@OneToMany (mappedBy = "itemGenerico")
	@Column ( name = "ITENS_INCLUSOS")
	private List<ItemConsumo> itensConsumo;

}
