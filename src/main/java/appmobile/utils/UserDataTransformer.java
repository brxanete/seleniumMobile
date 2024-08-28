package appmobile.utils;

import appmobile.models.UserData;
import org.jetbrains.annotations.NotNull;

import java.util.Map;

public class UserDataTransformer {
    public UserData transformLoginData(@NotNull Map<String, String> entry) {
        String typeId = entry.get("typeId");
        String id = entry.get("id");
        String password = entry.get("password");
        String otp = entry.get("otp");
        String newPassword = entry.get("newPassword");

        return new UserData(typeId, id, password, otp, newPassword);


    }




}