package ua.keep.formvalidator;

public class RegisterFormValidator {

    private String userName;
    private String email;
    private String password;
    private String messageError;

    private interface CheckField {
        boolean isCorrect(String field);
    }

    public RegisterFormValidator() {
    }

    public RegisterFormValidator(String userName, String email, String password) {
        this.userName = userName;
        this.email = email;
        this.password = password;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMessageError() {
        return messageError;
    }

    public boolean isFormValid() {

        // check userName min 4 letters
        CheckField checkFieldMin4 = field -> {
            if ( field.length() < 4 ) {
                messageError = "Minimus 4 leters in password!";
                return false;
            }
            return true;
        };
        if ( ! checkFieldMin4.isCorrect(userName)) {
            return false;
        }

        //check email if correct
        CheckField checkFieldEmail = field -> {
            boolean res =  field.matches("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                    + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
            if (! res) {
                messageError = "Invalid Email!";
            }
            return res;
        };

        if ( ! checkFieldEmail.isCorrect(email)) {
            return false;
        }

        //check password minimun 4
        if ( ! checkFieldMin4.isCorrect(password)) {
            return false;
        }

        // check password has min 1 number
        CheckField checkFieldMin1Number = field -> {
            boolean res = field.matches("");
            if (! res) {
                messageError = "Password should contains a number!";
            }
            return true;
        };
        if ( ! checkFieldMin1Number.isCorrect(password)) {
            return false;
        }

        return true;
    }
}
