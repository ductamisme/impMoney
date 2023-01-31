package com.example.impmoney.data

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import com.example.mymoney.R
import com.example.mymoney.ui.screen.mainscreen.*

sealed class BottomNavigationItem(var route: String, var icon : Int, var title : String){
    object Trans : BottomNavigationItem("trans", R.drawable.bottom_library_books_24,"Trans")
    object Stats : BottomNavigationItem("stats", R.drawable.bottom_insert_chart_outlined_24,"Stats")
    object Account : BottomNavigationItem("account", R.drawable.bottom_monetization_on_24,"Account")
    object More : BottomNavigationItem("more", R.drawable.bottom_more_horiz_24,"More")

}

typealias ComposableFun = @Composable () -> Unit

sealed class TabBarNavgationItemTrans(var route: String, var title : String, var screen: ComposableFun){
    object Daily : TabBarNavgationItemTrans("daily","Daily", { DailyScreen() })
    object Calendar : TabBarNavgationItemTrans("calendar","Calendar",{ CalenderScreen() })
    object Weekly : TabBarNavgationItemTrans("weekly","Weekly",{ WeeklyScreen() })
    object Monthly : TabBarNavgationItemTrans("monthly","Monthly",{ MonthlyScreen() })
    object Total : TabBarNavgationItemTrans("total","Total",{ TotalScreen() })
}

sealed class MoreScreenIcon(var route: String,var icon: Int, var title: String){
    object Configuration : MoreScreenIcon("Configuration",R.drawable.baseline_settings_24,"Configuration")
    object Account : MoreScreenIcon("Account",R.drawable.baseline_token_24,"Account")
    object Passcode : MoreScreenIcon("Passcode",R.drawable.baseline_lock_open_24,"Passcode")
    object Style : MoreScreenIcon("Style",R.drawable.baseline_color_lens_24,"Style")
    object PCManager : MoreScreenIcon("PC Manager",R.drawable.baseline_desktop_mac_24,"PC Manager")
    object BackUp : MoreScreenIcon("BackUp",R.drawable.baseline_settings_backup_restore_24,"BackUp")
    object FeedBack : MoreScreenIcon("FeedBack",R.drawable.baseline_feed_24,"FeedBack")
    object Help : MoreScreenIcon("Help",R.drawable.baseline_help_outline_24,"Help")
    object Recommend : MoreScreenIcon("Recommend",R.drawable.baseline_recommend_24,"Recommend")

}
