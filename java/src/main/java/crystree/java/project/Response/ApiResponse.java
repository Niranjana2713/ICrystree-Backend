package crystree.java.project.Response;

public class ApiResponse<T> {
    
    private boolean success;
    private String message;
    private Integer status;
    private T data;

    // Constructors
    public ApiResponse(boolean success, String message, Integer status, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
        this.status = status;

    }

    public Integer getstatus() {
        return status;
    }

    public void setstatus(Integer status) {
        this.status = status;
    }

    // Getters and Setters
    public boolean issuccess() {
        return success;
    }

    public void setsuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}
