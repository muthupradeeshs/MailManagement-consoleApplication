package com.muthupradeesh.mailmanagement.usermanagement;

import com.muthupradeesh.mailmanagement.repository.MailRepository;

public class UserManagementViewModel {
	public boolean userIsFound(String userId) {
		if (MailRepository.getDb().getUserDetails().containsKey(userId)) {
			return true;
		}
		return false;

	}
}