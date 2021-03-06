/*
Copyright (c) 2007-2011, Yusuke Yamamoto
All rights reserved.

Redistribution and use in source and binary forms, with or without
modification, are permitted provided that the following conditions are met:
    * Redistributions of source code must retain the above copyright
      notice, this list of conditions and the following disclaimer.
    * Redistributions in binary form must reproduce the above copyright
      notice, this list of conditions and the following disclaimer in the
      documentation and/or other materials provided with the distribution.
    * Neither the name of the Yusuke Yamamoto nor the
      names of its contributors may be used to endorse or promote products
      derived from this software without specific prior written permission.

THIS SOFTWARE IS PROVIDED BY Yusuke Yamamoto ``AS IS'' AND ANY
EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
DISCLAIMED. IN NO EVENT SHALL Yusuke Yamamoto BE LIABLE FOR ANY
DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
(INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
(INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/
package twitter4j;

/**
 * @author Yusuke Yamamoto - yusuke at mac.com
 * @since Twitter4J 2.1.8
 */
public interface SiteStreamsListener extends StreamListener {
    void onStatus(int forUser, Status status);

    void onDeletionNotice(int forUser, StatusDeletionNotice statusDeletionNotice);

    /**
     * @param forUser   the user id to whom sent the event
     * @param friendIds
     */
    void onFriendList(int forUser, int[] friendIds);

    /**
     * @param forUser         the user id to whom sent the event
     * @param source
     * @param target
     * @param favoritedStatus
     */
    void onFavorite(int forUser, User source, User target, Status favoritedStatus);

    /**
     * @param forUser           the user id to whom sent the event
     * @param target
     * @param unfavoritedStatus
     */
    void onUnfavorite(int forUser, User source, User target, Status unfavoritedStatus);

    /**
     * @param forUser      the user id to whom sent the event
     * @param source
     * @param followedUser
     */
    void onFollow(int forUser, User source, User followedUser);

    /**
     * @param forUser        the user id to whom sent the event
     * @param source
     * @param unfollowedUser
     * @since Twitter4J 2.1.11
     */
    void onUnfollow(int forUser, User source, User unfollowedUser);

    /**
     * @param forUser       the user id to whom sent the event
     * @param directMessage
     */
    void onDirectMessage(int forUser, DirectMessage directMessage);

    void onDeletionNotice(int forUser, int directMessageId, int userId);

    /**
     * @param forUser     the user id to whom sent the event
     * @param addedMember
     * @param listOwner
     * @param list
     */
    void onUserListMemberAddition(int forUser, User addedMember, User listOwner, UserList list);

    /**
     * @param forUser       the user id to whom sent the event
     * @param deletedMember
     * @param listOwner
     * @param list
     */
    void onUserListMemberDeletion(int forUser, User deletedMember, User listOwner, UserList list);

    /**
     * @param forUser    the user id to whom sent the event
     * @param subscriber
     * @param listOwner
     * @param list
     */
    void onUserListSubscription(int forUser, User subscriber, User listOwner, UserList list);

    /**
     * @param forUser    the user id to whom sent the event
     * @param subscriber
     * @param listOwner
     * @param list
     */
    void onUserListUnsubscription(int forUser, User subscriber, User listOwner, UserList list);

    /**
     * @param forUser   the user id to whom sent the event
     * @param listOwner
     * @param list
     */
    void onUserListCreation(int forUser, User listOwner, UserList list);

    /**
     * @param forUser   the user id to whom sent the event
     * @param listOwner
     * @param list
     */
    void onUserListUpdate(int forUser, User listOwner, UserList list);

    /**
     * @param forUser   the user id to whom sent the event
     * @param listOwner
     * @param list
     */
    void onUserListDeletion(int forUser, User listOwner, UserList list);

    /**
     * @param forUser     the user id to whom sent the event
     * @param updatedUser updated user
     * @since Twitter4J 2.1.9
     */
    void onUserProfileUpdate(int forUser, User updatedUser);

    /**
     * @param forUser     the user id to whom sent the event
     * @param source
     * @param blockedUser
     */
    void onBlock(int forUser, User source, User blockedUser);

    /**
     * @param forUser       the user id to whom sent the event
     * @param source
     * @param unblockedUser
     */
    void onUnblock(int forUser, User source, User unblockedUser);

    void onException(Exception ex);
}
