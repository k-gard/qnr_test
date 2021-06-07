package gr.qnr.EmployeeInfo.models;

public class GenericResponse<T> {
    private Error error;
    private T data;

    public GenericResponse(T data) {
        this.data = data;
    }

    public GenericResponse(Error error) {
        this.error = error;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
