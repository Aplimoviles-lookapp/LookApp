package edu.unicauca.lookapp.features.userprofile.domain.usecases

import edu.unicauca.lookapp.features.userprofile.data.entities.UserAccountEntity
import edu.unicauca.lookapp.features.userprofile.data.repository.UserAccountRepository
import javax.inject.Inject

class AddUserAccountUseCase @Inject constructor(
    private val userAccountRepository: UserAccountRepository
) {
    private val randomAccounts = listOf(
        UserAccountEntity(name = "John Doe", email = "john.doe@example.com"),
        UserAccountEntity(name = "Jane Smith", email = "jane.smith@example.com"),
        UserAccountEntity(name = "Alice Johnson", email = "alice.johnson@example.com"),
        UserAccountEntity(name = "Bob Brown", email = "bob.brown@example.com")
    )

    suspend operator fun invoke() {
        userAccountRepository.insertUserAccount(randomAccounts.random())
    }

}