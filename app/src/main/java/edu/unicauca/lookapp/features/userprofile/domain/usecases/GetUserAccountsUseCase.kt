package edu.unicauca.lookapp.features.userprofile.domain.usecases

import edu.unicauca.lookapp.features.userprofile.data.repository.UserAccountRepository
import javax.inject.Inject

class GetUserAccountsUseCase @Inject constructor (
    private val userAccountRepository: UserAccountRepository
) {
    operator fun invoke() = userAccountRepository.getAll()
}