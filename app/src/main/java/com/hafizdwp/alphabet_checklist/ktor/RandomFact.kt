package com.hafizdwp.alphabet_checklist.ktor

import kotlinx.serialization.Serializable

/**
 * @author hafizdwp
 * 20/05/2021
 **/
@Serializable
data class RandomFact(
        var login: String? = null,
        var id: Int? = null,
        var node_id: String? = null,
        var avatar_url: String? = null,
        var gravatar_id: String? = null,
        var url: String? = null,
        var html_url: String? = null,
        var followers_url: String? = null,
        var following_url: String? = null,
        var gists_url: String? = null,
        var starred_url: String? = null,
        var subscriptions_url: String? = null,
        var organizations_url: String? = null,
        var repos_url: String? = null,
        var events_url: String? = null,
        var received_events_url: String? = null,
        var type: String? = null,
        var site_admin: Boolean? = null,
        var name: String? = null,
        var blog: String? = null,
        var bio: String? = null,
        var public_repos: Int? = null,
        var public_gists: Int? = null,
        var followers: Int? = null,
        var following: Int? = null,
        var created_at: String? = null,
        var updated_at: String? = null
)