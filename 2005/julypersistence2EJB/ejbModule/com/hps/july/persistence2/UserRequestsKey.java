package com.hps.july.persistence2;
/**
 * Key class for Entity Bean: UserRequests
 */
public class UserRequestsKey implements java.io.Serializable {
	static final long serialVersionUID = 3206093459760846163L;
	/**
	 * Implementation field for persistent attribute: request
	 */
	public int request;
	/**
	 * Creates an empty key for Entity Bean: UserRequests
	 */
	public UserRequestsKey() {
	}
	/**
	 * Creates a key for Entity Bean: UserRequests
	 */
	public UserRequestsKey(int request) {
		this.request = request;
	}
	/**
	 * Returns true if both keys are equal.
	 */
	public boolean equals(java.lang.Object otherKey) {
		if (otherKey instanceof com.hps.july.persistence2.UserRequestsKey) {
			com.hps.july.persistence2.UserRequestsKey o =
				(com.hps.july.persistence2.UserRequestsKey) otherKey;
			return ((this.request == o.request));
		}
		return false;
	}
	/**
	 * Returns the hash code for the key.
	 */
	public int hashCode() {
		return ((new java.lang.Integer(request).hashCode()));
	}
}
