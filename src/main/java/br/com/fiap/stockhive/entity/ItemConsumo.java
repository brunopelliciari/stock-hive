package br.com.fiap.stockhive.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Table (name = "T_ITEMCONSUMO")
public class ItemConsumo {
	
	@Id
	@SequenceGenerator (name = "SEQ_ID_ITEM_CONSUMO", allocationSize = 1)
	@GeneratedValue (generator = "SEQ_ID_ITEM_CONSUMO", strategy = GenerationType.SEQUENCE)
	@Column (name = "IDITEMCONSUMO")
	private Integer itemConsumoId;
	
	@Column(name = "NOME")
	private String nome;
	
	@Column(name = "QUANTIDADE")
	private Integer quantidade;
	
	@Column(name = "PRECO")
	private Double precoMedio;
	
	@Column(name = "MARCA")
	private String marca;
	
	@ManyToOne
	@JoinColumn (name = "ID_FORNECEDOR", nullable = false)
	private Fornecedor fornecedor;
	
	@ManyToOne
	@JoinColumn(name= "ID_ITEMGENERICO", nullable = false)
	private ItemConsumoGenerico itemGenerico;
	
	


}
