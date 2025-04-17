package edu.unicauca.lookapp.features.userprofile.domain.usecases

import edu.unicauca.lookapp.features.userprofile.data.repository.UserAccountRepository
import javax.inject.Inject

class SingnoutAllAccountsUseCase @Inject constructor(
    private val userAccountRepository: UserAccountRepository
) {
    suspend operator fun invoke() {
        userAccountRepository.deleteAll()
    }
}