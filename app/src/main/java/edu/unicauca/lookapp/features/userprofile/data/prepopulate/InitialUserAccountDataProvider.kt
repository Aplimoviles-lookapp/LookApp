package edu.unicauca.lookapp.features.userprofile.data.prepopulate

import edu.unicauca.lookapp.features.userprofile.data.entities.UserAccountEntity

object InitialUserAccountDataProvider {

    fun getAccounts(): List<UserAccountEntity> = listOf(
        UserAccountEntity(
            name = "Freider",
            email = "freider@gmail.com"
        ),
        UserAccountEntity(
            name = "Naren",
            email = "naren@gmail.com"
        ),
        UserAccountEntity(
            name = "Ruben",
            email = "ruben@gmail.com"
        )
    )
}