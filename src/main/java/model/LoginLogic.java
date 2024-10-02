package model;

public class LoginLogic {
	public boolean execute(Login login) {
		if (login.getPass().equals("0000")) {
			return true;
		}
		return false;
	}
}
