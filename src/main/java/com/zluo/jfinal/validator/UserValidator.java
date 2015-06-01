package com.zluo.jfinal.validator;

import com.jfinal.core.Controller;
import com.jfinal.validate.Validator;
import com.zluo.jfinal.model.UserModel;

public class UserValidator extends Validator {

	@Override
	protected void handleError(Controller c) {
		c.keepModel(UserModel.getModel().getClass());
		c.renderFreeMarker("login.html");
	}

	@Override
	protected void validate(Controller c) {
		validateRequired("username", "username", "name is null");
	}

}
