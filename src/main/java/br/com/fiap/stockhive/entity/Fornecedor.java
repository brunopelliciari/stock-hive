package br.com.fiap.stockhive.entity;

import java.util.List;

import br.com.fiap.stockhive.entity.enums.Segmento;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Entity
@Table (name = "T_FORNECEDOR")
public class Fornecedor {
	
	@Id
	@SequenceGenerator (name = "SEQ_ID_FORNECEDOR", allocationSize = 25)
	@GeneratedValue(generator = "SEQ_ID_FORNECEDOR", strategy = GenerationType.SEQUENCE)
	@Column (name = "IDFORNECEDOR")
	private Long fornecedorId;
	
	@Column (name = "NOME")
	private String nome;
	
	@Column (name = "TELEFONE")
	private String telefone;
	
	@Column (name = "EMAIL")
	@Email
	private String email;
	
	@Enumerated (EnumType.STRING)
	@Column (name = "SEGMENTO")
	private Segmento segmento;
	
	@OneToMany ( mappedBy = "fornecedor")
	private List<ItemConsumo> itensConsumo;
	

}
