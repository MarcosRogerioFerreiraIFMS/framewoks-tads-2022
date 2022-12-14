package br.edu.ifms.ordem.repositories;

import java.util.Optional;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import br.edu.ifms.ordem.entities.Tecnico;

@DataJpaTest
public class TecnicoRepositoryTests {
	
	@Autowired
	private TecnicoRepository repository;
	
	/*
	 * Acesso a Dados
	 * CRUD - Create, Read, Update and Delete
	 */
	
	/**
	 * DELETE
	 * deveria EXCLUIR REGISTRO [quando O ID EXISTIR]
	 */
	@Test
	public void deleteDeveriaExcluirRegistroQuandoIdExistir() {
		//Arrange
		Long idConsultado = 1L;
		
		//Act
		repository.deleteById(idConsultado);
		
		//Assert
		Optional<Tecnico> resultado; 
		resultado = repository.findById(idConsultado);
		Assertions.assertFalse(resultado.isPresent());
	}
	
	
	
}
