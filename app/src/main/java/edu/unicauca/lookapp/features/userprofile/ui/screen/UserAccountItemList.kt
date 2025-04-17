package edu.unicauca.lookapp.features.userprofile.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun UserAccountItemList(list:List<UserAccount>, onClickedAccount: (UserAccount?) -> Unit, modifier: Modifier =Modifier){
    Column(
        modifier = modifier,
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        list.forEach { account ->
            UserAccountItem(
                name = account.name,
                email = account.email,
                onClick = { onClickedAccount(account)}
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun UserAccountItemListPreview(){
    UserAccountItemList(
        list = listOf(
            UserAccount(0,"Juan","Juan@gmail.com"),
            UserAccount(0,"Naren","Naren@gmail.com"),
            UserAccount(0,"Freider","Freider@gmail.com"),
        ),
        onClickedAccount = {}
    )
}