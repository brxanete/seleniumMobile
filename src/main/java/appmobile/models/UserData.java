package appmobile.models;


public class UserData {
    private final String typeId;
    private final String id;
    private final String password;
    private final String otp;
    private final String newPassword;


    public UserData(String typeId, String id, String password, String otp, String newPassword) {
        this.typeId = typeId;
        this.id = id;
        this.password = password;
        this.otp = otp;
        this.newPassword = newPassword;
    }

    public String getTypeId() {
        return typeId;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getOtp() {
        return otp;
    }

    public String getNewPassword() {
        return newPassword;
    }
}




