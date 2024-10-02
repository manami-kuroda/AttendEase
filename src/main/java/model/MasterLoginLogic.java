package model;

public class MasterLoginLogic {
	public boolean execute(Login login) {
		if (login.getPass().equals("1234")) {
			return true;
		}
		return false;
	}
}
