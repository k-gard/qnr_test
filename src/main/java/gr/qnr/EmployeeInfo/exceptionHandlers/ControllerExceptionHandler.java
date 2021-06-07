package gr.qnr.EmployeeInfo.exceptionHandlers;

import gr.qnr.EmployeeInfo.models.Error;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@ControllerAdvice
public class ControllerExceptionHandler {


    @ExceptionHandler(NullPointerException.class)
    public ResponseEntity<Error> handleNullPointerException(Exception e) {
        return new ResponseEntity<>(
                new Error(400,"Bad Request",
                        "A required value is not submitted"),
                null,
                HttpStatus.BAD_REQUEST);
    }



    @ExceptionHandler({MethodArgumentTypeMismatchException.class, MethodArgumentNotValidException.class,
            IllegalArgumentException.class})
    public ResponseEntity<Error> handleMethodArgumentTypeMismatch(Exception e) {
        return new ResponseEntity<>(
                new Error(400, "Bad Request", "Invalid parameter"),
                null,
                HttpStatus.BAD_REQUEST);
    }
}
