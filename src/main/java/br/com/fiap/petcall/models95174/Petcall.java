package br.com.fiap.petcall.models95174;

import java.util.Objects;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "tb_tutor_95174")
public class Petcall {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank(message = "Campo requerido")
	@Size(min = 3, message = "O nome do campo deve ter no mínimo 3 caracteres")
	private String nome;
	@NotBlank(message = "Campo requerido")
	private String cpf;
	@NotBlank(message = "Campo requerido")
	@Email(message = "E-mail inválido")
	private String email;
	@NotBlank(message = "Campo requerido")
	@Size(min = 3, message = "O endereço deve ter no mínimo 3 caracteres")
	private String endereco;
	
	public Petcall() {
	}

	public Petcall(Long id, String nome, String cpf, String email, String endereco) {
		this.id = id;
		this.nome = nome;
		this.cpf = cpf;
		this.email = email;
		this.endereco = endereco;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	@Override
	public int hashCode() {
		return Objects.hash(cpf, email, endereco, id, nome);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Petcall other = (Petcall) obj;
		return Objects.equals(cpf, other.cpf) && Objects.equals(email, other.email)
				&& Objects.equals(endereco, other.endereco) && Objects.equals(id, other.id)
				&& Objects.equals(nome, other.nome);
	}

	@Override
	public String toString() {
		return "Petcall [id=" + id + ", nome=" + nome + ", cpf=" + cpf + ", email=" + email + ", endereco=" + endereco
				+ "]";
	}

	
	
}
