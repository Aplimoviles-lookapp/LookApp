package edu.unicauca.lookapp.ui.screen.userprofile

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.Logout
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExtendedFloatingActionButton
import androidx.compose.material3.FloatingActionButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import edu.unicauca.lookapp.R

@Composable
fun AccountsSection(
    accounts: List<UserAccount>,
    modifier: Modifier = Modifier,
    onClickedAccount: (UserAccount) -> Unit = {},
    onClickedAddAccount: () -> Unit = {},
    onClickedLoggoutAll: () -> Unit = {},
) {
    Surface(
        modifier = modifier
            .fillMaxWidth()
            .padding(30.dp),
        color= MaterialTheme.colorScheme.surface

    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier.fillMaxSize().padding(16.dp)
        ) {
            Text(
                stringResource(R.string.acc_sec_your_account),
                style = MaterialTheme.typography.labelLarge,
                modifier = Modifier.align(Alignment.Start)
            )
            Spacer(modifier = Modifier.height(16.dp))
            UserAccountItemList(
                list = accounts,
                onClickedAccount = onClickedAccount
            )
            Spacer(modifier = Modifier.height(40.dp))
            ExtendedFloatingActionButton(
                onClick = onClickedAddAccount,
                icon = {
                    Icon(
                        imageVector = Icons.Filled.Add,
                        contentDescription = "Extended floating action button.",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                text = {
                    Text(
                        text = stringResource(R.string.accounts_add_another_account),
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                modifier = Modifier.width(320.dp),
                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 6.dp),
                containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,


                )

            Spacer(modifier = Modifier.height(16.dp))

            ExtendedFloatingActionButton(
                onClick = onClickedLoggoutAll,
                icon = {
                    Icon(
                        imageVector = Icons.AutoMirrored.Filled.Logout,
                        contentDescription = "Extended floating action button.",
                        tint = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                },
                text = {
                    Text(
                        text = stringResource(R.string.accounts_loggout_all),
                        color = MaterialTheme.colorScheme.primary
                    )
                },
                modifier = Modifier.width(320.dp),
                elevation = FloatingActionButtonDefaults.elevation(defaultElevation = 6.dp),
                containerColor = MaterialTheme.colorScheme.surfaceContainerHigh,

                )
        }
    }
}

@Preview(showBackground = true, locale = "es")
@Composable
fun AccountsSectionPreview() {
    AccountsSection(
        accounts = listOf(
            UserAccount("Juan", "Juan@gmail.com"),
            UserAccount("Naren", "Naren@gmail.com"),
            UserAccount("Freider", "Freider@gmail.com"),
        ),
    )
}