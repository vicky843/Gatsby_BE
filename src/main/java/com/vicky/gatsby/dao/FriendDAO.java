package com.vicky.gatsby.dao;

import java.util.List;

import com.vicky.gatsby.model.Friend;

public interface FriendDAO {
	public List<Friend> getMyFriends(String username);  //BY USERID
	public List<Friend> getMyFriend(String friendId);
	public Friend get(String username, String friendId );
	public boolean save(Friend friend);
	public boolean update(Friend friend);
	public void delete(String username, String friendId);
	public List<Friend> getNewFriendRequests(String friendId);
	public void setOnline(String friendId);
	public void setOffLine(String friendId);
}
