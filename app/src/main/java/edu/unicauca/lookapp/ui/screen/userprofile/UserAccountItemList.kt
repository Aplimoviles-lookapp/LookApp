package edu.unicauca.lookapp.ui.screen.userprofile

import android.accounts.Account
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.foundation.lazy.items
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UserAccountItemList(list:List<UserAccount>,onClickedAccount: (UserAccount)->Unit, modifier: Modifier =Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(6.dp)
    ) {
        list.forEach { account ->
            UserAccountItem(
                name = account.name,
                email = account.email,
                onClick = {
                    onClickedAccount(account)
                }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserAccountItemListPreview(){
    UserAccountItemList(
        list = listOf(
            UserAccount("Juan","Juan@gmail.com"),
            UserAccount("Naren","Naren@gmail.com"),
            UserAccount("Freider","Freider@gmail.com"),
        ),
        onClickedAccount = {}
    )
}