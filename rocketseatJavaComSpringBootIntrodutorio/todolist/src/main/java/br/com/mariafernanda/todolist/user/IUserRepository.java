package br.com.mariafernanda.todolist.user;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface IUserRepository extends JpaRepository<UserModel, UUID> {
    /* essa interface extend a JpaRepository o que transforma ela em um repositório JPA,
       ou seja, ganha método para acessar o banco de dados
     * UserModel, enitdade que vai ser gerenciada
     * UUID, tipo de ID(pk)
     * */

    //a jpa interpreta o nome do método e gera a consulta (Query Method Naming)
    UserModel findByUsername(String username); //consulta pelo username

}
