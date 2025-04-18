package edu.unicauca.lookapp.core.ui.navigation

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.Scaffold
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import edu.unicauca.lookapp.core.ui.components.BottomNavBar
import edu.unicauca.lookapp.core.ui.components.ModalDrawerContent
import edu.unicauca.lookapp.core.ui.components.TopAppBar
import edu.unicauca.lookapp.core.ui.screen.credits.CreditsScreen
import edu.unicauca.lookapp.core.ui.viewmodel.MainViewModel
import edu.unicauca.lookapp.features.home.ui.screen.Home
import edu.unicauca.lookapp.features.notifications.ui.screen.NotificationScreen
import edu.unicauca.lookapp.features.saved.ui.screen.SavedScreen
import edu.unicauca.lookapp.features.saved.ui.viewmodel.SavedViewModel
import edu.unicauca.lookapp.features.search.ui.screen.SearchScreen
import edu.unicauca.lookapp.features.userprofile.ui.screen.UserProfileScreen
import kotlinx.coroutines.launch



@Composable
fun NavigationApp(modifier: Modifier = Modifier, mainViewModel: MainViewModel = hiltViewModel()) {
    LaunchedEffect(Unit) {
        mainViewModel.loadInitialData()
    }
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route
    val titleRes = RouteEnum.fromRoute(currentRoute ?: RouteEnum.Home.route)

    /*navController.navigate("route") {
        launchSingleTop = true
        popUpTo(navController.graph.startDestinationId) {
            saveState = true
        }
    }*/

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerContent(
                onNavigate = { route ->
                    navController.navigate(route) {
                        popUpTo(0)
                        launchSingleTop = true
                    }
                },
                drawerState = drawerState,
                scope = scope
            )
        },
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
                    SavedScreen(mainViewModel = mainViewModel)
                }
                composable(route = RouteEnum.Profile.route) {
                    UserProfileScreen(mainViewModel = mainViewModel)
                }
                composable(route = RouteEnum.Notifications.route) {
                    NotificationScreen()
                }

                composable(route = RouteEnum.Search.route) {
                    SearchScreen()
                }

                composable(route = RouteEnum.Credits.route){
                    CreditsScreen()
                }

            }
        }
    }

}