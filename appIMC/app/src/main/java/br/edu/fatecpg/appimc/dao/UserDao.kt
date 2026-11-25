package br.edu.fatecpg.appimc.dao

import br.edu.fatecpg.appimc.model.User

class UserDao {
    companion object {
        private var user = User()

        fun salvar(peso: Double, altura: Double): String {
            user.altura = altura
            user.peso = peso
            return "Aluno salvo!"
        }

        fun buscar(): User{
            return user
        }
    }
}