package net.formula97.androidapps.sysinfocollector.logic.factory

import android.accounts.AccountManager
import android.content.Context
import android.os.UserManager
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import net.formula97.androidapps.sysinfocollector.domain.inventory.User

class UserFactory: AbstractInventoryBuilder<User>(), ContextInventoryInjector<User> {
    override fun fromContext(context: Context): User {
        // reports current user only
        val userManager = context.getSystemService(Context.USER_SERVICE) as UserManager
        return User().apply {
            login = userManager.userName
        }
    }

    override fun listFromContext(context: Context): MutableList<User> {
        val accountManager = AccountManager.get(context)
        val ret = mutableListOf<User>()

        // 動かんかも...
        GlobalScope.launch {
            accountManager.addOnAccountsUpdatedListener(
                { accounts -> accounts.forEach { ret.add(User(login = it.name ?: NOT_APPLICABLE)) }},
                null,
                true
            )
        }

        return ret
    }
}