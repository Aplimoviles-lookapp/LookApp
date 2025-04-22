package edu.unicauca.lookapp.core.ui.navigation

import edu.unicauca.lookapp.R

enum class RouteEnum(val route: String, val title: Int) {
    Home("home", R.string.title_Home),
    Search("search", R.string.title_Search),
    Saved("saved", R.string.title_saved),
    Notifications("notifications",R.string.title_notifications),
    Profile("profile", R.string.title_user_data),
    Credits("Credits", R.string.title_credits);


    companion object {
        private val map = entries.associateBy(RouteEnum::route)
        fun fromRoute(route: String) = map[route]?.title ?: R.string.app_name
    }
}