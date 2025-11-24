package API.reqres.register;

public class SuccessReg {
    private Integer id;
    private String token;

    public SuccessReg() {}

    public SuccessReg(String token, Integer id) {
        this.token = token;
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public String getToken() {
        return token;
    }
}
