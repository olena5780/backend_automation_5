package api.pojo_classes.go_rest;

public class CreateGoRestUserWithoutLombok {

    /**
     * {
     *     "name": "",
     *     "gender": "",
     *     "email": "Ophelia.Mraz@hotmail.com",
     *     "status": ""
     * }
     */

    private String name;
    private String gender;
    private String email;
    private String status;

    private String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }



}
