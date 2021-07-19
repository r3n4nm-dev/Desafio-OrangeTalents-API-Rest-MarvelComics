package com.renanmateus.comic.domain.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.renanmateus.comic.domain.model.Usuario;
import com.renanmateus.comic.domain.model.UsuarioId;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, UsuarioId> {

	Optional<Usuario> findFirstByIdCpfOrIdEmail(String cpf, String email);
	Optional<Usuario> findByIdCpfOrIdEmail(String cpf, String email);
}
