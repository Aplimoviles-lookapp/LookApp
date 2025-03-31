package edu.unicauca.lookapp.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import edu.unicauca.lookapp.R
import edu.unicauca.lookapp.ui.components.BottomNavBar
import edu.unicauca.lookapp.ui.components.ModalDrawerContent
import edu.unicauca.lookapp.ui.components.TopAppBar
import edu.unicauca.lookapp.ui.screen.dummy.DummyScreen
import edu.unicauca.lookapp.ui.screen.home.Home
import edu.unicauca.lookapp.ui.screen.notifications.NotificationScreen
import edu.unicauca.lookapp.ui.screen.saved.SavedScreen
import edu.unicauca.lookapp.ui.screen.search.SearchScreen
import edu.unicauca.lookapp.ui.screen.userprofile.UserProfileScreen
import kotlinx.coroutines.launch



@Composable
fun NavigationApp(modifier: Modifier = Modifier) {
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val titleRes = RouteEnum.fromRoute(currentRoute ?: RouteEnum.Home.route)


    ModalNavigationDrawer(
        drawerContent = { ModalDrawerContent() },
        drawerState = drawerState,
        gesturesEnabled = currentRoute != RouteEnum.Search.route,
    ) {
        Scaffold(
            topBar = {
                TopAppBar(
                    title = titleRes,
                    onClickActionButton = {
                        navController.navigate(route = RouteEnum.Profile.route)


                    },
                    onClickNavIcon = {
                        scope.launch {
                            if (drawerState.isClosed) {
                                drawerState.open()
                            } else {
                                drawerState.close()
                            }
                        }
                    },
                )
            },
            bottomBar = {
                BottomNavBar(
                    currentRoute = currentRoute ?: RouteEnum.Home.route,
                    onNavigate = navController::navigate
                )
            },
        ) { innerPadding ->
            NavHost(
                navController = navController,
                startDestination = "home",
                Modifier.padding(innerPadding)
            ) {
                composable(route = RouteEnum.Home.route) {
                    Home()
                }
                composable(route = RouteEnum.Saved.route) {
                    SavedScreen()
                }
                composable(route = RouteEnum.Profile.route) {
                    UserProfileScreen()
                }
                composable(route = RouteEnum.Notifications.route) {
                    NotificationScreen()
                }

                composable(route = RouteEnum.Search.route) {
                    SearchScreen()
                }

            }
        }
    }

}