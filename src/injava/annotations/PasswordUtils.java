/*
 * Copyright (c) 2016 xiaomaihd and/or its affiliates.All Rights Reserved.
 *            http://www.xiaomaihd.com
 */
package injava.annotations;

import java.util.List;

/**
 * Created by YangFan on 2016/10/8 下午4:55.
 * <p/>
 */
public class PasswordUtils {
    @UseCase(id = 47, description = "Passwords must contain at least one numeric")
    public boolean validatePasword(String password) {
        return (password.matches("\\w*\\d\\w*"));
    }

    @UseCase(id = 48)
    public String encryptPassword(String password) {
        return new StringBuilder(password).reverse().toString();
    }


    @UseCase(id = 49, description = "New password can't equal previously used ones")
    public boolean checkForNewPassword(List<String> prevPasswords, String password) {
        return !prevPasswords.contains(password);
    }
}
